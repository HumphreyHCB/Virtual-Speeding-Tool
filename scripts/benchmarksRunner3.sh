#!/usr/bin/env bash

./VStool node --Virtually-Speeding-Tool.Slowdown-amount=50 --Virtually-Speeding-Tool.speed-up-Method="No-Method" harness.js bubbles 40 1 
./VStool node --Virtually-Speeding-Tool.Slowdown-amount=50 --Virtually-Speeding-Tool.speed-up-Method="normalbubbleSort" harness.js bubbles 40 1
./VStool node --Virtually-Speeding-Tool.Slowdown-amount=50 --Virtually-Speeding-Tool.speed-up-Method="optimizedbubbleSort" harness.js bubbles 40 1 
./VStool node --Virtually-Speeding-Tool.Slowdown-amount=50 --Virtually-Speeding-Tool.speed-up-Method="recursivebubblesort" harness.js bubbles 40 1


