// the following sort methods are from
//https://khan4019.github.io/front-end-Interview-Questions/sort.html#bubbleSort

const { Benchmark } = require('./benchmark');

class sortingTesting extends Benchmark {

constructor() {
    super();
    
  }

  benchmark() {
    const array = [689,933,814,165,708,587,281,395,117,176,475,542,601,260,107,249,244,156,716,210,476,609,665,289,177,811,826,128,795,977,345,562,907,495,327,794,135,70,503,337,877,367,202,251,498,852,344,575,469,793,810,190,412,290,511,743,374,604,132,98,502,559,230,863,627,947,666,648,348,610,19,101,520,812,307,172,857,442,799,465,989,625,660,493,131,102,154,931,750,106,860,41,978,959,910,129,895,372,336,213,378,239,971,313,700,804,870,731,362,368,314,226,312,492,763,266,15,89,655,954,951,35,2,837,46,33,991,58,499,461,400,691,283,237,69,370,937,133,642,161,48,50,522,998,889,667,651,510,815,88,110,438,223,594,80,173,234,119,967,825,130,669,42,191,215,268,466,893,585,706,9,440,349,850,94,545,881,355,621,386,179,280,854,514,843,86,776,644,192,974,529,869,561,636,883,55,5,855,74,63,408,288,749,571,558,180,865,297,551,57,556,934,315,451,975,303,961,335,376,900,504,238,595,170,452,194,791,705,32,12,30,909,944,473,682,481,326,929,780,729,807,284,548,544,458,183,538,11,121,211,753,894,813,904,405,534,309,856,77,62,221,704,491,273,662,430,274,528,582,310,432,252,346,434,73,126,265,182,602,339,459,111,413,501,982,40,127,835,328,554,23,573,174,175,652,518,940,535,447,402,318,943,713,479,611,456,997,868,385,445,718,626,304,935,809,60,439,639,664,96,574,841,608,925,66,140,541,677,922,847,995,59,953,271,950,340,200,380,269,199,936,537,253,279,742,509,455,817,390,37,768,765,754,849,891,540,363,263,197,422,668,464,484,44,500,525,693,727,414,49,622,103,441,453,777,92,983,14,364,277,697,906,723,404,647,688,254,214,724,1000,581,163,209,306,583,712,233,164,333,960,10,695,6,798,692,22,638,821,916,460,343,393,398,399,631,872,463,358,822,188,805,709,258,17,874,748,27,235,580,353,577,84,342,52,624,584,259,407,286,416,572,566,505,694,145,661,255,614,949,369,517,139,766,861,382,232,388,409,325,467,939,733,828,25,24,615,20,930,987,628,673,926,579,381,637,186,800,719,830,878,539,958,927,672,311,321,952,61,773,16,816,567,524,508,685,228,105,322,471,657,607,779,976,650,756,737,187,755,421,903,912,645,641,839,494,114,443,95,293,78,996,848,148,790,735,981,886,726,827,984,506,957,890,90,515,658,389,396,842,299,109,824,292,969,703,406,387,462,150,786,818,486,564,653,365,783,630,193,552,833,91,884,966,152,394,923,806,241,536,397,599,820,717,516,549,76,295,305,53,361,674,555,970,600,403,784,291,879,371,676,151,592,51,298,39,338,351,746,285,919,169,785,275,428,578,803,489,112,205,796,240,449,846,162,908,143,248,483,7,3,482,591,988,360,256,788,423,635,302,914,391,497,557,728,168,485,832,623,917,862,546,955,680,160,565,366,79,454,56,853,99,185,596,246,159,82,392,65,985,739,618,236,593,81,968,738,758,663,942,619,184,480,13,125,212,113,634,897,787,38,792,707,431,918,858,158,450,347,36,225,181,681,512,75,683,531,383,710,34,324,87,354,938,764,242,965,217,840,606,711,613,980,415,836,730,18,85,612,189,429,317,26,576,341,436,68,357,617,426,945,956,838,419,924,999,902,725,993,155,1,270,138,319,973,171,844,474,167,603,866,915,808,761,701,986,296,767,108,640,444,220,262,178,448,136,45,300,329,715,654,948,963,736,222,332,334,149,8,219,257,560,656,597,932,649,294,882,553,137,331,521,384,831,323,899,979,513,698,231,224,93,316,67,990,873,83,470,29,195,264,166,789,457,771,928,100,31,741,141,775,772,287,911,72,871,526,747,477,272,679,643,301,437,267,216,880,379,896,570,690,308,972,568,28,418,203,921,373,43,218,994,646,887,356,472,699,196,206,586,829,523,859,898,411,962,550,720,207,751,757,276,97,702,243,519,563,424,47,632,547,71,920,845,569,590,153,543,752,245,350,278,875,946,589,819,801,722,115,633,867,762,941,684,123,227,417,616,671,446,745,157,629,116,124,675,198,282,687,201,732,144,507,104,330,734,605,901,740,759,744,721,834,490,488,782,992,54,823,21,401,620,797,864,530,4,892,774,204,964,781,352,375,142,913,770,120,696,876,778,146,532,678,320,527,598,885,588,905,888,435,714,769,420,427,468,659,134,802,433,147,118,487,496,760,261,247,250,122,64,229,410,533,208,686,478,670,851,377,359,1];
    var testtotal = 0;
    testtotal += this.bubbleSort(array)[0];
    testtotal += this.selectionSort(array)[0];
    testtotal += this.insertionSort(array)[0];
    testtotal += this.mergeSort(array)[0];
    testtotal += this.quickSort(array, 0, 500)[0];
    testtotal += this.heapSort(array)[0];
     // the array contains a 1, and not 0
    // so the first element for a sorted array should always be 1
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


}

exports.newInstance = () => new sortingTesting();
