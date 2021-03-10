DROP DATABASE IF EXISTS reliableedu;

CREATE DATABASE reliableedu;

\c reliableedu;

CREATE TABLE member
(
	id serial primary key,
	name varchar(60),
	email varchar(100),
	phone char(10),
	courses VARCHAR(60),
	msg VARCHAR(200)
);

CREATE TABLE contactus
(
	id serial primary key,
	name varchar(60),
	email varchar(100),
	phone char(10),
	msg VARCHAR(200)
);
