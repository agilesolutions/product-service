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
                //bat 'mvn integration-test'
            }
        }
        stage('Generate HTML report') {
            steps {
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
}