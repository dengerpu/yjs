# 单行注释（Mysql独有的）
-- 单行注释
/*
多行注释
*/
SELECT id AS 编号,NAME AS "姓名" FROM student;

SELECT 1;
SELECT 9/2;

SELECT id FROM student;
SELECT * FROM student;
SELECT id, NAME FROM student;

SELECT id AS 编号, NAME AS 姓名 FROM student;

SELECT last_name 名字, salary*12 年薪 FROM employees;

SELECT department_id FROM employees;

SELECT DISTINCT department_id id FROM employees;

SELECT employee_id,salary,commission_pct, 12 * salary * (1 + commission_pct) "annual_sal" FROM employees;

SELECT '程序员' AS corporation, last_name FROM employees;

SELECT employee_id, last_name, job_id, department_id FROM employees WHERE department_id = 90 ;

SELECT last_name, manager_id FROM employees WHERE manager_id IS NULL;

SELECT last_name, salary FROM employees WHERE salary BETWEEN 2500 AND 3500;

SELECT employee_id, last_name, salary, manager_id FROM employees WHERE manager_id IN (100, 101, 201);

SELECT first_name
FROM employees
WHERE first_name LIKE 'S%';

SELECT last_name
FROM employees
WHERE last_name LIKE '_o%';

SELECT job_id 
FROM jobs 
WHERE job_id LIKE 'IT\_%';

SELECT job_id 
FROM jobs 
WHERE job_id LIKE 'IT$_%' ESCAPE '$';

SELECT last_name, job_id FROM employees WHERE job_id NOT IN ('IT_PROG', 'ST_CLERK', 'SA_REP');

SELECT employee_id, last_name, job_id, salary FROM employees WHERE salary >=10000 AND job_id LIKE '%MAN%';

#查询基本薪资不在9000-12000之间的员工编号和基本薪资
SELECT employee_id, salary
FROM employees
WHERE salary NOT BETWEEN 9000 AND 12000; 

SELECT employee_id, salary
FROM employees
WHERE NOT (salary >= 9000 AND salary <= 12000);

SELECT employee_id,salary FROM employees WHERE NOT (salary >= 9000 AND salary <= 12000);

SELECT s_id 
FROM fruits
WHERE s_id REGEXP '[456]';