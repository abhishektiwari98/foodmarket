# Foodmarket
Understand the food products, their ingredients and allergens in the web application.

Food-market is a webapp developed to help people make informed decisions about their food choices. We collect raw data 
from FDA and similar public sources, process and transform the raw data into valuable insights that the users can 
consume. 

# Architecture 
The following diagram summarizes the architecture of the project along with various technologies and components used:   
![alt text](docs/images/architecture.png)

# Database setup
The database is created using AWS RDS service with Postgres database. We use [AWS's managed Postgres service](https://aws.amazon.com/rds/postgresql/)   
Database credentials can be found in the Heroku app under `Settings`, and should be made available via environment variables as shown below:  
![alt text](docs/images/db-configs.png)  
IMP: Do not add credentials in the git source code. The same env variables can be provided to IntelliJ to run the app locally.   


# Database schema 
![alt text](docs/images/schema.png)  


# Build 
The backend application is developed using Java with [SpringBoot](https://spring.io/projects/spring-boot) and uses [Gradle](https://docs.gradle.org/current/userguide/userguide.html) 
as a build tool. Following are the steps to setup the application locally: 
1. Clone the source code
   1. `git clone git@github.com:abhishektiwari98/foodmarket.git`
   2. Make sure git is installed and configured. Instructions [here](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git). 
2. Run local build
   1. This requires Gradle setup. Instructions [here](https://gradle.org/install/)
   2. Run build with `./gradlew clean build` from foodmarket directory.
3. Import project in IntelliJ
   1. IntelliJ is an excellent IDE for Java based applications. 
   2. Go to File -> New -> Project from existing sources and select the foodmarket directory.
   3. Import and select Gradle in the next window (as shown in the image)  
      ![alt text](docs/images/import.png)
4. Run the backend by
   1. You can run `FoodmarketApplication` directly from IntelliJ
   2. You can also launch it with gradle as `./gradlew bootRun`

# Deployment 
The project is deployed to [Heroku](https://dashboard.heroku.com/apps) and can be accessed at:  
https://utsa-food-market.herokuapp.com/
To login
use
email- a@b.com
password- 123456

IMP: It is important to have Procfile with the following command to enable Heroku to launch the application:   
`web: java -Dserver.port=$PORT $JAVA_OPTS -jar build/libs/foodmarket-0.0.1-SNAPSHOT.jar`
