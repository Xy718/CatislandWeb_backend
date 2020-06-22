FROM openjdk:8-jdk-alpine

ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone && mkdir -p /ivory

WORKDIR /ivory

EXPOSE 8090

ADD ./target/ivory-api.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar ivory-api.jar