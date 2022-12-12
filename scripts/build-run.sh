#!/bin/sh -

set -e


javac -d classes src/java/JsJavaLauncher.java

javac -d classes src/java/*.java

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
SIMPLETOOL_JAR="${PROJECT_ROOT_DIR}/target/VStool.jar"

java \
    --class-path "$JAVA_CLASS_PATH_DIR" \
    code.Harness badBubbles 100000 1
