<div align="center">



<h1>Buy4Wheels</h1>

This project is a desktop application in Spring Boot that was created to facilitate the management of a used car dealership and allows the dealership staff to search and deliver new car offers.
You can check this project out by yourself 
on [Swagger offer](https://app.swaggerhub.com/apis/PHADALA24/buy-4_wheels_offer_api/1.0.0) and [Swagger car](https://app.swaggerhub.com/apis/PHADALA24/buy-4_wheels_car_api/1.0.0) .
If you want to see frontend screenshots also, you can go to [Images](#frontEnd).


## Tech Stack
Code: <br>
![Static Badge](https://img.shields.io/badge/java_21-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Static Badge](https://img.shields.io/badge/Spring%20Security-6DB33F.svg?style=for-the-badge&logo=Spring-Security&logoColor=white)
![Static Badge](https://img.shields.io/badge/JUnit5-25A162.svg?style=for-the-badge&logo=JUnit5&logoColor=white)
<br>
FrontEnd: <br>
![HTML5](https://img.shields.io/badge/HTML5-E34F26.svg?style=for-the-badge&logo=HTML5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6.svg?style=for-the-badge&logo=CSS3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E.svg?style=for-the-badge&logo=JavaScript&logoColor=black)
<br>
Other: <br>
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1.svg?style=for-the-badge&logo=MySQL&logoColor=white)
![Github](https://img.shields.io/badge/GitHub-181717.svg?style=for-the-badge&logo=GitHub&logoColor=white)
![IntellijIdea](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=for-the-badge&logo=IntelliJ-IDEA&logoColor=white)

</div>

# Usługi
The project consists of:
-three backend microservices
    - auth - responsible for authorizations
    - car - responsible for managing car brands and models
    - offer - responsible for managing offers and brands and car models included in them
- utilis library for backend applications (`lib`)
- static frontend page - interface for using the application

  ## How to build the project on your own
#### To build the project:
<ol>
 <li>start mySQL server</li>
 <li>import the attached database</li>
 <li>Expose the database to localhost:3306</li>
<li>Clone the repository:</li>

```
git clone https://github.com/hadala-p/Buy4Wheels.git
```
<li>Go to the folder with cloned repository</li> 
<li>Run the command on all services:</li>

```
mvn install
mvn run 
```
<li>In folder target you should find a file named: application-{version}-SNAPSHOT.jar</li>
</ol>

#### To build the docker image with Docker Compose:
<ol>
<li>Clone the repository:</li>

```
git clone https://github.com/hadala-p/Buy4Wheels.git
```
<li>Go to the folder with cloned repository</li> 
<li>Run the command:</li>

```
docker-compose build
```
<li>By using:

```
docker images
```
</li>
</ol>
