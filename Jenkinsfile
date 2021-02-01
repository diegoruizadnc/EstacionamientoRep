pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones especÃ­ficas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una secciÃ³n que define las herramientas â€œpreinstaladasâ€� en Jenkins
  tools {
    jdk 'JDK13_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
    gradle 'Gradle5.6_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
  }

  //AquÃ­ comienzan los â€œitemsâ€� del Pipeline
  stages{
    stage('Checkout'){
		steps{
			echo "------------>Checkout<------------"
			checkout([
			$class: 'GitSCM',
			branches: [[name: '*/master']],
			doGenerateSubmoduleConfigurations: false,
			extensions: [],
			gitTool: 'Default',
			submoduleCfg: [],
			userRemoteConfigs: [[
			credentialsId: 'GitHub_diegoruizadn',
			url:'https://github.com/diegoruizadnc/EstacionamientoRep.git'
			]]
			])
		}
	}

    stage('Build') {
        steps {
            echo "------------>Build<------------"
            //Construir sin tarea test que se ejecutÃ³ previamente
            sh 'chmod 777 gradlew'
            sh './gradlew clean build'
        }
    }

    stage('Compile & Unit Tests') {
		steps{
			echo "------------>Unit Tests<------------"
			sh './gradlew test'
		}
	}


    stage('Static Code Analysis') {
		steps{
			echo '------------>AnÃ¡lisis de cÃ³digo estÃ¡tico<------------'
			withSonarQubeEnv('Sonar') {
			sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
			}
		}
	}
}
  post {
    always {
      echo 'This will always run'
    }
    success {
    	echo 'This will run only if successful'
    	junit 'build/test-results/test/*.xml'
	}
    failure {
		echo 'This will run only if failed'
		mail (to: 'diego.ruiz@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
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
