#!/bin/sh -

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
SIMPLETOOL_JAR="${PROJECT_ROOT_DIR}/target/VStool.jar"
JSON_JAR="${PROJECT_ROOT_DIR}/target/jars/json-20220924.jar"


# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher sortingtest 50 TestData/Java/magnitudecheck50.json
    
# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher sortingtest 250 TestData/Java/magnitudecheck250.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher Bubbles 2 TestData/Java/Bubblesmagnitudecheck2.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher Bubbles 5 TestData/Java/Bubblesmagnitudecheck5.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher Bubbles 10 TestData/Java/Bubblesmagnitudecheck10.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher Bubbles 20 TestData/Java/Bubblesmagnitudecheck20.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#      "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#      launchers.ToolLauncher Bubbles 50 TestData/Java/Bubblesmagnitudecheck50.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher Bubbles 100 TestData/Java/Bubblesmagnitudecheck100.json



# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher badBubbles 2 TestData/Java/badBubblesmagnitudecheck2.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher badBubbles 5 TestData/Java/badBubblesmagnitudecheck5.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher badBubbles 10 TestData/Java/badBubblesmagnitudecheck10.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher badBubbles 20 TestData/Java/badBubblesmagnitudecheck20.json

#  java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#      "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#      launchers.ToolLauncher badBubbles 50 TestData/Java/badBubblesmagnitudecheck50.json

# java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
#     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
#     launchers.ToolLauncher badBubbles 100 TestData/Java/badBubblesmagnitudecheck100.json



java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher swapbadBubbles 2 TestData/Java/subTest/swapbadBubblesmagnitudecheck2.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher swapbadBubbles 5 TestData/Java/subTest/swapbadBubblesmagnitudecheck5.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher swapbadBubbles 10 TestData/Java/subTest/swapbadBubblesmagnitudecheck10.json

java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher swapbadBubbles 20 TestData/Java/subTest/swapbadBubblesmagnitudecheck20.json

 java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
     "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
     launchers.ToolLauncher swapbadBubbles 50 TestData/Java/subTest/swapbadBubblesmagnitudecheck50.json


java --class-path "$JAVA_CLASS_PATH_DIR":"$JSON_JAR":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.ToolLauncher swapbadBubbles 100 TestData/Java/subTest/swapbadBubblesmagnitudecheck100.json
