pipeline{

    agent any

    parameters{
        string(name:'tomcat_dev', defaultValue:'3.19.30.185', description:'Dev Server')
        string(name:'tomcat_prod', defaultValue:'18.218.69.197', description:'Prod Server')
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
        }
        stage('Deployments'){
            parallel{
                    stage('Deploy to staging'){
                        steps{
                            bat 'echo y|scp -o StrictHostKeyChecking=no -i C:\\Users\\satis\\Downloads\\tomcat-demo.ppk webapp/target/*.war ec2-user@${params.tomcat_dev}:/var/lib/tomcat7/webapps'
                        }            
                    }

                    stage('Deploy to production'){
                        steps{
                            bat 'echo y|scp -o StrictHostKeyChecking=no -i C:\\Users\\satis\\Downloads\\tomcat-demo.ppk webapp/target/*.war ec2-user@${params.tomcat_prod}:/var/lib/tomcat7/webapps'
                        }        
                    }    
                }
            
        }    
           
        }

    
}