The application is build using java and Maven.
To execute the application:
1. download the code and build in eclipse using maven build
2. run the ApplicationStarter class
3. database used is H2, it can be accessed using http://localhost:8080/h2-console
	Data base credentials and url are:
	spring.datasource.url=jdbc:h2:mem:demo
	spring.datasource.driverClassName=org.h2.Driver
	spring.datasource.username=root
	spring.datasource.password=SA
	spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
4. to test the appllication I have used postman. In Postman I have passed json body as parameters to insert/delete/update data
Below are the end points and data passed to rest API

POST: http://localhost:8080/api/persons/
{
    "firstName":"Sreejaya",
    "lastName":"Menon"
}

GET http://localhost:8080/api/persons/

POST http://localhost:8080/api/persons/1/address
{
    "street":"castlegateway",
    "city":"Lucan",
    "postalCode":"K78gdrfyt",
    "state":"Dublin"
}