pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        script {
          // Instalacja zależności
          sh 'npm install'
        }
      }
    }

    stage('Test') {
      steps {
        script {
          // Uruchomienie testów (opcjonalnie)
          sh 'npm test'
        }
      }
    }

    stage('Deploy') {
      when {
        branch 'main'
      }
      steps {
        script {
          // Wdrażanie aplikacji na serwerze
          sh 'npm start &'
        }
      }
    }
  }
}
