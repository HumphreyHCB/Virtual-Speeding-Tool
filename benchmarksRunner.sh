#!/usr/bin/env bash

./VStool node --Virtually-Speeding-Tool.speed-up-Method="No-Method" --Virtually-Speeding-Tool.Slowdown-amount=1000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="bubbleSort" --Virtually-Speeding-Tool.Slowdown-amount=1000 harness.js sortingTest 1000 1
./VStool node --Virtually-Speeding-Tool.speed-up-Method="selectionSort" --Virtually-Speeding-Tool.Slowdown-amount=1000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="insertionSort" --Virtually-Speeding-Tool.Slowdown-amount=1000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="mergeSort" --Virtually-Speeding-Tool.Slowdown-amount=1000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="quickSort" --Virtually-Speeding-Tool.Slowdown-amount=1000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="heapSort" --Virtually-Speeding-Tool.Slowdown-amount=1000 harness.js sortingTest 1000 1
echo -e "\n" >> TestData/CounterApproach/SortingDump1StatementTag.txt 

./VStool node --Virtually-Speeding-Tool.speed-up-Method="No-Method" --Virtually-Speeding-Tool.Slowdown-amount=10000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="bubbleSort" --Virtually-Speeding-Tool.Slowdown-amount=10000 harness.js sortingTest 1000 1
./VStool node --Virtually-Speeding-Tool.speed-up-Method="selectionSort" --Virtually-Speeding-Tool.Slowdown-amount=10000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="insertionSort" --Virtually-Speeding-Tool.Slowdown-amount=10000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="mergeSort" --Virtually-Speeding-Tool.Slowdown-amount=10000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="quickSort" --Virtually-Speeding-Tool.Slowdown-amount=10000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="heapSort" --Virtually-Speeding-Tool.Slowdown-amount=10000 harness.js sortingTest 1000 1
echo -e "\n" >> TestData/CounterApproach/SortingDump1StatementTag.txt


./VStool node --Virtually-Speeding-Tool.speed-up-Method="No-Method" --Virtually-Speeding-Tool.Slowdown-amount=100000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="bubbleSort" --Virtually-Speeding-Tool.Slowdown-amount=100000 harness.js sortingTest 1000 1
./VStool node --Virtually-Speeding-Tool.speed-up-Method="selectionSort" --Virtually-Speeding-Tool.Slowdown-amount=100000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="insertionSort" --Virtually-Speeding-Tool.Slowdown-amount=100000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="mergeSort" --Virtually-Speeding-Tool.Slowdown-amount=100000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="quickSort" --Virtually-Speeding-Tool.Slowdown-amount=100000 harness.js sortingTest 1000 1 
./VStool node --Virtually-Speeding-Tool.speed-up-Method="heapSort" --Virtually-Speeding-Tool.Slowdown-amount=100000 harness.js sortingTest 1000 1
echo -e "\n" >> TestData/CounterApproach/SortingDump1StatementTag.txt
