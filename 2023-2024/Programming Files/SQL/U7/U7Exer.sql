CREATE Database ProjectInfo

Create Table Department
(
	DepartmentNoID Int Not Null Primary Key,
	DepartmentNo VarChar(4) Not Null,
	DepartmentName VarChar(75) Not Null
)

Create Table Project
(
	ProjectCodeID Int Not Null Primary Key,
	ProjectCode VarChar(5) Not Null,
	ProjectTitle VarChar(75) Not Null, 
	ProjectManagerFName Char(1) Not Null,
	ProjectManagerLName VarChar(40) Not Null,
	ProjectBudget Int Not Null,
)


CREATE Table Employees
(
	EmployeeNo VarChar(6) Not Null Primary Key,
	EmployeeFName Char(1) Not Null,
	EmployeeLName VarChar(40) Not Null,
	HourlyRate Int Not Null,
	DepartmentNoID Int Not Null References Department(DepartmentNoID),
	ProjectCodeID Int Not Null References Project(ProjectCodeID)
)

SELECT *
From Employees