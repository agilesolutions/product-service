#!/usr/bin/env groovy

node {
    stage('checkout') {
        checkout scm
    }

    stage('check java') {
        sh "java -version"
    }

    stage('clean') {
        sh "chmod +x mvnw"
        sh "./mvnw -ntp clean -P-webpack"
    }
    stage('nohttp') {
        sh "./mvnw -ntp checkstyle:check"
    }

    stage('backend tests') {
        try {
            sh "./mvnw -ntp verify -P-webpack"
        } catch(err) {
            throw err
        } finally {
            junit '**/target/test-results/**/TEST-*.xml'
        }
    }

    stage('packaging') {
        sh "./mvnw -ntp verify -P-webpack -Pprod -DskipTests"
        archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
    }
    stage('quality analysis') {
        withSonarQubeEnv('http://localhost:8081') {
            sh "./mvnw -ntp initialize sonar:sonar"
        }
    }
}
