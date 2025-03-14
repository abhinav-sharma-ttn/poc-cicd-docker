pipeline {
    agent any

    tools {
        maven "3.9.9"
    }

    stages {
        stage('Build') {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/abhinav-sharma-ttn/poc-cicd-docker']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker image') {
            steps {
                sh 'docker build -t abhinavsharma068/poc-cicd-docker .'
            }
        }
        stage('Run container') {
            steps {
                sh 'docker run -d -p 9090:7654 abhinavsharma068/poc-cicd-docker'
            }
        }
    }
}
