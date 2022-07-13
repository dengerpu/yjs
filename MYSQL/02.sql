# 单列排序
SELECT last_name, job_id, department_id, hire_date
FROM employees
ORDER BY hire_date DESC;

# 多列排序
SELECT last_name, department_id, salary
FROM employees
ORDER BY salary, department_id DESC;

SELECT employees.employee_id, employees.last_name, employees.department_id, departments.department_id, departments.location_id 
FROM employees, departments 
WHERE employees.department_id = departments.department_id;

SELECT e.last_name, d.department_name,e.department_id 
FROM employees e, departments d 
WHERE e.department_id = d.department_id;

# 查询出公司员工的 last_name,department_name, city
SELECT e.last_name, d.department_name,l.city
FROM employees e, departments d, locations l
WHERE e.`department_id` = d.`department_id` AND d.`location_id` = l.`location_id`;

SELECT e.last_name, e.salary, j.grade_level 
FROM employees e, job_grades j 
WHERE e.salary BETWEEN j.lowest_sal AND j.highest_sal;

# 练习：查询员工id,员工姓名及其管理者的id和姓名
SELECT emp.employee_id, emp.last_name, mgr.employee_id managerId, mgr.last_name managerName
FROM employees emp, employees mgr
WHERE emp.`manager_id` = mgr.`employee_id`;

# 练习：查询出last_name为 ‘Chen’ 的员工的 manager 的信息。
SELECT emp.employee_id, emp.last_name, mgr.employee_id managerId, mgr.last_name managerName
FROM employees emp, employees mgr
WHERE emp.`last_name` = "Chen";

SELECT e.employee_id, e.last_name, e.department_id, d.department_id, d.location_id 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id);

SELECT e.last_name, e.department_id,d.department_name
FROM employees e
LEFT OUTER JOIN departments d
ON (e.`department_id` = d.`department_id`);

SELECT e.last_name, e.department_id,d.department_name
FROM employees e
RIGHT OUTER JOIN departments d
ON (e.`department_id` = d.`department_id`);


SELECT e.last_name, e.department_id,d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON (e.`department_id` = d.`department_id`);

# 举例：查询部门编号>90或邮箱包含a的员工信息
SELECT * 
FROM employees e
WHERE e.`department_id` > 90 OR e.`email` LIKE '%a%';

-- 方式二
SELECT * FROM employees e WHERE e.`department_id` > 90
UNION
SELECT * FROM employees e WHERE e.`email` LIKE '%a%';

# 内连接
SELECT e.`last_name`,e.`employee_id`,d.`department_name`
FROM employees e
INNER JOIN departments d
ON e.`department_id` = d.`department_id`;

SELECT e.`employee_id`, e.`last_name`, d.`department_id`
FROM employees e
NATURAL JOIN departments d;

SELECT e.`employee_id`, e.`last_name`, d.`department_id`
FROM employees e JOIN departments d
USING (department_id)

SELECT employee_id,last_name,department_name FROM employees e ,departments d WHERE e.department_id = d.department_id;

SELECT AVG(salary), MAX(salary), MIN(salary),SUM(salary)
FROM employees
WHERE job_id LIKE '%REP%';

SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id ;

SELECT AVG(salary)
FROM employees
GROUP BY department_id ;

SELECT department_id dept_id, job_id, SUM(salary)
FROM employees
GROUP BY department_id, job_id ;

SELECT department_id, AVG(salary)
FROM employees
WHERE department_id > 80
GROUP BY department_id ;
