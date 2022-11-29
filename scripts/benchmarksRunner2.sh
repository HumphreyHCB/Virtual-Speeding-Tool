#!/usr/bin/env bash

./VStool node --Virtually-Speeding-Tool.Slowdown-amount=100 --Virtually-Speeding-Tool.speed-up-Method="No-Method" harness.js sieve 100 1 
#./VStool node --Virtually-Speeding-Tool.Slowdown-amount=10 --Virtually-Speeding-Tool.speed-up-Method="sieve1" harness.js sieve 1000 1
./VStool node --Virtually-Speeding-Tool.Slowdown-amount=100 --Virtually-Speeding-Tool.speed-up-Method="sieve2" harness.js sieve 100 1 
./VStool node --Virtually-Speeding-Tool.Slowdown-amount=100 --Virtually-Speeding-Tool.speed-up-Method="sieve3" harness.js sieve 100 1
./VStool node --Virtually-Speeding-Tool.Slowdown-amount=100 --Virtually-Speeding-Tool.speed-up-Method="sieve4" harness.js sieve 100 1 
#./VStool node --Virtually-Speeding-Tool.Slowdown-amount=100 --Virtually-Speeding-Tool.speed-up-Method="sieve5" harness.js sieve 100 1  

