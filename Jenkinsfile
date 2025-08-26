pipeline {
   agent any

   environment {
       APP_ENV = 'dev'
   }

   stages {
       stage('Clone') {
           steps {
               git branch: 'main', url: 'https://github.com/Sudharshangk/jenkins-pipeline-demo.git'
           }
       }

       stage('Build') {
           steps {
               echo 'Building the project...'
               bat 'mvn clean install'
           }
       }

       stage('Test') {
           steps {
               echo 'Running tests...'
               bat 'mvn test'
           }
       }

       stage('Deploy') {
           steps {
               echo "Deploying to ${env.APP_ENV} environment..."
           }
       }
   }

   post {
       success {
           echo 'Pipeline completed successfully.'
       }
       failure {
           echo 'Pipeline failed.'
       }
   }
}
