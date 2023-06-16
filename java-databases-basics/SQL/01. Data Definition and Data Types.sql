-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 1. Create Tables

CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT
);
CREATE TABLE towns (
    town_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 2. Alter Minions Table

ALTER TABLE minions
ADD COLUMN town_id INT;

ALTER TABLE minions
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY minions(town_id)
REFERENCES towns(id);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 3. Insert Records in Both Tables

INSERT INTO towns (id, name)
VALUES
(1, 'Sofia'),
(2, 'Plovdiv'),
(3, 'Varna');

INSERT INTO minions (id, name, age, town_id)
VALUES
(1, 'Kevin', 22, 1),
(2, 'Bob', 15, 3),
(3, 'Steward', NULL, 2);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 4. Truncate Table Minions

TRUNCATE TABLE minions;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 5. Drop All Tables

DROP TABLE `minions`;
DROP TABLE `towns`;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 6. Create Table People

CREATE TABLE people (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(10 , 2 ),
    weight DOUBLE(10 , 2 ),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people (name, gender, birthdate)
VALUES
('Test', 'm', DATE(NOW())),
('Test1', 'f', DATE(NOW())),
('Test2', 'm', DATE(NOW())),
('Test3', 'f', DATE(NOW())),
('Test4', 'm', DATE(NOW()));



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 7. Create Table Users

CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time TIMESTAMP,
    is_deleted BOOLEAN
);

INSERT INTO users (username, password)
VALUES
('Test', '12345'),
('Test1', '12345'),
('Test2', '12345'),
('Test3', '12345'),
('Test4', '12345');



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 8. Change Primary Key

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users2
PRIMARY KEY users(id, username);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 9. Set Default Value of a Field

ALTER TABLE users
CHANGE COLUMN last_login_time
last_login_time TIMESTAMP DEFAULT NOW();



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 10. Set Unique Field

ALTER TABLE users
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users
PRIMARY KEY users(id),
CHANGE COLUMN username
username VARCHAR(30) UNIQUE NOT NULL;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 11. Movies Database

CREATE DATABASE movies;
USE movies;

CREATE TABLE directors (
id INT PRIMARY KEY AUTO_INCREMENT,
director_name VARCHAR(50) NOT NULL,
notes TEXT
);

INSERT INTO directors (director_name)
VALUES
('Test'),
('Test'),
('Test'),
('Test'),
('Test');

CREATE TABLE genres (
id INT PRIMARY KEY AUTO_INCREMENT,
genre_name VARCHAR(20) NOT NULL,
notes TEXT
);

INSERT INTO genres (genre_name)
VALUES
('Test'),
('Test'),
('Test'),
('Test'),
('Test');

CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(20) NOT NULL,
notes TEXT
);

INSERT INTO categories (category_name)
VALUES
('Test'),
('Test'),
('Test'),
('Test'),
('Test');

CREATE TABLE movies (
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
director_id INT,
copyright_year YEAR,
length DOUBLE (10, 2),
genre_id INT,
category_id INT,
rating DOUBLE(3, 2),
notes TEXT,
FOREIGN KEY fk_movies_directors (director_id)
REFERENCES directors(id),
FOREIGN KEY fk_movies_genres (genre_id)
REFERENCES genres(id),
FOREIGN KEY fk_movies_categories (category_id)
REFERENCES categories(id)
);

INSERT INTO movies (title, director_id, genre_id, category_id)
VALUES
('Test', 1, 2, 1),
('Test', 1, 2, 2),
('Test', 1, 2, 3),
('Test', 1, 2, 4),
('Test', 1, 2, 5);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 12. Movies Database

CREATE DATABASE car_rental;
USE car_rental;


CREATE TABLE categories (
id INT PRIMARY KEY AUTO_INCREMENT,
category VARCHAR(20),
daily_rate DOUBLE,
weekly_rate DOUBLE,
monthly_rate DOUBLE,
weekend_rate DOUBLE
);

INSERT INTO categories (category)
VALUES
('Test'),
('Test'),
('Test');

CREATE TABLE cars (
id INT PRIMARY KEY AUTO_INCREMENT,
plate_number VARCHAR(10) NOT NULL,
make VARCHAR(30),
model VARCHAR(30),
car_year INT,
category_id INT NOT NULL,
doors INT,
picture BLOB,
car_condition VARCHAR(50),
available BOOLEAN,
FOREIGN KEY fk_cars_categories (category_id)
REFERENCES categories(id)
);

INSERT INTO cars (plate_number, category_id)
VALUES
('Test', 1),
('Test', 2),
('Test', 3);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
title VARCHAR(50),
notes TEXT
);

INSERT INTO employees (first_name)
VALUES
('Test'),
('Test'),
('Test');

CREATE TABLE customers (
id INT PRIMARY KEY AUTO_INCREMENT,
driver_licence_number VARCHAR(50),
full_name VARCHAR(50),
address VARCHAR(50),
city VARCHAR(50),
zip_code VARCHAR(50),
notes TEXT
);

INSERT INTO customers (driver_licence_number)
VALUES
('Test'),
('Test'),
('Test');

CREATE TABLE rental_orders (
id INT PRIMARY KEY AUTO_INCREMENT,
employee_id INT NOT NULL,
customer_id INT NOT NULL,
car_id INT NOT NULL,
car_condition VARCHAR(50),
tank_level VARCHAR(20),
kilometrage_start INT,
kilometrage_end INT,
total_kilometrage INT,
start_date DATE,
end_date DATE,
total_days INT,
rate_applied DOUBLE,
tax_rate DOUBLE,
order_status VARCHAR(20),
notes TEXT,
FOREIGN KEY fk_orders_employees (employee_id)
REFERENCES employees(id),
FOREIGN KEY fk_orders_customers (customer_id)
REFERENCES customers(id),
FOREIGN KEY fk_orders_cars (car_id)
REFERENCES cars(id)
);

INSERT INTO rental_orders (employee_id, customer_id, car_id)
VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 13. Basic Insert

CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
address_text VARCHAR(50),
town_id INT,
FOREIGN KEY fk_addresses_towns (town_id)
REFERENCES towns(id)
);

CREATE TABLE departments (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);

CREATE TABLE employees (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50),
middle_name VARCHAR(50),
last_name VARCHAR(50),
job_title VARCHAR(50),
department_id INT,
hire_date DATE,
salary DOUBLE,
address_id INT,
FOREIGN KEY fk_employees_addresses (address_id)
REFERENCES addresses(id),
FOREIGN KEY fk_employees_departments (department_id)
REFERENCES departments(id)
);

INSERT INTO towns (name)
VALUES
('Sofia'),
('Plovdiv'),
('Varna'),
('Burgas');

INSERT INTO departments (name)
VALUES
('Engineering'),
('Sales'),
('Marketing'),
('Software Development'),
('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES
('Ivan', 'Ivanov' , 'Ivanov', '.NET Developer', 4, '2013-02-01', 3500.00),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, '2004-03-02', 4000.00),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, '2016-08-28', 525.25),
('Georgi', 'Terziev', 'Ivanov', 'CEO', 2, '2007-12-09', 3000.00),
('Peter', 'Pan', 'Pan', 'Intern', 3, '2016-08-28', 599.88);



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 14. Basic Select All Fields

SELECT * FROM towns;

SELECT * FROM departments;

SELECT * FROM employees;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 15. Basic Select All Fields and Order Them

SELECT * FROM towns AS t
ORDER BY t.name;

SELECT * FROM departments AS d
ORDER BY d.name;

SELECT * FROM employees AS e
ORDER BY e.salary DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 16. Basic Select Some Fields

SELECT name FROM towns
ORDER BY name;

SELECT name FROM departments
ORDER BY name;

SELECT first_name, last_name, job_title, salary FROM employees 
ORDER BY salary DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 17. Increase Employees Salary

UPDATE employees
SET salary = salary * 1.1
WHERE salary IS NOT NULL;

SELECT salary from employees;






