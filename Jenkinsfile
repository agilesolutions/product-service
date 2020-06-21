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
                bat 'mvn integration-test'
            }
        }
        stage('Generate HTML report') {
            steps {
    	    		cucumber buildStatus: 'UNSTABLE',
                	reportTitle: 'Product scenarios',
                	fileIncludePattern: 'cucumber.json',
                	trendsLimit: 10,
                	classifications: [
                    	['key': 'Browser',
                        'value': 'Firefox'
                    	]
                	]
	    	}
    	}
    }
    post {
        always {
                           cucumber buildStatus: "UNSTABLE", 
                           fileIncludePattern: "**/cucumber.json",
                           jsonReportDirectory: 'target'
        	}
        }

}