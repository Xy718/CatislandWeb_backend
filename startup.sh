###
 # @Author: Xy718
 # @Date: 2020-06-22 16:42:37
 # @LastEditors: Xy718
 # @LastEditTime: 2020-06-24 17:12:58
### 
#!/usr/bin/env bash
jar_name=./build/libs/ivory.jar
#发送命令，结束当前screen运行的jar
screen -S ivory -X stuff $'\003' #ctrl+c
#发送命令，结束当前screen
screen -S ivory -X stuff 'exit\r'
#新建screen
screen -dmS ivory
#发送命令，启动jar
screen -S ivory -X stuff "java -jar -Xmx500M ${jar_name}\r