package org.devops

def publicarImage(projectGitName){
    withCredentials([usernamePassword(
        credentialsId: "dockerhub-token-javv0", 
        passwordVariable: 'DOCKERHUB_PASSWORD', 
        usernameVariable: 'DOCKERHUB_USERNAME')]) {
        
        sh "docker login -u ${DOCKERHUB_USERNAME} -p ${DOCKERHUB_PASSWORD}"
        sh "docker tag ${projectGitName} ${DOCKERHUB_USERNAME}/${projectGitName}"
        sh "docker push ${DOCKERHUB_USERNAME}/${projectGitName}"
    }
}
