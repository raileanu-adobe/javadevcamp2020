CREATE USER 'jdc'@'%' IDENTIFIED BY 'devcamp';

GRANT ALL PRIVILEGES ON *.* TO 'jdc'@'%' WITH GRANT OPTION;

drop database if exists javadevcamp;

create database if not exists javadevcamp;

use javadevcamp;

create table if not exists users(
     id INT AUTO_INCREMENT,
     json VARCHAR(10000) NOT NULL,
     PRIMARY KEY (id)
) ENGINE=INNODB;


create table if not exists campaigns(
     id INT AUTO_INCREMENT,
     json VARCHAR(10000) NOT NULL,
     PRIMARY KEY (id)
) ENGINE=INNODB;

create table if not exists advertisers(
     id INT AUTO_INCREMENT,
     json VARCHAR(10000) NOT NULL,
     PRIMARY KEY (id)
) ENGINE=INNODB;

create table if not exists publishers(
     id INT AUTO_INCREMENT,
     json VARCHAR(10000) NOT NULL,
     PRIMARY KEY (id)
) ENGINE=INNODB;


insert into users(id, json)
values
(null, '{"firstName":"John","lastName":"Doe","email":"john.doe@adobe.com","profile":{"gender":"MALE","dateOfBirth":"1989-04-12","interests":["FASHION"]}}'),
(null, '{"firstName":"Green","lastName":"Montgomery","email":"green.montgomery@adobe.com","profile":{"gender":"NA","dateOfBirth":"1991-07-04","interests":["PHOTOGRAPHY","DIY","TATTOOS"]}}'),
(null, '{"firstName":"Jeanine","lastName":"Patton","email":"jeanine.patton@adobe.com","profile":{"gender":"FEMALE","dateOfBirth":"2014-04-14","interests":["SPORTS","DESIGN","HOME"]}}'),
(null, '{"firstName":"Madelyn","lastName":"Mooney","email":"madelyn.mooney@adobe.com","profile":{"gender":"FEMALE","dateOfBirth":"2009-08-13","interests":["SPORTS","BOOKS","FOOD"]}}'),
(null, '{"firstName":"Billie","lastName":"Tucker","email":"billie.tucker@adobe.com","profile":{"gender":"MALE","dateOfBirth":"2016-05-18","interests":["ART","SPORTS","SHOES"]}}'),
(null, '{"firstName":"Preston","lastName":"Brock","email":"preston.brock@adobe.com","profile":{"gender":"NA","dateOfBirth":"1996-05-03","interests":["PHOTOGRAPHY","TRAVEL","TATTOOS"]}}'),
(null, '{"firstName":"Schultz","lastName":"Schultz","email":"schultz.schultz@adobe.com","profile":{"gender":"MALE","dateOfBirth":"1996-03-17","interests":["TECHNOLOGY","HEALTH","SPORTS"]}}'),
(null, '{"firstName":"Fitzgerald","lastName":"Herrera","email":"fitzgerald.herrera@adobe.com","profile":{"gender":"MALE","dateOfBirth":"1990-08-01","interests":["SPORTS","SHOES","PHOTOGRAPHY"]}}'),
(null, '{"firstName":"Paul","lastName":"Boone","email":"paul.boone@adobe.com","profile":{"gender":"NA","dateOfBirth":"2012-12-06","interests":["CARS","TECHNOLOGY","OUTDOORS"]}}'),
(null, '{"firstName":"Clara","lastName":"Patton","email":"clara.patton@adobe.com","profile":{"gender":"FEMALE","dateOfBirth":"2000-04-14","interests":["DESIGN", "SPORTS"]}}');


insert into campaigns(id, json)
values
(null, '{name":"Females with age between 20 & 30, interested in SPORTS","startTime":1571673800000,"endTime":1576944200000,"target":{"gender":"FEMALE","interests":["SPORTS"],"minAge":20,"maxAge":30,"advertiserId": 2}}'),
(null, '{"name":"Males with age between 20 & 50, interested in SHOES and SPORTS","startTime":1558454600000,"endTime":1576944200000,"target":{"gender":"MALE","interests":["SPORTS","SHOES"],"minAge":20,"maxAge":50, "advertiserId": 1}}');


insert into publishers(id, json)
values
(null, '{"name":"FashionDays", "domains": ["SPORTS", "FASHION"], "advertisers":[1,2],"users":[1, 6, 7, 3, 4, 5]}'),
(null, '{"name":"Autovit","domains": ["TECHNOLOGY", "CARS"],"advertisers":[1],"users":[1, 2, 5, 10]}');


insert into advertisers(id, json)
values
(null, '{"name":"Volvo","publishers":[1,2],"campaigns":[1]}'),
(null, '{"name":"Zara","publishers":[1],"campaigns":[1, 2]}');
