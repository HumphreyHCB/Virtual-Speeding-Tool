#!/bin/sh -

set -e


javac -d classes tests/java/JsJavaLauncher.java

javac -d classes tests/java/*.java


