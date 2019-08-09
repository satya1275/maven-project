pipeline{

    agent any

    parameters{
        string(name:'tomcat-dev', defaultValue:'3.19.30.185', description:'Dev Server')
        string(name:'tomcat-prod', defaultValue:'18.218.69.197', description:'Prod Server')
    }

    triggers{
        pollSCM('* * * * *')
    }

    stages{
        stage('Build'){
            steps{
                   bat 'mvn clean package'  
            }
            post{
                success{
                    echo 'Build stage completed'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }

        stage('Deployments'){
            parallel{
                stage('Deploy to staging'){
                    steps{
                        sh "cp -i C:/Users/satis/Downloads/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat-dev}:/var/lib/tomcat7/webapps" 
                    }            
                }

                stage('Deploy to production'){
                    steps{
                        sh "cp -i C:/Users/satis/Downloads/tomcat-demo.pem **/target/*.war ec2-user@${params.tomcat-prod}:/var/lib/tomcat7/webapps" 
                    }        
                }    
            }
        }    
           
        }

    }
}