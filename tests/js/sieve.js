// the following methods are from
//https://stackoverflow.com/questions/15471291/sieve-of-eratosthenes-algorithm-in-javascript-running-endless-for-large-number

const { Benchmark } = require('./benchmark');

class sieve extends Benchmark {

constructor() {
    super();
    
  }

  benchmark() {

    var testtotal = 0;
    
    //this.sieve1(10000); - broken
    this.sieve2(100000);
    this.sieve3(100000);
    this.sieve4(100000);
    this.sieve5(100000);
    return testtotal;
  }

  verifyResult(result) {

    return true;
  }

    // this sieve use indexOf and other very costly methods
    //
   sieve1(n){
    var array = [];
    var tmpArray = []; // for containing unintentionally deleted elements like 2,3,5,7,...
    var maxPrimeFactor = 0;
    var upperLimit = Math.sqrt(n);
    var output = [];
    
    // Eratosthenes algorithm to find all primes under n
    
    // Make an array from 2 to (n - 1)
    //used as a base array to delete composite number from
    for(var i = 2; i < n; i++){
        array.push(i);
    }
    
    // Remove multiples of primes starting from 2, 3, 5,...
    for(var i = array[0]; i < upperLimit; i = array[0]){
        removeMultiples: 
        for(var j = i, k = i; j < n; j += i){
            var index = array.indexOf(j);
            if(index === -1)
                continue removeMultiples;
            else
                array.splice(index,1);
        }
        tmpArray.push(k);
    }
    array.unshift(tmpArray);
    return array;
    }


    sieve2(n) {
        // Eratosthenes algorithm to find all primes under n
        var array = [], upperLimit = Math.sqrt(n), output = [];
    
        // Make an array from 2 to (n - 1)
        for (var i = 0; i < n; i++) {
            array.push(true);
        }
    
        // Remove multiples of primes starting from 2, 3, 5,...
        for (var i = 2; i <= upperLimit; i++) {
            if (array[i]) {
                for (var j = i * i; j < n; j += i) {
                    array[j] = false;
                }
            }
        }
    
        // All array[i] set to true are primes
        for (var i = 2; i < n; i++) {
            if(array[i]) {
                output.push(i);
            }
        }
    
        return output;
    };

    // this method contains improvements to sieve 2
    sieve3(n) {
        // Eratosthenes algorithm to find all primes under n
        var array = [], upperLimit = Math.sqrt(n), output = [2];
    
        // Make an array from 2 to (n - 1)
        for (var i = 0; i < n; i++)
            array.push(1);
    
        // Remove multiples of primes starting from 2, 3, 5,...
        for (var i = 3; i <= upperLimit; i += 2) {
            if (array[i]) {
                for (var j = i * i; j < n; j += i*2)
                    array[j] = 0;
            }
        }
    
        // All array[i] set to 1 (true) are primes
        for (var i = 3; i < n; i += 2) {
            if(array[i]) {
                output.push(i);
            }
        }
    
        return output;
        };

     sieve4(max) {
        let sqrt = Math.sqrt(max)
        let sieve = new Array(max).fill(0)
      
        for (let primeCandidate = 2; primeCandidate < sqrt; primeCandidate++) {
          if (sieve[primeCandidate] === true) {
            continue // already processed
          }
          for (let multiple = primeCandidate * primeCandidate; multiple < max; multiple += primeCandidate) {
            if (sieve[multiple] === 0) {
              sieve[multiple] = true
            }
          }
        }
      
        return sieve
          .map((isPrime, i) => ({ i, isPrime })) // find the number associated with the index
          .filter(({ i, isPrime }) => isPrime === 0 && i >= 2) // remove not prime numbers
          .map(({ i }) => i) // output only the values
      }

      sieve5(max) {
        // A list of booleans where index 2 being true corresponds to 2 being prime
        var isPrime = [];
    
        // Initial population of isPrime
        for (var i = 0; i < max; i += 1) {
            if (i != 0 && i != 1) {
                isPrime.push(true);
            }
            else {
                isPrime.push(false);
            }
        }
    
        // Iterate over entire list
        // Element => true if index is prime else false
        for (var i = 0; i < max; i += 1) {
            if (isPrime[i]) {
                for (var j = i + i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    
        var primes = [];
    
        // Assemble list of primes
        for (var i = 0; i < max; i += 1) {
            if (isPrime[i]) {
                primes.push(i);
            }
        }
    
        return primes;
    }

}

exports.newInstance = () => new sieve();
