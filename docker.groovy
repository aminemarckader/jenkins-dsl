
job('NodeJS Docker example') {
    scm {
        git('https://github.com/aminemarckader/inventory-server.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('aminemarckader')
            node / gitConfigEmail('aminemarckader@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('aminemarckader/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
