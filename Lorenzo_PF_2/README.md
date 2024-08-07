# October Eats
October Eats is an MVC application which was designed for practicing REST API creation with SpringBoot; for testing purposes a Java Swing UI was created to interact with the REST API through the endpoints.  

- [Setup](#setup)
  - [OctoberEatsRestApi](#OctoberEatsRestApi)
    - [Dependencies](#dependencies)
    - [Database Setup](#database-setup)
   
  - [OctoberEatsUI](#OctoberEatsUI)
    - [Dependencies](#dependencies-1)
- [User Story Backlog (Deprecated)](#user-story-backlog-deprecated)
- [UML Class Diagram (Deprecated)](#uml-class-diagram-deprecated)

## Setup
### OctoberEatsRestApi
> Go to [folder](OctoberEatsRestApi).
#### Dependencies:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector Java
- Spring Boot Starter Test
- MapStruct
- MapStruct Processor

#### Database Setup
Is important to take in account that a database should be created before running the project with the name: "october_eats"
```SQL
CREATE DATABASE october_eats
```
Mysql server has to be available in port3306 with root username/password. Or update "application.properties" file accordingly.
```
spring.application.name=OctoberEats
spring.datasource.url=jdbc:mysql://localhost:3306/october_eats
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
When running the program for the first time the schema will be created. The second run is important to change "application.properties" file in order to indicate to Hibernate to only update the table from now:
```
spring.jpa.hibernate.ddl-auto=update
```
### OctoberEatsUI
> Go to [folder](OctoberEatsUI)

> [!IMPORTANT]  
> OctoberEatsRestApi should be running, so the UI can communicate with it; to test the application fill the database with data, [fillValues](FillValues.sql) SQL script is provided.
#### Dependencies:
- Gson







--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
#### User Story Backlog (Deprecated)

| **ID** | **Title**                              | **User Story**                                                                                                                                                          | **Acceptance Criteria**                                                                                                                                                                                                                                      |
|--------|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1      | User Registration                      | As a new user, I want to register for an account providing my name, address, email, and password so that I can use the application.                                      | 1. User registration by entering name, address, email, and password. <br> 2. System validates the email is not already registered. |
| 2      | User Login                             | As a registered user, I want to log in using my email and password so that I can access my account and place orders.                                                    | 1. User can enter email and password. <br> 2. System authenticates user.|
| 3      | Search Restaurants                     | As a user, I want to search for nearby restaurants so that I can see the available options.                                                                             | 1. User enter a search term(location or name of the restaurant). <br> 2. List of restaurants is displayed.                                                                          |
| 4      | View Restaurant Details                | As a user, I want to view details of a selected restaurant so that I can decide if I want to order from there.                                                          | 1. User can see the restaurant's menu and location.                                                                                                  |
| 5      | Add Items to Cart                      | As a user, I want to add menu items to my shopping cart and specify quantities so that I can place an order.                                                            | 1. User can select menu items and specify quantities. <br> 2. Selected items appear in the shopping cart.                                                                                     |
| 6      | Place Order                            | As a user, I want to place an order with selected items in my cart so that the restaurant can prepare my food.                                                           | 1. User can review items in the cart. <br>  2. Order is sent to the restaurant. <br> 3. User receives an order confirmation or declination.                                                                   |
| 7      | Order Confirmation for Restaurants     | As a restaurant, I want to receive and confirm or reject orders so that I can manage incoming requests.                                                                 | 1. Restaurant receives order notifications. <br> 2. Restaurant can accept or reject orders. <br> 3. User is notified of order status.                                                                                                                          |
| 8      | Track Order                            | As a user, I want to track the status of my order in real-time so that I know when it will be delivered.                                                                | 1. User can see order status updates (e.g., accepted, preparing, out for delivery).                                  |
| 9      | User-Friendly UI                       | As a user, I want an attractive and easy-to-use interface so that I can navigate the application effortlessly.                                                          | 1. Application uses Java Swing for UI. <br> 2. UI is intuitive and responsive. <br> 3. Users can easily access all functionalities like searching, adding to cart, and placing orders.                                                                          |
| 10     | Client-Server Architecture             | As a developer, I want to implement a client-server architecture so that the application can handle multiple user requests efficiently.                                 | 1. Clients can connect to a central server. <br> 1. Server manages client requests. <br> 3. Communication occurs through sockets.                                                                                                                               |
| 11     | Multi-threading for Server             | As a developer, I want to use multi-threading on the server so that multiple client connections can be handled simultaneously.                                          | 1. Server can handle multiple simultaneous connections. <br> 2. No concurrency issues occur when multiple users place orders.                                                                                                                               |
| 12     | Database Integration                   | As a developer, I want to use a MySQL database to store information about users, restaurants, menus, and orders so that data is managed efficiently.                     | 1. Database schema is designed for users, restaurants, menus, and orders. <br> 2. Application can perform CRUD operations on the database. <br> 3. Data is stored securely.                                                                                     |
