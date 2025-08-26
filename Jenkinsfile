pipeline {
  agent any

  tools {
    jdk 'JDK21'          // name you configured in Jenkins -> Global Tool Configuration
    maven 'Maven_3_9'    // name you configured in Jenkins -> Maven installations
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
        bat 'C:\\Windows\\System32\\cmd.exe /c mvn -B -DskipTests clean package'
      }
    }

    stage('Test') {
      steps {
        echo 'Running tests...'
        bat 'C:\\Windows\\System32\\cmd.exe /c mvn -B test'
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
