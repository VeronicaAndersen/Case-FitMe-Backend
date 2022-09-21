

<div align="center">
<h1 align="center">Case MeFit</h1>
</div>

<!-- TABLE OF CONTENTS -->
# Table of Contents
[About the Project](-about-the-project)  
[Installation](-install)  
[Usage](-usage)  
[Maintainers](-maintainers)  
[Contributing](-contributing)


<!-- ABOUT THE PROJECT -->
# About the project
<h3>&nbsp; <a href="https://github.com/VeronicaAndersen/Case-FitMe-Backend/wiki">Requirement Specification</a></h3>
A list of all our requirements.


<h3><a href="https://fitmecase.herokuapp.com/swagger-ui/index.html#/">View API Endpoints</a>
  </h3>
A detailed guide on how to access our endpoints.


<!-- INSTALL -->
## Installation

### Repository

The application is free to clone straight from github. Type this into your selected git console to get the current main
version:

```
git clone https://github.com/VeronicaAndersen/Case-FitMe-Backend.git
```

### IDE software

To run and use this repository you can use a software that you like. This one was build in IntelliJ IDEA and are using
spring boot with plugin Gradle.

## Setting up locally database connection

In the file located in src/main/resources/application.properties enter the following:

```
spring.datasource.url = <YourHost>:5432/<NameOfYourDatabase>
spring.datasource.username = <UsernameForDatabase>
spring.datasource.password = <PasswordForDatabase>

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL95Dialect
spring.jpa.hibernate.ddl-auto = create
logging.level.org.hibernate.state = trace
spring.jpa.show-sql = true
spring.sql.init.platform = postgres
spring.jpa.defer-datasource-initialization = true
spring.sql.init.mode = always
springdoc.swagger-ui.operationsSorter = method
```

Replace these with yours database credentials. You will find these under heroku Overview:
1. Click Heroku Postgres

![img_1](https://user-images.githubusercontent.com/70511142/190142893-9b0db79f-48d9-4f7f-ae03-c742f11490d3.png)<br/>
2. Click settings and replace these four with the credentials that shows.
- YourHost
- NameOfYourDatabase
- UsernameForDatabase
- PasswordForDatabase

## Deployment [Docker & Heroku]

https://fitmecase.herokuapp.com/swagger-ui/index.html#/

In the terminal write this commands:
```
1. heroku login
2. docker build -t <NameOfDocker> .    
3. docker run -p 8087:8080 <NameOfDocker>    
4. heroku create --region eu --app <NameOfDeployment>
5. heroku container:login    
6. heroku container:push web --app <NameOfDeployment>   
7. heroku container:release web --app <NameOfDeployment>    
```

### Testing in Postman

In Postman you can test if it works with:
http://localhost:8087/api/v1/set

That will show some JSON data like:

```
{
      "id": 1,
      "exerciseRepetition": 8
}
```

### Heroku

Configure Add-ons called Heroku Postgres in heroku under Overview.

![img](https://user-images.githubusercontent.com/70511142/190142888-32db5866-80b5-4cec-85bd-2f200ed75e41.png)


<!-- CONVENTIONS -->
# Conventions
- `feat`: introduces a new feature to the codebase
- `fix`: patches a bug in codebase
- `chore`: updating grunt tasks etc; no production code change
- `docs`: changes to the documentation

Read more: [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) 


<!-- MAINTAINERS -->
# Maintainers
Veronica Andersen @VeronicaAndersen <br/>
Adrian Mattsson @adrianmttss <br/>
Sona Rahimova @suay-selay
