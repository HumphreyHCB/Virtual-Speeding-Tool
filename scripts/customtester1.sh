#!/bin/sh -

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
SIMPLETOOL_JAR="${PROJECT_ROOT_DIR}/target/VStool.jar"
JSON_JAR="${PROJECT_ROOT_DIR}/target/jars/json-20220924.jar"

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher sortingtest 10 TestData/Java/consistencycheck1.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher sortingtest 10 TestData/Java/consistencycheck2.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher sortingtest 10 TestData/Java/consistencycheck3.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher sortingtest 2 TestData/Java/magnitudecheck2.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher sortingtest 5 TestData/Java/magnitudecheck5.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher sortingtest 10 TestData/Java/magnitudecheck10.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher sortingtest 20 TestData/Java/magnitudecheck20.json
