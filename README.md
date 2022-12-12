# Virtual Speeding Tool (Prototype) 

This Repository is for conducting tests on weather its possible to do “virtual speeding” on code in a single threaded world.
Making use of the truffle API to insert instrumentation to slow down and “speed up” code.

<strike>
As of 13/11/2022 
i calculate :

Overhead = 1.82%
Slowdown Inaccuracy = 5.55%
</strike>

Some CMD that can be usefull

```
export PATH=<*path/to/grall*>/bin:$PATH

export JAVA_HOME=<*path/to/grall*>

$GRAALVM/bin/gu install nodejs
$GRAALVM/bin/gu install espresso

```
