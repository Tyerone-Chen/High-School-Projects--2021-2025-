-- 1 Databse Creation--
CREATE DATABASE Video;

USE Video;
-- 2a Create Table Name Members -- 
CREATE TABLE Member 
(
	MemberID Numeric(10) PRIMARY KEY NOT NULL,
	LastName VARCHAR(25) NOT NULL,
	FirstName VARCHAR(25),
	Address VARCHAR(100),
	City VARCHAR(30),
	Phone VARCHAR(15),
	JoinDate DATE NOT NULL DEFAULT GETDATE()
);

-- 2b --
CREATE TABLE Title
(
	TitleID Numeric(10) Primary Key Not Null,
	Title VarChar(60) Not Null,
	Description VarChar(400) Not Null,
	Rating VarChar(4),
	Category VarChar(20),
	ReleaseDate Date
);


-- 2c --
Create Table TitleCopy
(
	CopyID Numeric(10) Primary Key Not Null,
	TitleID Numeric(10) Unique Not Null,
	Status VarChar(15) Not Null
);

-- 2d --
Create Table Rental
(
	BookDate Date Primary Key Not Null,
	MemberID Numeric(10) Not Null, 
	CopyID Numeric(10) Not Null,
	ActRetDate Date,
	ExpRetDate Date,
	TitleID Numeric(10) Not Null
);

-- 2e --
Create Table Reservation
(
	ResDate Date Primary Key Not Null,
	MemberID Numeric Unique Not Null,
	TitleID Numeric(10) Not Null
);

EXEC sp_help Member
EXEC sp_help Title
EXEC sp_help TitleCopy
EXEC sp_help Rental
EXEC sp_help Reservation