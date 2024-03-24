# Office Workstation Reservation System
This Spring Boot application manages office workstation reservations. Users can reserve workstations for a single day, and the system ensures that users can have multiple ongoing reservations but not more than one workstation reserved for a specific date. Data persistence is handled efficiently using Spring Data JPA.

## Setup Instructions

1. **Set Up PostgreSQL**: Ensure PostgreSQL is installed and running on your local machine. If not installed, download and install it from PostgreSQL Downloads.

2. **Database Configuration**: Open the **application.properties** file in your Spring Boot project and add the following properties to configure the PostgreSQL database:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/u5d5w1Project
spring.datasource.username=postgres
spring.datasource.password=firstDb
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.default_schema=public
spring.jpa.hibernate.ddl-auto=update
Replace localhost:5432/u5d5w1Project with your PostgreSQL server URL and database name.
Update spring.datasource.username and spring.datasource.password with your PostgreSQL username and password if different.
Run the Application: Compile and run the Spring Boot application to start the office workstation reservation system. Ensure that the PostgreSQL server is running before running the application.
```

- Replace **localhost:5432/u5d5w1Project** with your PostgreSQL server URL and database name.
- Update **spring.datasource.username** and **spring.datasource.password** with your PostgreSQL username and password if different.

3. Run the Application: Compile and run the Spring Boot application to start the office workstation reservation system. Ensure that the PostgreSQL server is running before running the application.

## Usage

Once the application is set up and running, users can interact with it to reserve workstations for their office needs.

