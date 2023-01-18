#!/bin/sh -

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
JSON_JAR="${PROJECT_ROOT_DIR}/target/jars/json-20220924.jar"


file=$1
shift

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    tool.Reader $file
