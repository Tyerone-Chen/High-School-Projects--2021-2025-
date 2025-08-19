--- Select all Columns ---
SELECT *
	FROM Sales.Customer

--- Select SPecific Column ---
SELECT LastName 
	FROM Person.Person

--- Select Multiple Columns
SELECT Name, ProductNumber, ReorderPoint
	FROM Production.Product

--- Select ProductID 356 ---
SELECT Name, ProductNumber, ReorderPoint
	FROM Production.Product
WHERE ProductID = 356;

--- Multi-Where CLause ---
SELECT NAME, SalesPersonID
	FROM Sales.Store
WHERE Name BETWEEN 'g' and 'j'
	AND SalesPersonID > 283;

--- Where with that starts with a clause ---
SELECT Name, SalesPersonID
	FROM Sales.Store
WHERE Name LIKE '%Bike%'

--- Stores NOT between g & j ---
SELECT NAME, SalesPersonID
	FROM Sales.Store
WHERE Name NOT BETWEEN 'g' and 'j'
	AND SalesPersonID > 283;

--- Using the NOT EQUAL to Comparison ---
SELECT Name, SalesPersonID
	FROM Sales.Store
WHERE (Name <> 'g' AND NAME <> 'j')
	AND SalesPersonID > 283
ORDER BY SalesPersonID, Name DESC

--- Using Keyword IN to search through groups ---
SELECT Name, SalesPersonID
	FROM Sales.Store
WHERE Name BETWEEN 'g' AND 'j'
	AND SalesPersonID IN (280, 281, 283)
ORDER BY SalesPersonID, Name DESC

--- Use the EXIST clause to limit searches  ---
SELECT Name, SalesPersonID
	FROM Sales.Store
WHERE EXISTS
	(SELECT * FROM Sales.SalesPerson
	 WHERE TerritoryID = 2);

SELECT *
FROM Person.Password
WHERE year(ModifiedDate) = 2010
ORDER BY ModifiedDate, BusinessEntityID DESC;


SELECT count(*) -- Counts how many rows
FROM Person.Person

SELECT count(BusinessEntityID) as 'UserCount', EmailPromotion -- Counts how many people per email promotions
FROM Person.Person
WHERE EmailPromotion > 0
GROUP BY EmailPromotion
ORDER BY EmailPromotion desc;

-- Limit to high order values --
SELECT SalesOrderID, sum(OrderQty) as 'TotalItems'
FROM Sales.SalesOrderDetail
GROUP BY SalesOrderID
HAVING sum(OrderQty) >= 10;
