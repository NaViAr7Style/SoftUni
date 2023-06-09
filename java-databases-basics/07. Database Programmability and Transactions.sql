-- LAB PROBLEMS
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 1. Count Employees by Town

DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(50))
RETURNS INT
DETERMINISTIC
BEGIN
    RETURN (
		SELECT COUNT(*)
        FROM employees AS e
        JOIN addresses AS a ON a.address_id = e.address_id
        JOIN towns AS t ON t.town_id = a.town_id
        WHERE t.`name` = town_name
    );
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 2. Employees Promotion

DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
	DECLARE department_id_to_update INT;

    SET department_id_to_update = (
			SELECT department_id
            FROM departments
            WHERE `name` = department_name
	);
    
	UPDATE employees
    SET salary = salary * 1.05
    WHERE department_id = department_id_to_update;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 3. Employees Promotion By ID

DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN
	START TRANSACTION;
    IF(
		(SELECT COUNT(*)
		FROM employees
        WHERE employee_id = id) <> 1
	)
	THEN ROLLBACK;
    ELSE
		UPDATE employees
        SET salary = salary * 1.05
        WHERE employee_id = id;
    END IF;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 4. Triggered

CREATE TABLE deleted_employees (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    middle_name VARCHAR(20),
    job_title VARCHAR(50),
    department_id INT,
    salary DOUBLE
);

DELIMITER $$
CREATE TRIGGER tr_deleted_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO deleted_employees (
		first_name,
		last_name,
		middle_name,
		job_title,
		department_id,
		salary
	)
	VALUES(
		OLD.first_name,
        OLD.last_name,
        OLD.middle_name,
        OLD.job_title,
        OLD.department_id,
        OLD.salary
	);
END$$
DELIMITER ;
;



-- EXERCISE PROBLEMS
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 1. Employees with Salary Above 35000

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
	SELECT
		first_name,
		last_name
	FROM employees
	WHERE salary > 35000
	ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 2. Employees with Salary Above Number

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(threshold DECIMAL(19, 4))
BEGIN
	SELECT
		first_name,
		last_name
	FROM employees
	WHERE salary >= threshold
	ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 3. Town Names Starting With

DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(pattern VARCHAR(50))
BEGIN
    SELECT `name`
	FROM towns
	WHERE `name` LIKE CONCAT(pattern, '%')
	ORDER BY `name`;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 4. Employees from Town

DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT
		first_name,
		last_name
	FROM employees AS e
	JOIN addresses AS a ON a.address_id = e.address_id
	JOIN towns AS t ON t.town_id = a.town_id
	WHERE t.`name` = town_name
	ORDER BY first_name, last_name, employee_id;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 5. Salary Level Function

DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19, 4))
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
	DECLARE output VARCHAR(20);
    SET output = CASE
		WHEN salary < 30000 THEN "Low"
		WHEN salary BETWEEN 30000 AND 50000 THEN "Average"
		WHEN salary > 50000 THEN "High"
	END;
    RETURN output;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 6. Employees by Salary Level

DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(20))
BEGIN
	SELECT
		first_name,
		last_name
	FROM employees
	WHERE
		CASE
			WHEN salary_level = "Low" THEN salary < 30000
			WHEN salary_level = "Average" THEN salary BETWEEN 30000 AND 50000
			WHEN salary_level = "High" THEN salary > 50000
		END
	ORDER BY first_name DESC, last_name DESC;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 7. Define Function

DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
DETERMINISTIC
RETURN word REGEXP(CONCAT('^[', set_of_letters, ']+$'))$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 8. Find Full Name

DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT CONCAT(first_name, ' ', last_name) AS 'full_name'
	FROM account_holders
	ORDER BY full_name, id;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 9. People with Balance Higher Than

DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(threshold DECIMAL(19, 4))
BEGIN
	SELECT
		first_name,
		last_name
	FROM account_holders AS ah
	JOIN accounts AS a ON a.account_holder_id = ah.id
    GROUP BY ah.id
	HAVING SUM(a.balance) > threshold
	ORDER BY ah.id;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 10. Future Value Function

DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value (sum DECIMAL(19, 4), yearly_rate DECIMAL(19, 4), years INT)
RETURNS DECIMAL (19, 4)
DETERMINISTIC
RETURN sum * POW((1 + yearly_rate), years)$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 11. Calculating Interest

DELIMITER $$
CREATE PROCEDURE usp_calculate_future_value_for_account(id INT, rate DECIMAL(19, 4))
BEGIN
	SELECT
		ah.id AS 'account_id',
		ah.first_name,
		ah.last_name, 
		a.balance AS 'current_balance',
		(SELECT ufn_calculate_future_value(a.balance, rate, 5)) AS 'balance_in_5_years'
	FROM accounts AS a
    JOIN account_holders AS ah ON ah.id = a.account_holder_id
    WHERE a.id = id;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 12. Deposit Money

DELIMITER $$
CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
	START TRANSACTION;
    IF (money_amount <= 0) THEN ROLLBACK;
    ELSE
	UPDATE accounts AS a SET a.balance = a.balance + money_amount
    WHERE a.id = account_id;
    END IF;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 13. Withdraw Money

DELIMITER $$
CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))
BEGIN
    START TRANSACTION;
    IF (money_amount <= 0 OR (SELECT balance FROM accounts AS a WHERE a.id = account_id) < money_amount) THEN ROLLBACK;
    ELSE 
		UPDATE accounts AS ac SET ac.balance = ac.balance - money_amount
        WHERE ac.id = id;
        COMMIT;
    END IF;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 14. Money Transfer

DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_id INT, to_id INT, money_amount DECIMAL(19, 4)) 
BEGIN
	START TRANSACTION;
    IF (money_amount <= 0 OR (SELECT balance FROM accounts WHERE id = from_id) < money_amount
		OR from_id = to_id 
        OR (SELECT COUNT(id) FROM accounts WHERE id = from_id) <> 1
        OR (SELECT COUNT(id) FROM accounts WHERE id = to_id) <> 1)
        THEN ROLLBACK;
        ELSE
			UPDATE accounts SET balance = balance - money_amount
            WHERE id = from_id;
            UPDATE accounts SET balance = balance + money_amount
            WHERE id = to_id;
            COMMIT;
        END IF;
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 15. Log Accounts Trigger

CREATE TABLE `logs` (
	log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    old_sum DECIMAL(19, 4),
    new_sum DECIMAL (19, 4)
);

DELIMITER $$
CREATE TRIGGER tr_change_balance_account
AFTER UPDATE ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs (account_id, old_sum, new_sum)
    VALUE (OLD.id, OLD.balance, NEW.balance);
END$$
DELIMITER ;
;



-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- ----------------------------------------------------------------------------------------------------------------------------------
-- Problem 16. Emails Trigger

CREATE TABLE `logs` (
	log_id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT NOT NULL,
    old_sum DECIMAL(19, 4),
    new_sum DECIMAL (19, 4)
);

DELIMITER $$
CREATE TRIGGER tr_change_balance_account
AFTER UPDATE ON accounts
FOR EACH ROW
BEGIN
	INSERT INTO logs (account_id, old_sum, new_sum)
    VALUE (OLD.id, OLD.balance, NEW.balance);
END$$
DELIMITER ;
;

CREATE TABLE `notification_emails`(
    `id` INT PRIMARY KEY AUTO_INCREMENT, 
    `recipient` INT NOT NULL,
    `subject` VARCHAR(100) NOT NULL,
    `body` TEXT NOT NULL
);

DELIMITER $$
CREATE TRIGGER tr_notification_email_creation
AFTER INSERT
ON `logs`
FOR EACH ROW
BEGIN
	INSERT INTO notification_emails (recipient, subject, body)
    VALUES(
		NEW.account_id,
        CONCAT('Balance change for account: ', NEW.account_id),
        CONCAT_WS(' ', 'On', DATE_FORMAT(NOW(), '%b %d %y at %r'), ' your balance was changed from', NEW.old_sum, ' to ', NEW.new_sum, '.')
	);
END$$
DELIMITER ;
;
