Use AdventureWorks2016
Go

While (Select Avg(ListPrice) From dbo.Product) < 500
Begin
	Update dbo.Product
	Set ListPrice = ListPrice * 2
	Select Max(ListPrice) From dbo.Product
	If (Select Max(ListPrice) From dbo.Product) < 5000.01
		Continue
	Else
		Break
End
Go

Select Max(ListPrice) From dbo.Products
Go