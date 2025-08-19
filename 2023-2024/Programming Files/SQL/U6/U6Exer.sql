CREATE Database AdvanceDB

-- 1 --
CREATE Table Student
(
	StudentID Int Not Null Primary Key,
	StudentLastName VarChar(25) Not Null,
	StudentFirstName VarChar(20) Not Null,
	StudentAddress VarChar(30),
	StudentCity VarChar(15),
	StudentState Char(2),
	StudentZip VarChar(9),
	StudentPhone VarChar(12),
	StudentDOB Date Not Null
)

-- 2 --
CREATE Table Department
(
	DepartmentID Int Not Null Primary Key,
	DepartmentName VarChar(30) Not Null
)

-- 3 --
CREATE Table Instructor
(
	InstructorID Int Not Null Primary Key,
	InstructorLastName VarChar(40) Not Null,
	InstructorFirstName VarChar(20) Not Null,
	InstructorPhone VarChar(12),
	InstructorDepartmentID Int Not Null References Department(DepartmentID) 
)

-- 4 --
INSERT INTO Department
VALUES 
(1, 'BUSINESS INFORMATION TECH'),
(2, 'MARKETING'),
(3, 'ACCOUNTING'),
(4, 'ELECTRONICS'),
(5, 'INDUSTRIAL')

SELECT *
FROM Department

-- 6 --
INSERT INTO Instructor
VALUES
(432, 'SMITH', 'BOB', '262-692-8999', 1),
(433, 'JONES', 'BETTY', '262-692-8799', 1),
(434, 'FAVRE', 'JANE', '262-692-7999', 2),
(442, 'GREEN', 'TOM', '262-692-8889', 2),
(532, 'EDWARDS', 'TONY', '262-692-4499', 3),
(742, 'BROWN', 'BUTCH', '262-692-5499', 4),
(772, 'CRASH', 'KATHY', '262-692-4479', 5),
(3432, 'WILLIAMS', 'SUE', '262-692-8759', 4)

SELECT *
FROM Instructor

-- 7 --
INSERT INTO Student
VALUES
(123, 'JONES', 'TOM', '1400 SOUTH 27 ST', 'MILWAUKEE', 'WI', 53227, '414-645-8244', '1977-04-24'),
(124, 'MARSHELL', 'CHRIS', '9400 SOUTH 87 ST', 'MILWAUKEE', 'WI', 53229, '414-647-8544', '1981-01-24'),
(135, 'ADAMS', 'GEORGE', '3400 SOUTH 5 ST', 'MILWAUKEE', 'WI', 53227, '414-282-8644', '1965-11-20'),
(143, 'FLINSTONE', 'ALICE', '1840 SOUTH 57 ST', 'MILWAUKEE', 'WI', 53237, '414-645-8364', '1975-09-07'),
(153, 'BIDDELL', 'SAM', '2340 SOUTH 67 ST', 'MILWAUKEE', 'WI', 53227, '414-645-8244', '1979-12-14')

SELECT * 
FROM Student

-- 7 --
SELECT StudentID, StudentLastName, StudentFirstName
FROM Student
ORDER BY StudentLastName

-- 8 --
SELECT InstructorID, InstructorLastName, InstructorFirstName, InstructorDepartmentID
FROM Instructor
ORDER BY InstructorDepartmentID

-- 9 --
SELECT DepartmentID, DepartmentName
FROM Department
ORDER BY DepartmentName

-- 10 --
UPDATE Student
SET StudentPhone = '414-888-1234'
WHERE StudentID = 123


-- 11 --
SELECT *
FROM Student
WHERE StudentID = 123

-- 12 --
UPDATE Student
SET StudentCity = 'Cudahy'
WHERE StudentZip = 53227

-- 13 --
SELECT *
FROM Student
WHERE StudentCity = 'Cudahy'

-- 14 --
UPDATE Instructor
SET InstructorDepartmentID = 2
WHERE InstructorID = 742

-- 15 --
SELECT *
FROM Instructor
WHERE InstructorDepartmentID = 1 or InstructorDepartmentID = 3 or InstructorDepartmentID = 5

-- 16 --
DELETE FROM Student
WHERE StudentID = 135

-- 17 --
DELETE FROM Department
WHERE DepartmentID = 4

-- 18 --
DELETE FROM Instructor
WHERE InstructorID = 3432

-- 19 --

-- 20 --
DELETE Student
WHERE 1=1;


