CREATE Database IndexDB

-- 1 --
CREATE Table Employees
(
	EmployeeNumber Int Not Null,
	FirstName NVarChar(20) Not Null,
	LastName NVarChar(20) Not Null,
	Username NChar(8),
	DateHired Date,
	HourlySalary Money
)

-- 2 --
CREATE Table Rooms
(
	RoomID INT Not Null,
	RoomNumber NVarChar(10),
	LocationCode NVarChar(50) Default 'Silver Spring',
	RoomType NVarChar(20) Default 'Bedroom',
	BedType NVarChar(20) Default 'Queen',
	Rate Money Default 75.85, 
	Available Bit Default 0
)

-- 3 --
INSERT Into Employees
Values
(62480,'James', 'Bond', 'Jbond', '1988-10-25', 28.02)

-- 5 --
INSERT Into Employees
Values
(35844,'Gertrude', 'Monay', 'Gmonay', '2006-06-22', 14.36)

-- 7 --
CREATE Unique Clustered
INDEX IX_Employees_Clustered 
ON Employees(EmployeeNumber)

-- 8 --
ALTER Table Employees
ADD Constraint PK_EmployeeNumber
Primary Key (EmployeeNumber)

-- 9 --
DROP Index Employees.IX_Employees_Clustered 

ALTER Table Employees
DROP Constraint PK_EmployeeNumber

-- 12 --
INSERT Into Rooms (RoomID, RoomNumber, LocationCode, BedType, Rate, Available) 
Values
(1, 105, 'SLSP', 'King', 85.75, 1),
(2, 106, 'SLSP', 'Queen', 75.85, 1)

-- 13 --
CREATE INDEX IX_Room_NCU 
ON Rooms(RoomNumber);

-- 14 --
INSERT Into Rooms 
Values
(1, 105, 'SLSP', 'Conference', 'King', 85.75, 1)

-- 15 --
DROP Index Rooms.IX_Room_NCU 