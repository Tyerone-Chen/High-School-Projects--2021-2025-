-- 1 -- 
CREATE View vw_StudentGrade 
AS
SELECT s.StudentID, s.StudentLastName, s.StudentFirstName, r.CourseID, r.Grade 
FROM Student as s
INNER Join Roster as r
	ON s.studentID = r.StudentID

-- 2 --
ALTER View vw_StudentGrade
AS
SELECT s.StudentID, StudentFirstName, StudentLastName, c.CourseID, Grade, CourseName
FROM Student as s
INNER Join Roster as r
	ON s.StudentID = r.StudentID
INNER Join Course as c
	ON r.CourseID = c.CourseID

-- 3 --
CREATE View vw_InstructorDepartment
WITH SCHEMABINDING
AS
SELECT InstructorID, InstructorLastName,  InstructorFirstName, DepartmentName
FROM Instructor as i
INNER Join Department as d
	ON i.DepartmenID = d.DepartmentID

-- 4 --
CREATE Unique Clustered
INDEX IX_DepartmentInstructor
ON vw_InstructorDepartment(DepartmentName, InstructorID)

-- 5 --
CREATE View vw_CourseLookup 
AS
SELECT CourseID, CourseName, CourseCredit, DepartmentName
FROM Course as c
INNER Join Department as d
	ON c.DepartmenID = d.DepartmentID
WHERE CourseID LIKE '107%'

-- 6 --
ALTER VIEW vw_CourseLookup
AS
SELECT CourseCredit
FROM Course
SET CourseCredit = 1
WHERE CustomerID = 107185

-- 7 --
CREATE View vw_InstructorClass 
WITH ENCRYPTION
AS
SELECT InstructorLastName, InstructorFirstName, BeginDate, EndDate, Location
FROM Instructor as i
INNER JOIN Class as c
	ON i.InstructorID = c.InstructorID
WHERE EndDate = '2011'

-- 8 --
CREATE View vw_Sales_PersonSales 
AS
SELECT p.FirstName as 'FirstName', p.LastName as 'LastName', s.CustomerID as 'CustomerID', sum(s.TotalDue) as 'Total Sales'
FROM Sales.SalesOrderHeader as s 
INNER JOIN Person.Person as p
ON p.BusinessEntityID = s.SalesPersonID

-- 9 --
ALTER View vw_Sales_PersonSales 
WITH Schemabinding
AS
SELECT p.FirstName as 'FirstName', p.LastName as 'LastName', s.CustomerID as 'CustomerID', sum(s.TotalDue) as 'Total Sales'
FROM Sales.SalesOrderHeader as s 
INNER JOIN Person.Person as p
ON p.BusinessEntityID = s.SalesPersonID

-- 10 --
DROP View vw_Sales_PersonSales