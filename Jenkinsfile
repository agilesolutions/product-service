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
                bat 'mvn clean package'
            }
        }
    }
}