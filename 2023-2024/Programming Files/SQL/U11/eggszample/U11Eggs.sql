-- 1st thing to do in a script is what database to use or declare vars --
USE AdventureWorks2016
GO;
-- end of first batch, gets sent to the server --

-- 2 var decleration --
Declare @Ident Int;
Declare @Name VarChar(20);
Declare @TotalCost Money;

Declare @Test Int, @Test2 Money; -- multi vars declera --

Declare @InterestingRows Table(
	RowId Int Not Null Identity Primary Key,
	Descriptor VarChar(255)
);

-- declaretion + innitilization --
DECLARE @Counter INT = 0;	-- initialization
DECLARE @MaxPrice MONEY = (SELECT MAX(UnitPrice) FROM Sales.SalesOrderDetail);

Select @MaxPrice

-- Use Set to innit --
Set @TotalCost = 10; -- manual set --
Set @TotalCost = @MaxPrice *1.1; --use prev vars
Set @TotalCost = (Select Max(UnitPrice) From Sales.SalesOrderDetail) -- directly from database --

-- use select innit --
Select @Test2 = MIN(UnitPrice) From Sales.SalesOrderDetail

-- display da vars --
Select @Counter, @MaxPrice, @TotalCost, @Test2