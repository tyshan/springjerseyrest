# springjerseyrest

This example shows how to use Spring boot, Jersey to create a rest plan with JPA+HSQL DB support.

0, start app
	1)install openjdk8, maven3.x and Git;
	2)run a console like:
		mvn clean package exec:java -Dmaven.test.skip=true


1, Campaing data generator and User data generator rest service without JAP support

	1) Campaign Data Generator

	GET http://localhost:3000/campaign?x={number}&y={number}&z={number}

	x,attributes size in a target
	y,less equal than 26, target size in a campaign
	z,less equal than 10000, campaign size in a campaign list


	2) User data generator

	GET http://localhot:3000/user
	
	They can be tested via curl or browser directly

2, User API with JPA support

	1).save user
	POST http://localhost:3000/api/user

	2) get user
	GET http://localhost:3000/api/user/{id}

	3) delete user
	DELETE http://localhost:3000/api/user/{id}

	4) find users by page,size,
	GET http://localhost:3000/api/user?page={page}&size={size}

	page, page number,default 1
	size, page size,default 10


