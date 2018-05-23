## Installation Sonar
Ein Sonar-Server kann mit Hilfe von Docker recht einfach aufgesetzt werden, etwa wie folgt:

    $ docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube:lts
    
Zusätzlich muss noch das Kotlin-Plugin installiert werden, etwa wie folgt:

    $ git clone https://github.com/arturbosch/sonar-kotlin
    $ cd sonar-kotlin
    $ mvn package
    $ docker cp target/sonar-kotlin-<VERSION>.jar sonarqube:/opt/sonarqube/extensions/plugins
    $ docker stop sonarqube
    $ docker start sonarqube

Nun kann mittels http://localhost:9000/ auf Sonar zugegriffen werden.
