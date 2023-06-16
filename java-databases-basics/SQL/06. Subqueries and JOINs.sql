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

 SELECT
	employee_id,
    job_title,
    employees.address_id,
    address_text
FROM employees
JOIN addresses ON addresses.address_id = employees.address_id
ORDER BY address_id
LIMIT 5;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 2. Addresses with Towns

SELECT
	first_name,
    last_name,
    t.`name` AS 'town',
    address_text
FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
JOIN towns AS t ON t.town_id = a.town_id
ORDER BY first_name, last_name
LIMIT 5;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 3. Sales Employee

SELECT
	employee_id,
    first_name,
    last_name,
    d.`name` AS department_name
FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id
WHERE d.`name` = 'Sales'
ORDER BY employee_id DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 4. Employee Departments

SELECT
	employee_id,
    first_name,
    salary,
    d.`name` AS 'department_name'
FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id
WHERE salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 5. Employees Without Project

SELECT
	e.employee_id,
    first_name
FROM employees AS e
LEFT JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
WHERE ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 6. Employees Hired After

SELECT
	first_name,
    last_name,
    hire_date,
    d.`name` AS 'department_name'
FROM employees AS e
JOIN departments AS d ON d.department_id = e.department_id
WHERE hire_date > '1999-01-01' AND d.`name` IN ('Sales', 'Finance')
ORDER BY hire_date;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 7. Employees with Project

SELECT
	e.employee_id,
    e.first_name,
    p.`name` AS 'project_name'
FROM employees AS e
JOIN employees_projects AS ep ON ep.employee_id = e.employee_id
JOIN projects AS p ON p.project_id = ep.project_id
WHERE DATE(p.start_date) > '2002-08-13' AND p.end_date IS NULL
ORDER BY e.first_name, p.`name`
LIMIT 5;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 8. Employee 24

SELECT
	e.employee_id,
    first_name,
    IF(p.start_date >= '2005-01-01', NULL, p.`name`) AS 'project_name'
FROM employees AS e
JOIN employees_projects AS ep ON ep.employee_id = e.employee_id
JOIN projects AS p ON p.project_id = ep.project_id
WHERE e.employee_id = 24
ORDER BY p.`name`;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 9. Employee Manager

SELECT
	e.employee_id,
    e.first_name,
    e.manager_id,
    ee.first_name
FROM employees AS e
JOIN employees AS ee ON ee.employee_id = e.manager_id
WHERE e.manager_id IN (3, 7)
ORDER BY e.first_name;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 10. Employee Summary

SELECT
	e.employee_id,
    CONCAT(e.first_name, ' ', e.last_name) AS 'employee_name',
    CONCAT(ee.first_name, ' ', ee.last_name) AS 'manager_name',
    d.`name` AS 'department_name'
FROM employees AS e
JOIN employees AS ee ON ee.employee_id = e.manager_id
JOIN departments AS d ON d.department_id = e.department_id
ORDER BY e.employee_id
LIMIT 5;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 11. Min Average Salary

SELECT AVG(salary) AS 'min_average_salary'
FROM employees
GROUP BY department_id
ORDER BY min_average_salary
LIMIT 1;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 12. Highest Peaks in Bulgaria

SELECT
	c.country_code,
    m.mountain_range,
    p.peak_name,
    p.elevation
FROM peaks AS p
JOIN mountains AS m ON m.id = p.mountain_id
JOIN mountains_countries AS mc ON mc.mountain_id = m.id
JOIN countries AS c ON c.country_code = mc.country_code
WHERE c.country_code = 'BG' AND p.elevation > 2835
ORDER BY p.elevation DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 13. Count Mountain Ranges

SELECT
	c.country_code,
    COUNT(*) AS 'mountain_range'
FROM countries AS c
JOIN mountains_countries AS mc ON mc.country_code = c.country_code
WHERE c.country_code IN ('BG', 'RU', 'US')
GROUP BY c.country_code
ORDER BY `mountain_range` DESC;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 14. Countries with Rivers

SELECT
	c.country_name,
    r.river_name
FROM countries AS c
LEFT JOIN countries_rivers AS cr ON cr.country_code = c.country_code
LEFT JOIN rivers AS r ON r.id = cr.river_id
WHERE c.continent_code = 'AF'
ORDER BY c.country_name
LIMIT 5;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 15. Continents and Currencies

SELECT
	continent_code,
    currency_code,
    COUNT(currency_code) AS 'currency_usage'
FROM countries AS c
GROUP BY continent_code, currency_code
HAVING currency_usage > 1
	AND currency_usage = (
		SELECT COUNT(*) AS 'count_of_currencies'
        FROM countries AS c2
        WHERE c2.continent_code = c.continent_code
        GROUP BY c2.currency_code
        ORDER BY count_of_currencies DESC
        LIMIT 1
    )
ORDER BY continent_code, currency_code;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 16. Countries without any Mountains

SELECT COUNT(*) AS country_count
FROM countries AS c
LEFT JOIN mountains_countries AS mc ON mc.country_code = c.country_code
WHERE mc.mountain_id IS NULL;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 17. Highest Peak and Longest River by Country

SELECT
	c.country_name,
    MAX(p.elevation) AS 'highest_peak_elevation',
    MAX(r.length) AS 'longest_river_length'
FROM countries AS c
JOIN mountains_countries AS mc ON mc.country_code = c.country_code
JOIN mountains AS m ON m.id = mc.mountain_id
JOIN peaks AS p ON p.mountain_id = m.id
JOIN countries_rivers AS cr ON cr.country_code = c.country_code
JOIN rivers AS r ON r.id = cr.river_id
GROUP BY c.country_name
ORDER BY highest_peak_elevation DESC, longest_river_length DESC, country_name
LIMIT 5;
