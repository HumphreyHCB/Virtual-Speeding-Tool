#!/bin/sh -

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
SIMPLETOOL_JAR="${PROJECT_ROOT_DIR}/target/VStool.jar"
JSON_JAR="${PROJECT_ROOT_DIR}/target/jars/json-20220924.jar"

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 2

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
     launchers.EspressoLauncher sortingtest 50 bubbleSort 31

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 32

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 33

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 34

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 36

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 37

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 38

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest 50 bubbleSort 40


