1. 安装 elasticsearch 



2. 安装kibana


3. 安装logstash

docker run --rm -it -p 4560:4560 --name logstash --link es -d -v /Users/gaoyunfeng/Applications/docker/logstash/config/logstash.conf:/usr/share/logstash/pipeline/logstash.conf logstash:6.5.4