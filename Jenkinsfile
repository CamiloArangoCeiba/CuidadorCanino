pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones espec�ficas de Pipeline dentro del Pipeline
  options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
    disableConcurrentBuilds()
  }

  //Una secci�n que define las herramientas preinstaladas en Jenkins
  tools {
    jdk 'JDK11_Centos' //Preinstalada en la Configuración del Master
  }

  //Aqui comienzan los items del Pipeline
  stages {
    stage('Checkout') {
      steps {
        echo '------------>Checkout<------------'
        checkout scm
      }
    }
    
    stage('Gradle permission') {
      steps {
        sh "chmod +x ./microservicio/gradlew"
      }
    }

    stage('Compile & Unit Tests') {
      steps {
        echo '------------>Unit Tests<------------'
        sh 'chmod +x microservicio/gradlew'
        sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
        sh './microservicio/gradlew --b ./microservicio/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps {
        echo '------------>Analisis de codigo estatico<------------'
        withSonarQubeEnv('Sonar') {
          sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
        }
      }
    }

    stage('Build') {
      steps {
        echo '------------>Build<------------'
        sh "./microservicio/gradlew --b ./microservicio/build.gradle build -x test"
      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
      junit '**/test-results/test/*.xml'
    }
    failure {
      echo 'This will run only if failed'
      mail (to: 'camilo.arango@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}