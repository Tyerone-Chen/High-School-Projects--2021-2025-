SELECT *
FROM Invoices

SELECT *
FROM Vendors

SELECT *
FROM ContactUpdates

SELECT * 
FROM GLAccounts

SELECT *
FROM Terms


-- 5 --
SELECT i.VendorID, i.InvoiceNumber as 'Invoice N0.' , v.VendorName as 'Vendor', i.InvoiceTotal as 'Invoice Total' 
FROM Invoices as i
INNER JOIN Vendors as v
	ON i.VendorID = v.VendorID

-- 6 --
SELECT i.VendorID, i.InvoiceNumber as 'Invoice N0.' , v.VendorName as 'Vendor', i.InvoiceTotal as 'Invoice Total',
t.TermsDueDays as 'Terms Due Days' 
FROM Invoices as i
INNER JOIN Vendors as v
	ON i.VendorID = v.VendorID
INNER JOIN Terms as t
	ON i.TermsID = t.TermsID

-- 7 --
SELECT g.AccountNo, v.VendorName, v.VendorContactFName + ' ' + v.VendorContactLName as 'Contact Person', g.AccountDescription
FROM Vendors as v
INNER JOIN GLAccounts as g
	ON v.DefaultAccountNo = g.AccountNo

-- 8 --
SELECT g.AccountNo, v.VendorName, v.VendorContactFName + ' ' + v.VendorContactLName as 'Contact Person', g.AccountDescription,
convert(varchar(12), InvoiceDueDate,107) as 'Invoice Date', convert(varchar(12), PaymentDate,107) as 'Invoice Due Date'
FROM Vendors as v
INNER JOIN GLAccounts as g
	ON v.DefaultAccountNo = g.AccountNo
INNER JOIN Invoices as i
	ON v.VendorID = i.VendorID

-- 9 --
SELECT v.VendorName, c.FirstName, c.LastName
FROM Vendors as v
INNER JOIN ContactUpdates as c
	ON v.VendorID = c.VendorID

-- 10 --
SELECT v.VendorName, c.FirstName, c.LastName
FROM Vendors as v
LEFT OUTER JOIN ContactUpdates as c
	ON v.VendorID = c.VendorID

-- 11 --
SELECT v.VendorName, c.FirstName, c.LastName
FROM Vendors as v
LEFT OUTER JOIN ContactUpdates as c
	ON v.VendorID = c.VendorID
WHERE FirstName IS NULL


-- 12 --
SELECT *
FROM ContactUpdates
INSERT INTO ContactUpdates (LastName, FirstName)
VALUES
('Johnson', 'Shayna')

-- 13 --
SELECT v.VendorName, c.FirstName, c.LastName
FROM Vendors as v
RIGHT OUTER JOIN ContactUpdates as c
	ON v.VendorID = c.VendorID

-- 14 --
SELECT *
FROM Vendors
CROSS JOIN Invoices

-- 15 --
INSERT INTO InvoiceArchive
VALUES(1,122,'989319-457','2015-12-08 00:00:00',3813.33,3813.33,0.00,3,'2016-01-08 00:00:00','2016-01-07 00:00:00'),
(11,123,'963253262','2015-12-25 00:00:00',42.50,42.50,0.00,3,'2016-01-25 00:00:00','2016-01-20 00:00:00')

SELECT *
FROM InvoiceArchive

SELECT * 
FROM ContactUpdates

SELECT * 
FROM InvoiceArchive as i
FULL JOIN ContactUpdates as c on i.VendorID = c.VendorID