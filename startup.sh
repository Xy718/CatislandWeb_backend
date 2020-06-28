#!/usr/bin/env bash
jar_name=./build/libs/ivory.jar

cd ci_file/ivory_backend

#找到已在运行或占用端口的进程
port=11718
pid=$(netstat -nlp | grep :$port | awk '{print $7}' | awk -F"/" '{ print $1 }');
#如果存在，kill进程
if [ -n "$pid" ]; then 
    kill -9 $pid;
    echo "删除了被占用的端口的进程";
else
    echo "端口未被占用";
fi

nohup java -jar -Xmx500M ${jar_name} &