CREATE DATABASE universities_db;
USE universities_db;

-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 1. Table Design

CREATE TABLE countries(
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE cities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    population INT,
    country_id INT NOT NULL,
    CONSTRAINT fk_cities_countries
		FOREIGN KEY (country_id)
        REFERENCES countries(id)
);

CREATE TABLE universities(
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL UNIQUE,
    address VARCHAR(80) NOT NULL UNIQUE,
    tuition_fee DECIMAL(19, 2) NOT NULL,
    number_of_staff INT,
    city_id INT,
    CONSTRAINT fk_universities_cities
		FOREIGN KEY (city_id)
        REFERENCES cities(id)
);

CREATE TABLE students(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    age INT,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    is_graduated TINYINT(1) NOT NULL,
    city_id INT,
    CONSTRAINT fk_students_cities
		FOREIGN KEY (city_id)
        REFERENCES cities(id)
);

CREATE TABLE courses(
	id INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    duration_hours DECIMAL(19, 2),
    start_date DATE,
    teacher_name VARCHAR(60) NOT NULL UNIQUE,
    `description` TEXT,
    university_id INT,
    CONSTRAINT fk_courses_universities
		FOREIGN KEY (university_id)
        REFERENCES universities(id)
);

CREATE TABLE students_courses(
	grade DECIMAL(19, 2) NOT NULL,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT fk_students_courses__students
		FOREIGN KEY (student_id)
        REFERENCES students(id),
	CONSTRAINT fk_students_courses__courses
		FOREIGN KEY (course_id)
        REFERENCES courses(id)
);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 2. Insert

INSERT INTO courses(`name`, duration_hours, start_date, teacher_name, `description`, university_id)
(
	SELECT
		CONCAT(teacher_name, ' course'),
		CHAR_LENGTH(`name`) / 10,
		ADDDATE(start_date, INTERVAL 5 DAY),
		REVERSE(teacher_name),
		CONCAT('Course ', teacher_name, REVERSE(`description`)),
		DAY(start_date)
	FROM courses
	WHERE id <= 5
);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 3. Update

UPDATE universities
SET tuition_fee = tuition_fee + 300
WHERE id BETWEEN 5 AND 12;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 4. Delete

DELETE FROM universities
WHERE number_of_staff IS NULL;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 5. Cities

SELECT *
FROM cities
ORDER BY population DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 6. Students Age

SELECT
	first_name,
    last_name,
    age,
    phone,
    email
FROM students
WHERE age >= 21
ORDER BY first_name DESC, email, id
LIMIT 10;

-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 7. New Students

SELECT
	CONCAT(first_name, ' ', last_name) AS full_name,
    SUBSTR(email, 2, 10) AS username,
    REVERSE(phone) AS 'password'
FROM students AS s
LEFT JOIN students_courses AS sc ON sc.student_id = s.id
WHERE sc.course_id IS NULL
ORDER BY `password` DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 8. Students Count

SELECT
	COUNT(*) AS s_count,
    u.`name`
FROM universities AS u
JOIN courses AS c ON c.university_id = u.id
JOIN students_courses AS sc ON sc.course_id = c.id
GROUP BY u.`name`
HAVING s_count >= 8
ORDER BY s_count DESC, u.`name` DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 9. Price Rankings

SELECT
	u.`name` AS university_name,
    c.`name` AS city_name,
    u.address,
    CASE
		WHEN u.tuition_fee < 800 THEN 'cheap'
        WHEN 800 <= u.tuition_fee AND u.tuition_fee < 1200 THEN 'normal'
        WHEN 1200 <= u.tuition_fee AND u.tuition_fee < 2500 THEN 'high'
        ELSE 'expensive'
	END AS price_rank,
    u.tuition_fee
FROM universities AS u
JOIN cities AS c ON c.id = u.city_id
ORDER BY tuition_fee;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 10. Average Grades

DELIMITER $$
CREATE FUNCTION udf_average_alumni_grade_by_course_name(course_name VARCHAR(60))
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
	DECLARE avg_grade DECIMAL(19, 2);
    
    SET avg_grade = (
		SELECT AVG(sc.grade)
		FROM students_courses AS sc
		JOIN students AS s ON s.id = sc.student_id
		JOIN courses AS c ON c.id = sc.course_id
		WHERE c.`name` = course_name AND s.is_graduated = 1
	);
    
    RETURN avg_grade;
END$$
DELIMITER ;
;

-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 11. Graduate Students

DELIMITER $$
CREATE PROCEDURE udp_graduate_all_students_by_year(year_started INT)
BEGIN
	UPDATE students AS s
	JOIN students_courses AS sc ON sc.student_id = s.id
	JOIN courses AS c ON c.id = sc.course_id
	SET s.is_graduated = 1
	WHERE YEAR(c.start_date) = year_started;
END$$
DELIMITER ;
;
