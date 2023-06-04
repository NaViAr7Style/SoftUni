-- LAB PROBLEMS
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 1. Mountains and Peaks

CREATE TABLE mountains (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE peaks (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
mountain_id INT NOT NULL,
CONSTRAINT fk_peaks_mountains
FOREIGN KEY (mountain_id)
REFERENCES mountains(id)
);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 2. Trip Organization

SELECT
	v.driver_id,
	v.vehicle_type, 
    CONCAT(c.first_name, ' ', c.last_name) as 'driver_name'
FROM vehicles AS v
	JOIN campers AS c ON v.driver_id = c.id;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 3. SoftUni Hiking

SELECT
	r.starting_point as 'route_starting_point',
    r.end_point as 'route_ending_point',
    r.leader_id,
    CONCAT(c.first_name, ' ', c.last_name) as 'leader_name'
FROM routes AS r
	JOIN campers AS c ON r.leader_id = c.id;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 4. Delete Mountains

DROP TABLE peaks;
DROP TABLE mountains;

CREATE TABLE mountains (
id INT AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
CONSTRAINT pk_mountains_id PRIMARY KEY (id)
);

CREATE TABLE peaks (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
mountain_id INT NOT NULL,
CONSTRAINT fk_peaks_mountains
	FOREIGN KEY (mountain_id)
	REFERENCES mountains(id)
    ON DELETE CASCADE
);





