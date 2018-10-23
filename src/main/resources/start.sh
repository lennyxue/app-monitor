#!/bin/sh

rm -f tpid

export JAVA_HOME=/opt/app/java/jdk1.8.0_144
export PATH=$JAVA_HOME/bin:$PATH
nohup java -Dmail.recipient.address=xuequnmou@aspirecn.com,caiyayu@aspirecn.com,hucy@aspirecn.com,chenggr@aspirecn.com,quanbopeng@aspirecn.com,caoweizhong@aspirecn.com,huangkai@aspirecn.com -DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector -Xms8g -Xmx8g -Xmn2g -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/opt/app/app-monitor -XX:+DisableExplicitGC -XX:+PrintGCDetails -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCDateStamps -Xloggc:/opt/app/logs/app-monitor/gclog-`date +%F-%H%M%S`.log -server -jar lib/app-monitor-*.jar >> /opt/app/logs/app-monitor/console-`date +%F-%H%M%S`.log &


echo $! > tpid

echo Start Success!