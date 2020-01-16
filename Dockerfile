FROM centos

# FROM ngnix-php-redis:v9
LABEL maintainer="gg3083 <1056619204@qq.com>"

ADD target/jenkins-test-0.0.1-SNAPSHOT.jar /app.jar
ADD start.sh /start.sh

RUN chmod 111 /app.jar &&  chmod 111 /start.sh


EXPOSE 8081

CMD ["/start.sh"]