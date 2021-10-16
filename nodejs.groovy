job('Inventory Server'){
    scm {
        git('https://github.com/aminemarckader/inventory-server.git') {
            node /gitConfigName('aminemarckader')
            node /gitConfigEmail('aminemarckader@gmail.com')
        }
    }

    triggers {
        scm('H/5 * * * *')
    }

    wrappers {
        nodejs('nodejs')
    }

    steps {
        shell('npm i')
    }
}