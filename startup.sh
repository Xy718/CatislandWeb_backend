#!/usr/bin/env bash
jar_name=./build/libs/ivory.jar
#发送命令，结束当前screen运行的jar
screen -r -d ivory stuff $'\003' #ctrl+c
#发送命令，结束当前screen
screen -X -S ivory quit
#新建screen
screen -S ivory
#发送命令，启动jar
screen -r -d ivory stuff "java -jar -Xmx500M ${jar_name}\r"