pipeline {
    agent any

    //tools {
        //maven 'Maven3'   // Must match the name configured in Jenkins Global Tool Configuration
       //sonarQubeScanner 'sonarscanner'
    //}

    environment {
        // these are the environment variables (Amir's machine) that will be used in the pipeline
       //PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
       //JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21'  // Adjust to your actual JDK path


        SONARQUBE_SERVER = 'sonarqube'
        SONAR_TOKEN = credentials('sonar') //make sure a right token is selected
        DOCKERHUB_CREDENTIALS_ID = 'docker'
        DOCKERHUB_REPO = 'oleruu/bmi_3013_oleg'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'OTP2_RTL_BMI_Solution_Instructions', url: 'https://github.com/loharuu/school_stuff.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
// Check the SonarQube analysis stage for the correct project key and name
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv("${env.SONARQUBE_SERVER}") {
                    sh """
                        sonar-scanner ^
                        -Dsonar.projectKey=BMI_CL ^
                        -Dsonar.sources=src ^
                        -Dsonar.projectName=BMI_CL ^
                        -Dsonar.host.url=http://localhost:9000 ^
                        -Dsonar.login=${env.SONAR_TOKEN} ^
                        -Dsonar.java.binaries=target/classes
                    """
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def app = docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                    env.BUILT_IMAGE = app.id  // Optional: store image ID for reuse
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                       docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
                }
            }
        }
    }


}
