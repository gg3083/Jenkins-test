pipeline {
    agent any
    environment {
        def ip = '127.0.0.1:5000'
        def project_name = 'jenkins-test'

        TAG = """${sh(
                returnStdout: true,
                script: "date +%m%d_%H%M"
                      )}"""
        // def DOCKER_IMAGE_NAME = "${ip}/${project_name}"

    }


    stages {
          // 打包项目
          stage('build') {
                 steps {
                     sh "/home/gg/maven/bin/mvn clean package -Dmaven.test.skip=true"
                     echo '编译完成'
                 }
          }

         //推送docker
         stage('docker') {
             steps {
                 sh '''
                       pwd
                       docker build -t ${ip}/${project_name}:${TAG} .
                       echo '编译docker完成'
                       docker push ${ip}/${project_name}:${TAG}
                       docker rmi ${ip}/${project_name}:${TAG}
                 '''
                 echo "更新完成"
             }
         }
    }

}
