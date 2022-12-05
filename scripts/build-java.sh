#!/bin/sh -

set -e


javac -truffle -d classes tests/java/JsJavaLauncher.java

javac -truffle -d classes tests/java/*.java


