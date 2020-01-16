pipeline {
    agent any
    environment {
        def GIT_GROUP = 'root'
        def GIT_NAME = 'jenkins-test'

        TAG = """${sh(
                returnStdout: true,
                script: "date +%m%d-%H%M"
                      )}"""
        def DOCKER_IMAGE_NAME = "${ip}/${GIT_GROUP}-${GIT_NAME}"

    }
    stages {
        // 下载代码
        stage('checkout') {
            steps {
                echo "代码分支为：${branch} ${GIT_GROUP}/${GIT_NAME}"
                checkout([$class: 'GitSCM', branches: [[name: '${branch}']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'b4d3ea5d-f241-4516-86df-b4b7c46dec2d', url: "http://192.168.99.170:8001/${GIT_GROUP}/${GIT_NAME}.git"]]])
                sh "git branch"
            }
        }


        // 打包项目
        stage('build') {
            steps {
                sh "/usr/share/maven/bin/mvn clean package -Dmaven.test.skip=true"
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
            }
}
