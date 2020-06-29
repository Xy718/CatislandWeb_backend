#!/usr/bin/env bash
jar_name=./build/libs/ivory.jar

cd ci_file/ivory_backend

#找到已在运行或占用端口的进程
# port=11718
# pid=$(netstat -nlp | grep :$port | awk '{print $7}' | awk -F"/" '{ print $1 }');
# #如果存在，kill进程
# if [ -n "$pid" ]; then 
#     kill -9 $pid;
#     echo "删除了被占用的端口的进程";
# else
#     echo "端口未被占用";
# fi
#停止已在运行的api
screen -S ivory -X stuff '^C\n'
screen -X -S ivory quit
screen -dmS ivory
screen -x -S ivory -X stuff "java -jar -Xmx500M ${jar_name} \n"