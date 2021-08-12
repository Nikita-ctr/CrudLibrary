## Simple crud application
![f](https://user-images.githubusercontent.com/85461155/129126650-4b1bb5c3-a0f9-4861-b972-5645e22b7f9d.png)
#### Technologies used
- Spring
- H2 database
- Spring Data
- Hibernate
- Tomcat 9
#### Steps to Setup

1.create a database with configuration as shown below.

![m](https://user-images.githubusercontent.com/85461155/129126808-50c5f53b-2f30-4f2f-875f-e47ee25688b7.png)   
2.then create a table
~~~
create table BOOKS
(
    ID          INT auto_increment,
    BOOK_TITLE VARCHAR(255) not null,
    BOOK_AUTHOR VARCHAR(255) not null,
    BOOK_COUNT INT          not null,
    BOOK_PRICE INT          not null,
    BOOK_DATE  TIMESTAMP    not null,
        primary key (ID)
);
~~~
3.Change h2 username and password as per your installation

~~~ 
open src/main/resources/META_INF/persistence.xml
~~~
~~~
change javax.persistence.jdbc.user
and javax.persistence.jdbc.password as per your h2 installation
~~~
4.deployment to tomcat
~~~
Run->Edit Configurations->Tomacat 9.0.50 war exploded
~~~
