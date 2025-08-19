-- Tyerone Chen --
-- 11/9/2023 --
-- U2 Asignment --

-- 1 --
SELECT *
FROM Person.Person

-- 2 --
SELECT LastName, FirstName, BusinessEntityID
FROM Person.Person

-- 3 --
SELECT LastName, FirstName, BusinessEntityID
FROM Person.Person
	WHERE BusinessEntityID = 285

-- 4 --
SELECT LastName, FirstName, BusinessEntityID
FROM Person.Person
	WHERE BusinessEntityID IN (285, 293, 11)

-- 5 --
SELECT LastName, FirstName
FROM Person.Person
	WHERE LastName = 'Abel'

-- 6 --
SELECT LastName, FirstName
FROM Person.Person
	WHERE LastName IN ('Abel', 'Baker', 'Barber')

-- 7 --
SELECT StateProvinceCode, CountryRegionCode, Name
FROM Person.StateProvince
ORDER BY CountryRegionCode DESC, Name DESC

-- 8 --
SELECT StateProvinceCode, CountryRegionCode, Name
FROM Person.StateProvince
WHERE StateProvinceCode IN ('CA')

-- 9 --
SELECT ProductID, ListPrice, ModifiedDate
FROM Production.ProductListPriceHistory 

-- 10 --
SELECT ProductID, ListPrice, ModifiedDate
FROM Production.ProductListPriceHistory 
WHERE year(ModifiedDate) = 2012 

-- 11 --
SELECT ProductID, avg(ListPrice) as 'avgPrice'
FROM Production.ProductListPriceHistory 
GROUP BY ProductID

-- 12 --
SELECT ProductID, avg(ListPrice) as 'avgPrice'
FROM Production.ProductListPriceHistory 
GROUP BY ProductID
	HAVING avg(ListPrice) >= 25

-- 13 --
SELECT count(*) as 'TotalRows'
FROM HumanResources.Employee

-- 14 --
SELECT count(City) as 'FromBothell' 
FROM Person.Address
	WHERE City = 'Bothell'

-- 15 --
SELECT Name
FROM Production.Location
	WHERE Name LIKE '%Paint%'
