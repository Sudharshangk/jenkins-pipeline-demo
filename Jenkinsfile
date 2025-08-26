pipeline {
  agent any

  tools {
    jdk 'JDK21'          
    maven 'Maven_3_9'    
  }

  environment {
    APP_ENV = 'dev'
  }

  stage('Checkout') {
  steps {
    git branch: 'main', url: 'https://github.com/Sudharshangk/jenkins-pipeline-demo.git'
  }
}


    stage('Build') {
      steps {
        echo "Building project with Maven..."
        bat '''
          echo Running Maven Build
          mvn -B -DskipTests clean package
        '''
      }
    }

    stage('Test') {
      steps {
        echo "Running tests..."
        bat '''
          echo Running Maven Tests
          mvn -B test
        '''
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Archive') {
      steps {
        echo "Archiving JAR artifacts..."
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Deploy') {
      steps {
        echo "Deploying to ${env.APP_ENV} (this is just a placeholder step)"
      }
    }
  }

  post {
    success {
      echo "Pipeline succeeded."
    }
    failure {
      echo "Pipeline failed."
    }
    always {
      echo "Build URL: ${env.BUILD_URL}"
    }
  }
}