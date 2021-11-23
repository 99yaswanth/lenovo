//Descriptive pipeline
pipeline{
    agent any
    parameters{
        string(name: 'SERVERIP' ,defaultValue: '', description: 'tomcat server')
    }
    stages{
        stage("verify tomcat scipt"){
            steps{
                sh "ls -l"
            }
        }
        stage("copy tomcat script to remote server "){
            steps{
                sh """
                scp -o StrictHostKeyChecking=no -i /tmp/nvirginia.pem /tmp/tomcatinstallation.sh ec2-user@${SERVERIP}:/tmp/
                ssh -o StrictHostKeyChecking=no -i /tmp/nvirginia.pem ec2-user@${SERVERIP} "ls -l /tmp/
                """
            }
        }
    }
}