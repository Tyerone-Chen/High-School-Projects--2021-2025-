-- 1 --
ALTER Table Member
ADD Constraint JoinDate
Default GetDate() FOR JoinDate

-- 2 --
ALTER Table Title
ADD Constraint Rating
CHECK(Rating = 'G' OR Rating = 'PG' OR Rating = 'R' OR Rating = 'NC17' OR Rating = 'NR')

ALTER Table Title
ADD Constraint Category
CHECK(Category = 'Drama' OR Category = 'Comedy' OR Category = 'Action' OR Category = 'Child' OR Category = 'Scifi' Or Category = 'Documentary')

-- 3 --
ALTER Table TitleCopy
ADD Constraint FK_TitleID
Foreign Key (TitleID) References Title(TitleID)

ALTER Table TitleCopy 
ADD Constraint Status
CHECK(Status = 'Available' OR Status = 'Destroyed' OR Status = 'Rented' OR Status = 'Reserved')

-- 4 --
ALTER Table Rental
ADD Constraint BookDate
Default GetDate() For BookDate

ALTER Table Rental
ADD Constraint FK_MemberID
Foreign Key (MemberID) References Member(MemberID)

ALTER Table Rental
ADD Constraint FK_CopyID
Foreign Key (CopyID) References TitleCopy(CopyID)

ALTER Table Rental
ADD Constraint ExpRetDate
Default GetDate() + 2 For ExpRetDate

ALTER Table Rental
ADD Constraint FK__TitleID
Foreign Key (TitleID) References TitleCopy(TitleID)

-- 5 --
ALTER Table Reservation  
ADD Constraint FK__MemberID
Foreign Key (MemberID) References Member(MemberID)

ALTER Table Reservation  
ADD Constraint FK__TitleID
Foreign Key (TitleID) References Title(TitleID)

-- 6 --
INSERT Into Member
Values
(123, 'Jones', 'Tom', '1400 South 27 St', 'Milwaukee', '414-516-8244', '2/12/2018')

-- 7 --
INSERT Into Title
Values
(101, 'Harry Potter', 'A series of fantasy novels that chronicle the life of a young wizard, Harry Potter, and his friends Hermione Granger and Ron Weasley.',
 'G', 'Scifi', '11/14/2001')

 -- 8 --
INSERT Into Title
Values
(101, 'Gremlins', 'A strange creature which spawns other creatures who transform into small, destructive, evil monsters.', 
'NC12', 'Scifi', '6/8/1984')

-- 9 --
INSERT Into Rental
Values
('2/10/2018', 123, 555, '2/5/2018', '2/22/2018', 101)

-- 10 --
INSERT Into TitleCopy
Values
(555, 101, 'Available')

-- 11 --
DELETE FROM TitleCopy WHERE CopyId = 555