package org.devops

def buildImageDocker(projectGitName){
    sh "docker build -t javv0/${projectGitName} ."
}