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
        stage('Stop and Clean old container and image') {
            steps {
                sh '''
                container_id=$(docker ps -q -f "ancestor=abhinavsharma068/poc-cicd-docker" -f "publish=9090")
                if [ -n "$container_id" ]; then
                    echo "Stopping and removing old container $container_id"
                    docker stop $container_id
                    docker rm $container_id
                else
                    echo "No container found using port 9090"
                fi

                image_id=$(docker images -q abhinavsharma068/poc-cicd-docker)
                if [ -n "$image_id" ]; then
                    echo "Removing old image $image_id"
                    docker rmi $image_id
                else
                    echo "No old image found"
                fi
                '''
            }
        }
        stage('Build Docker image') {
            steps {
                sh 'docker build -t abhinavsharma068/poc-cicd-docker .'
            }
        }
        stage('Run new container') {
            steps {
                sh 'docker run -d -p 9090:7654 abhinavsharma068/poc-cicd-docker'
            }
        }
    }
}
