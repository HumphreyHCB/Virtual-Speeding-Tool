#!/bin/sh -

set -e

javac -classpath target/jars/json-20220924.jar -d classes srcs/java/tool/*.java srcs/java/launchers/*.java srcs/java/code/*.java



