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
  
deploy adapters: [tomcat9(credentialsId: '43d974b7-ee84-4df4-91d1-0c63d27c091b', path: '', url: "${ip}")], contextPath: "${contextpath}", war: '**/*.war'
}


def runSelenium(path)
{
  sh "java -jar /home/ubuntu/.jenkins/workspace/${path}/testing.jar" 
}
