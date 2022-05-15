pipeline {  
    agent any
    environment{
        path=' C:/Program Files/apache-maven-3.8.5-bin/apache-maven-3.8.5/bin'
    }
    stages {  
            stage ('Git-Checkout') {  
                steps{
                    git credentialsId: 'e6757c46-0750-4ab1-8cd4-c569efcbbdb1', url: 'https://github.com/Kishoredevops9/Pipeline-project-deployment-on-Tomcat.git'
                    echo "Checkout successful";
                } 
            }
            stage ('Compile') {  
                  steps{
                    sh 'mvn compile'
                    echo "test successful";
                } 
            }
             stage ('Build') {  
                  steps{
                    sh 'mvn clean package'
                    echo "build successful";
                } 
            }
            
        }
      
   }
