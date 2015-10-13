# springjerseyrest
Spring boot, Jersey Rest Example Application with JPA support


0) install JDK8 & Maven
In a console, run as:
mvn exec:java -Dmaven.test.skip=true



Test via browser or curl

1. Campaign Data Generator

GET http://localhost:3000/campaign?x={number}&y={number}&z={number}

x            attribute, attributes size in target
y            less equal than 26, target size
z            less equal than 10000, campaign size


2, User data generator

Create a API for user generation.

GET http://localhot:3000/user

3) User API

a. save user
POST http://localhost:3000/api/user

b, get user
GET http://localhost:3000/api/user/{id}

c, delete user
DELETE http://localhost:3000/api/user/{id}

d, find users by page,size,
GET http://localhost:3000/api/user?page={page}&size={size}

page page order
size size in one page


