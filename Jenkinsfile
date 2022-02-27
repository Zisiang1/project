pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/Zisiang1/project.git'
                //sh './mvnw clean compile'
                bat 'clean compile'
            }
        }
        stage('Test') {
            steps {
                //sh './mvnw test'
                bat 'clean test'
            }


            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
