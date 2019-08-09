
pipeline {
    agent any

    stages{
        stage('Build'){
            steps {
                bat 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage('deploy to staging'){
            steps{

                build job:'deploy-to-staging'

            }
        }

        stage('deploy to production'){

            steps{

                timeout(time:5, unit:'DAYS'){
                    input message:'APPROVE PRODUCTION Deployment'
                }

                build job: 'deploy-to-prod'
            }

            post{
                success{
                    echo 'Build SUCCESS! Code deployed to production'
                }

                failure{
                    echo 'Deployment failed!'
                }
            }
        }
    }
}