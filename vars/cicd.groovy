def newGit(repo)
{
  git "${repo}" 
}

def newMaven()
{
  sh 'mvn package'
}

def newDeploy(ip,contextpath)
{
  
deploy adapters: [tomcat9(credentialsId: 'f4a8fd35-49f8-40fb-853d-f55a9ab1d552', path: '', url: "${ip}")], contextPath: "${contextpath}", war: '**/*.war'
}


def runSelenium(path)
{
  sh "java -jar /home/ubuntu/.jenkins/workspace/${path}/testing.jar" 
}
