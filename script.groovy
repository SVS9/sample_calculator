pipeline {  
    agent any  
    stages {  
            stage ('Git-Checkout') {  
                steps{
                    git credentialsId: 'e6757c46-0750-4ab1-8cd4-c569efcbbdb1', url: 'https://github.com/Kishoredevops9/Pipeline-project-deployment-on-Tomcat.git'
                    echo "Checkout successful";
                } 
            }
            stage ('Compile') {  
                  steps{
                    bat label: '', script: 'mvn compile'
                    echo "test successful"; 
                } 
            }
            stage ('Build') {  
                  steps{
                    bat label: '', script: 'mvn clean'
                    bat label: '', script: 'mvn package'
                    echo "build successful";
                } 
            }
             stage('SonarQube analysis') {
               withSonarQubeEnv('SonarQube-9.4') {
              sh 'mvn sonar:sonar'
                } // submitted SonarQube taskId is automatically attached to the pipeline context
            }
        }
 
    }
}
