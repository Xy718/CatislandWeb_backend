#!/usr/bin/env bash
jar_name=./build/libs/ivory.jar
cmd=$"java -jar -Xmx500M ${jar_name}\r";
screen_name=ivory

# #发送命令，结束当前screen运行的jar
# screen -r -d ${screen_name} && $'\003' #ctrl+c
# #发送命令，结束当前screen
# screen -X -S ${screen_name} quit
# #新建screen
# # screen -S ${screen_name} && ""
# screen -S $screen_name -p 0 -X stuff "ls^M"
screen -S ivory
echo "screen:${screen_name} 创建完毕"

# screen -x -S $screen_name -X stuff "$cmd"
# screen -x -S $screen_name -X stuff $'\n'