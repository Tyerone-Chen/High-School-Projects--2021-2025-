-- Use Movies --

SELECT * FROM Films;
SELECT * FROM Actors;

SELECT * FROM Films
WHERE FilmsID = 1;

SELECT * FROM Actors
WHERE FilmsID = 1;

SELECT FilmName, YearMade, FirstName, LastName 
FROM dbo.Films
INNER JOIN dbo.Actors
ON dbo.Films.FilmsID = dbo.Actors.FilmsID

-- Use MoviesDB -- 
SELECT m.movie_title, m.year_released, a.actor_first_name, a.actor_last_name
FROM Movie AS m
INNER JOIN Casting AS c
	ON m.movie_id = c.movie_id
INNER JOIN Actor as a
	on a.actor_id = c.actor_id