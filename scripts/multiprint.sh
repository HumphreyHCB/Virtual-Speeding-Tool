#!/bin/sh -

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
JSON_JAR="${PROJECT_ROOT_DIR}/target/jars/json-20220924.jar"


java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    tool.excelConsolePrinter TestData/Java/subtest1/magnitudecheck2.json TestData/Java/subtest1/magnitudecheck5.json TestData/Java/subtest1/magnitudecheck10.json TestData/Java/subtest1/magnitudecheck20.json TestData/Java/subtest1/magnitudecheck50.json TestData/Java/subtest1/magnitudecheck100.json
