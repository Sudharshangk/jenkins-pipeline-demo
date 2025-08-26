pipeline {
  agent any

  tools {
    jdk 'JDK17'          // name you will configure in Jenkins
    maven 'Maven_3_9'    // name to configure in Jenkins
  }

  environment {
    APP_ENV = 'dev'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        echo 'Building...'
        // Use bat on Windows agents, or sh on Linux agents.
        bat 'mvn -B -DskipTests clean package'
      }
    }

    stage('Test') {
      steps {
        echo 'Running tests...'
        bat 'mvn -B test'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Archive') {
      steps {
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Deploy') {
      steps {
        echo "Deploying to ${env.APP_ENV} (no-op example)"
      }
    }
  }

  post {
    success { echo 'Pipeline succeeded.' }
    failure { echo 'Pipeline failed.' }
    always { echo "Build URL: ${env.BUILD_URL}" }
  }
}
