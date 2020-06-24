#!/usr/bin/env bash
jar_name=./build/libs/ivory.jar

cd /ci_file/ivory_backend
nohup java -jar -Xmx500M ${jar_name} &