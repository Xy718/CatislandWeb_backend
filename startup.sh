#!/usr/bin/env bash
jar_name=./build/libs/ivory.jar
screen_name=ivory
#发送命令，结束当前screen运行的jar
screen -r -d ${screen_name} && $'\003' #ctrl+c
#发送命令，结束当前screen
screen -X -S ${screen_name} quit
#新建screen
screen -S ${screen_name}
echo "screen 创建完毕"
#发送命令，启动jar
screen -r -d ${screen_name} && "java -jar -Xmx500M ${jar_name}\r"