## Installation Sonar
Create a Sonar server

    $ docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube:lts
    
Install the Kotlin plugin

    $ git clone https://github.com/arturbosch/sonar-kotlin
    $ cd sonar-kotlin
    $ mvn package
    $ docker cp target/sonar-kotlin-<VERSION>.jar sonarqube:/opt/sonarqube/extensions/plugins
    $ docker stop sonarqube
    $ docker start sonarqube

Access Sonar via http://localhost:9000/
