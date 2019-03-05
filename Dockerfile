#FROM java:8u111-jre
FROM centos:7.6.1810

# FROM ngnix-php-redis:v9
LABEL maintainer="gg <gg3083.cn@gmail.com>"

RUN yum install java-1.8.0-openjdk-devel -y
ADD target/jenkins-test-0.0.1-SNAPSHOT.jar /app.jar
ADD env/docker/start.sh /start.sh


RUN chmod 111 /app.jar &&  chmod 111 /start.sh


EXPOSE 8001

CMD ["/start.sh"]