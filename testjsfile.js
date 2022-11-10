function testA(params) {
    console.log("print");
    console.log("print");
}
function testB(params) {
    console.log("print 2");
    console.log("print 2");
    testC();
}
function testC(params) {
    console.log("print 3");
    console.log("print 3");
}

testA();
testB();