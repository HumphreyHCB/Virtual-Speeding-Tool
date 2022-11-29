#!/bin/sh -

set -e

javac -d classes tests/java/Main.java
javac -d classes tests/java/JsJavaLauncher.java
