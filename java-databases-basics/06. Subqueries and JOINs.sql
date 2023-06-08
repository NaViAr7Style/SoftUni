-- LAB PROBLEMS
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 1. Managers

SELECT
	employee_id,
    CONCAT(first_name, ' ', last_name) AS 'full_name',
	d.department_id,
    d.`name` AS 'department_name'
FROM departments AS d
LEFT JOIN employees AS e ON d.manager_id = e.employee_id
ORDER BY employee_id
LIMIT 5;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 2. Towns and Addresses

SELECT
	t.town_id,
    t.`name` AS 'town_name',
    a.address_text
FROM towns AS t
JOIN addresses AS a ON t.town_id = a.town_id
WHERE t.`name` IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY town_id, address_id;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 3. Employees Without Managers

SELECT
	employee_id,
    first_name,
    last_name,
    department_id,
    salary
FROM employees
WHERE manager_id IS NULL;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 4. Higher Salary

SELECT COUNT(*)
FROM employees
WHERE salary > (
		SELECT AVG(salary)
        FROM employees
);



-- EXERCISE PROBLEMS
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 1. Employee Address

 






















