SELECT department_id, MIN(salary)
FROM employees
GROUP BY department_id
HAVING MIN(salary) >
(SELECT MIN(salary)
FROM employees
WHERE department_id = 50);

SELECT employee_id, last_name,
	(
	CASE department_id
	WHEN
		(SELECT department_id FROM departments
			WHERE location_id = 1800)
	THEN 'Canada' ELSE 'USA' END
	) AS location	
FROM employees;
-- 子查询为空
SELECT last_name, job_id
FROM employees
WHERE job_id =
(SELECT job_id
FROM employees
WHERE last_name = 'Haas');

SELECT employee_id, last_name
FROM employees
WHERE salary =
(SELECT MIN(salary)
FROM employees
GROUP BY department_id);

#题目：返回其它job_id中比job_id为‘IT_PROG’部门任一工资低的员工的员工号、姓名、
# job_id 以及salary
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ANY(
	SELECT salary 
	FROM employees
	WHERE job_id = 'IT_PROG'
)
AND job_id <> 'IT_PROG';

SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ALL(
	SELECT salary 
	FROM employees
	WHERE job_id = 'IT_PROG'
)
AND job_id <> 'IT_PROG';

CREATE DATABASE IF NOT EXISTS mysql123;

SHOW DATABASES;

SELECT DATABASE();

SHOW TABLES FROM mysql;

SHOW CREATE DATABASE mysql\G;

ALTER DATABASE mysql123 CHARACTER SET utf8;

DROP DATABASE IF EXISTS mysql123;

CREATE DATABASE IF NOT EXISTS learnmysql;
USE learnmysql;

CREATE TABLE IF NOT EXISTS users(
id INT,
NAME VARCHAR(20),
salary DOUBLE,
birthday DATE
);
DESC users;

CREATE TABLE dept(
-- int类型，自增
deptno INT(2) AUTO_INCREMENT,
dname VARCHAR(14),
loc VARCHAR(13),
-- 主键
PRIMARY KEY (deptno)
);
DESC dept;

SHOW CREATE TABLE dept\G;

ALTER TABLE dept ADD job_id VARCHAR(15);
DESC dept;

ALTER TABLE dept MODIFY dname VARCHAR(15);

ALTER TABLE dept ADD salary DOUBLE;

ALTER TABLE dept MODIFY salary DOUBLE(9,2) DEFAULT 1000;

ALTER TABLE dept CHANGE deptno dept_id INT;

ALTER TABLE dept DROP loc;

RENAME TABLE users TO users1;

DROP TABLE users1;

TRUNCATE TABLE student;

SET autocommit = FALSE;
DELETE FROM emp2;
#TRUNCATE TABLE emp2;
SELECT * FROM emp2;
ROLLBACK;
SELECT * FROM emp2;