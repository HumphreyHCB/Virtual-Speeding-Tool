// the following sort methods are from
//https://khan4019.github.io/front-end-Interview-Questions/sort.html#bubbleSort

const { Benchmark } = require('./benchmark');

class sortingTesting extends Benchmark {

constructor() {
    super();
    
  }

  benchmark() {
    let array = []
    for (let index = 1000; index >= 0; index--) {
        array.push(index)        
    }
    var testtotal = 0;
    testtotal += this.bubbleSort(array)[1];
    testtotal += this.selectionSort(array)[1];
    testtotal += this.insertionSort(array)[1];
    testtotal += this.mergeSort(array)[1];
    testtotal += this.quickSort(array, 0, 500)[1];
    testtotal += this.heapSort(array)[1];
    // the second element for each array should always be 1
    return testtotal;
  }

  verifyResult(result) {

    return 6 === result;
  }


 bubbleSort(arr){
    var len = arr.length;
    for (var i = len-1; i>=0; i--){
      for(var j = 1; j<=i; j++){
        if(arr[j-1]>arr[j]){
            var temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
         }
      }
    }
    return arr;
 }

selectionSort(arr){
    var minIdx, temp, 
        len = arr.length;
    for(var i = 0; i < len; i++){
      minIdx = i;
      for(var  j = i+1; j<len; j++){
         if(arr[j]<arr[minIdx]){
            minIdx = j;
         }
      }
      temp = arr[i];
      arr[i] = arr[minIdx];
      arr[minIdx] = temp;
    }
    return arr;
  }

insertionSort(arr) 
  { 
      let i, key, j; 
      for (i = 1; i < arr.length; i++)
      { 
          key = arr[i]; 
          j = i - 1; 
     
          /* Move elements of arr[0..i-1], that are 
          greater than key, to one position ahead 
          of their current position */
          while (j >= 0 && arr[j] > key)
          { 
              arr[j + 1] = arr[j]; 
              j = j - 1; 
          } 
          arr[j + 1] = key; 
      } 
      return arr;
  } 

mergeSort(arr){
    var len = arr.length;
    if(len <2)
       return arr;
    var mid = Math.floor(len/2),
        left = arr.slice(0,mid),
        right =arr.slice(mid);
    //send left and right to the mergeSort to broke it down into pieces
    //then merge those
    return this.merge(this.mergeSort(left),this.mergeSort(right));
 }
merge(left, right){
    var result = [],
        lLen = left.length,
        rLen = right.length,
        l = 0,
        r = 0;
    while(l < lLen && r < rLen){
       if(left[l] < right[r]){
         result.push(left[l++]);
       }
       else{
         result.push(right[r++]);
      }
    }  
    //remaining part needs to be addred to the result
    return result.concat(left.slice(l)).concat(right.slice(r));
  }
quickSort(arr, left, right){
    var len = arr.length, 
    pivot,
    partitionIndex;
 
 
   if(left < right){
     pivot = right;
     partitionIndex = this.partition(arr, pivot, left, right);
     
    //sort left and right
    this.quickSort(arr, left, partitionIndex - 1);
    this.quickSort(arr, partitionIndex + 1, right);
   }
   return arr;
 }
partition(arr, pivot, left, right){
    var pivotValue = arr[pivot],
        partitionIndex = left;
 
    for(var i = left; i < right; i++){
     if(arr[i] < pivotValue){
       this.swap(arr, i, partitionIndex);
       partitionIndex++;
     }
   }
   this.swap(arr, right, partitionIndex);
   return partitionIndex;
 }
swap(arr, i, j){
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
 }
 
heapSort(arr){
    var len = arr.length,
        end = len-1;
  
    this.heapify(arr, len);
    
    while(end > 0){
     this.swap(arr, end--, 0);
     this.siftDown(arr, 0, end);
    }
    return arr;
  }
heapify(arr, len){
    // break the array into root + two sides, to create tree (heap)
    var mid = Math.floor((len-2)/2);
    while(mid >= 0){
     this.siftDown(arr, mid--, len-1);    
   }
 }
siftDown(arr, start, end){
    var root = start,
        child = root*2 + 1,
        toSwap = root;
    while(child <= end){
       if(arr[toSwap] < arr[child]){
         this.swap(arr, toSwap, child);
       }
       if(child+1 <= end && arr[toSwap] < arr[child+1]){
         this.swap(arr, toSwap, child+1)
       }
       if(toSwap != root){
          this.swap(arr, root, toSwap);
          root = toSwap;
       }
       else{
          return; 
       }
       toSwap = root;
       child = root*2+1
   }
 }
swap(arr, i, j){
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}

exports.newInstance = () => new sortingTesting();