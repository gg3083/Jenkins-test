pipeline {
    agent any
    environment {
        def GIT_GROUP = 'gg-api'
        def GIT_NAME = 'jenkins-test'

        TAG = """${sh(
                returnStdout: true,
                script: "date +%m%d-%H%M"
                      )}"""
        def DOCKER_IMAGE_NAME = "${test_env}-${GIT_GROUP}-${sub_project}"

    }


    stages {
          // 打包项目
          stage('build') {
                 steps {
                     sh "/application/maven/bin/mvn clean package -Dmaven.test.skip=true"
                     echo '编译完成'
                 }
          }

         //推送docker
         stage('docker') {
             steps {
                 sh '''
                       cd ${sub_project} && docker build -t ${DOCKER_IMAGE_NAME}/${DOCKER_IMAGE_NAME}:${TAG} .
                       echo '编译docker完成'
                       docker push ${DOCKER_IMAGE_NAME}/${DOCKER_IMAGE_NAME}:${TAG}
                       docker rmi ${DOCKER_IMAGE_NAME}/${DOCKER_IMAGE_NAME}:${TAG}
                 '''
                 echo "更新完成"
             }
         }
    ｝

}
