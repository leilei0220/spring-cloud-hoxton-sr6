FROM centos:7

WORKDIR /app

RUN yum install -y wget && \
    yum install -y java-1.8.0-openjdk

ADD https://mirror.bit.edu.cn/apache/skywalking/8.0.1/apache-skywalking-apm-es7-8.0.1.tar.gz /app

RUN tar -xf apache-skywalking-apm-es7-8.0.1.tar.gz && \
    mv apache-skywalking-apm-bin-es7 skywalking

RUN ls /app