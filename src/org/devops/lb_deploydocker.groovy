package org.devops

def despliegueContenedor(projectGitName){
    // Detener y eliminar el contenedor si ya existe
    sh """
        if [ \$(docker ps -a -q -f name=${projectGitName}) ]; then
            docker stop ${projectGitName} || true
            docker rm ${projectGitName} || true
        fi
    """

    // Asegurarse de tener la última versión
    sh "docker pull javv0/${projectGitName}"

    // Ejecutar el contenedor en red bridge (por defecto)
    sh """
        docker run -d --name ${projectGitName} \
        --network bridge -p 5174:5174 \
        --user root javv0/${projectGitName}
    """
}
