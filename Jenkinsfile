pipeline {
    agent any
    environment { 
        GIT_BOT = "${env.git_bot}"
        GIT_HUB_SCM = 'https://github.com/elvisdominguez7/Apps.git'
    }
    stages { 
        stage('Check Out Code') {
            steps {
                git(
                    url: 'https://github.com/elvisdominguez7/demo.git',
                    credentialsId: "${GIT_HUB_SCM}" ,
                    branch: "master"
                )
            }
        }
         stage('Build') {
            steps {
                bat "mvn clean install" 
            }
        }
    }
}