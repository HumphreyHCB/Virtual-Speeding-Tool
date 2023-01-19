#!/bin/sh -

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
SIMPLETOOL_JAR="${PROJECT_ROOT_DIR}/target/VStool.jar"
JSON_JAR="${PROJECT_ROOT_DIR}/target/jars/json-20220924.jar"

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher swapbadBubbles


