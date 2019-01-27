pipeline {
    agent any
    
    tools{
        maven 'maven 3.5.4'
        jdk '1.8.0_201'
        nodejs 'NodeJs 11.8.0'
    }
    
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
