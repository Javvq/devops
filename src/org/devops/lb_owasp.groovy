package org.devops

def AnalisisOwasp(projectGitName){
    sh """ docker run --rm -v ${projectGitName}Owasp:/zap/wrk/:rw \
        --user root --network=${env.NameNetwork} \
        ghcr.io/zaproxy/zaproxy:stable \
        zap.sh -cmd -quickurl ${env.dominio} \
        -quickout /zap/wrk/${projectGitName}Owasp.html \
        -quickprogress
    """
}
