pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'java'
    }
    stages {
        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
                bat 'mvn clean test'
            }
        }
        stage('Generate HTML report') {
        		cucumber buildStatus: 'UNSTABLE',
                	reportTitle: 'My report',
                	fileIncludePattern: '**/*.json',
                	trendsLimit: 10,
                	classifications: [
                    	['key': 'Browser',
                        'value': 'Firefox'
                    	]
                	]
    	}
    }
}