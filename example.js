
const { Benchmark } = require('./benchmark');


class example extends Benchmark {
    constructor() {
      super();
      
    }
  
    benchmark() {
        this.test();
      return true;
    }
  
    verifyResult(result) {
      return true === result;
    }


    testPrint(x){
        for (let index = 0; index < x; index++) {
            this.fakeprint();            
        }
    }

    test(){
        this.testPrint(1);
        this.testPrint(2);
        return true;
    }

    fakeprint(){
        console.log("print ");

    }

    sleep(milliseconds){
        const date = Date.now();
        let currentDate = null;
        do {
            currentDate = Date.now();
        }while(currentDate - date < milliseconds);

    }

}

exports.newInstance = () => new example();
