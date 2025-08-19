Use AdventureWorks2016
GO

Create Table MyCompanies
(
	id_num Int Identity(100,5),
	company_name VarChar(100)
)
GO

Insert Into MyCompanies
Values
('A Bike Store'),
('Advanced Bike Components'), 
('Aerobic Exercise Company'),
('Associated Bikes'),
('Exemplary Cycles'),
('Metropolita Sports Supply'),
('Modular Cycle Systems'),
('Progressive Sports')
Go

Select *
From MyCompanies
Where company_name Like '%Bike%'; 
Go