//Descriptive pipeline
pipeline{
    agent any
    parameters{
        string(name: 'SERVERIP' ,defaultValue: '', description: 'tomcat server')
    }
    stages{
        stage("verify tomcat scipt"){
            steps{
                sh "ls -l tomcatinstallation.sh"

            }
        }
        stage("copy tomcat script to remote server "){
            steps{
                sh """
                scp -i /tmp/nvirginia.pem tomcatinstallation.sh ec2-user@${SERVERIP}:/tmp/
                ssh -i /tmp/nvirginia.pem ec2-user@${SERVERIP} "ls -l /tmp/
                """
            }
        }
    }
}