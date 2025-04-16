package org.devops

def AnalisisOwasp(projectGitName){
    sh """ docker run --rm -v ${projectGitName}Owasp:/zap/wrk/:rw \
        --user root --network=${env.NameNetwork} \
        -t owasp/zap2docker-stable \
        zap-full-scan.py \
        -t ${env.dominio} \
        -r ${projectGitName}Owasp.html -I
    """
}