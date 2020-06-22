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
    }
    post {
        always {
                           cucumber buildStatus: "UNSTABLE", 
                           fileIncludePattern: "**/cucumber.json",
                           jsonReportDirectory: 'target'
        	}
        }

}