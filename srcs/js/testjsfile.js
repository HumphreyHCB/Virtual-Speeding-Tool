function testA(params) {
    console.log("print 1");
    console.log("print 2");
    testB()
}
function testB(params) {
    console.log("print 22");
    console.log("print 25");
    testC();
}
function testC(params) {
    console.log("print 378");
    console.log("print 39");
}

testA();
//testB();