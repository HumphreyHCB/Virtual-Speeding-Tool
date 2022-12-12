#!/bin/sh -

set -e


javac -d classes tests/java/JsJavaLauncher.java

javac -d classes tests/java/*.java

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"

java \
--class-path "$JAVA_CLASS_PATH_DIR" \
code.Harness sortingtest 10000 1