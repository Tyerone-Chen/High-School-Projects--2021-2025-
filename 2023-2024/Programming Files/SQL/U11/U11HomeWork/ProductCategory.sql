Use AdventureWorks2016
Go

-- ProductNumber & ProductSubcategoryID
Select ProductNumber,
	ProductLine, 
	Category = Case ProductLine
	When 'R' Then 'Road'
	When 'M' Then 'Mountain'
	When 'T' Then 'Touring'
	When 'S' Then 'Sales'
	Else 'Not For Sale'
End
From dbo.Product
Order By ProductNumber
Go