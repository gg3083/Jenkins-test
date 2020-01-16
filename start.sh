#!/bin/bash

java -jar -Xmx2g -Xms1g -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/java/dump  app.jar -Duser.timezone=GMT+08
