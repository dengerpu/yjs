# net stop mysql 停止服务器
# net start mysql 开启服务器

# 1.查询员工12个月的工资总和，并起别名为ANNUAL SALARY 
SELECT salary AS "ANNUAL SALARY"
FROM employees;

# 2.查询employees表中去除重复的job_id以后的数据 
SELECT DISTINCT job_id
FROM employees;

# 3.查询工资大于12000的员工姓名和工资 
SELECT first_name,last_name,salary
FROM employees
WHERE salary > 12000;
# 4.查询员工号为176的员工的姓名和部门号 
SELECT first_name,last_name,department_id
FROM employees
WHERE employee_id = 176;
# 5.显示表 departments 的结构，并查询其中的全部数据
DESC departments;
SELECT * FROM departments;


# 1.选择工资不在5000到12000的员工的姓名和工资 
SELECT last_name,salary
FROM employees
WHERE salary NOT BETWEEN 5000 AND 12000;

SELECT last_name,salary
FROM employees
WHERE NOT (salary >= 5000 AND salary <= 12000);

SELECT last_name,salary
FROM employees
WHERE salary < 5000 OR salary > 12000;
# 2.选择在20或50号部门工作的员工姓名和部门号 
SELECT last_name,department_id
FROM employees
WHERE department_id IN (20,50);

SELECT last_name,department_id
FROM employees
WHERE department_id = 20 OR department_id = 50;

# 3.选择公司中没有管理者的员工姓名及job_id 
SELECT last_name, job_id
FROM employees
WHERE manager_id IS NULL;

# 4.选择公司中有奖金的员工姓名，工资和奖金级别 
SELECT last_name, salary,commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;


# 5.选择员工姓名的第三个字母是a的员工姓名 
SELECT last_name
FROM employees
WHERE  last_name LIKE '__a%';

# 6.选择姓名中有字母a和k的员工姓名 
SELECT last_name
FROM employees
WHERE  last_name LIKE '%a%k%' OR last_name LIKE '%k%a%';

# 7.显示出表 employees 表中 first_name 以 'e'结尾的员工信息 
SELECT first_name
FROM employees
WHERE  first_name LIKE '%e';

SELECT first_name
FROM employees
WHERE  first_name REGEXP 'e$';

# 8.显示出表 employees 部门编号在 80-100 之间的姓名、工种 
SELECT last_name, job_id
FROM employees
WHERE department_id BETWEEN 80 AND 100;

# 9.显示出表 employees 的 manager_id 是 100,101,110 的员工姓名、工资、管理者id
SELECT last_name, salary, manager_id
FROM employees
WHERE manager_id IN (100,101,110);

-- 5. 排序和分页
#1. 查询员工的姓名和部门号和年薪，按年薪降序,按姓名升序显示
SELECT last_name, department_id, salary*12 annual_salary
FROM employees
ORDER BY annual_salary DESC, last_name ASC;
#2. 选择工资不在 8000 到 17000 的员工的姓名和工资，按工资降序，显示第21到40位置的数据
SELECT last_name,salary
FROM employees
WHERE salary NOT BETWEEN 8000 AND 17000
ORDER BY salary DESC
LIMIT 20,20
#3. 查询邮箱中包含 e 的员工信息，并先按邮箱的字节数降序，再按部门号升序
SELECT *
FROM employees
-- where email like '%e%'
WHERE email REGEXP '[e]'
ORDER BY LENGTH(email) DESC, department_id ASC;

-- 6. 多表查询
# 1.显示所有员工的姓名，部门号和部门名称。
SELECT e.`last_name`,e.`department_id`,d.`department_name`
FROM employees e,departments d
WHERE e.`department_id` = d.`department_id`;

SELECT e.`last_name`,e.`department_id`,d.`department_name`
FROM employees e LEFT JOIN departments d
ON e.`department_id` = d.`department_id`

# 2.查询90号部门员工的job_id和90号部门的location_id
SELECT job_id, location_id
FROM employees e, departments d
WHERE e.`department_id` = d.`department_id`
AND e.`department_id` = 90;
# 3.选择所有有奖金的员工的 last_name , department_name , location_id , city
SELECT e.last_name,d.department_name, d.location_id, l.city
FROM employees e 
JOIN departments d
ON e.`department_id` = d.`department_id`
JOIN locations l
ON d.`location_id` = l.`location_id`
WHERE e.`commission_pct` IS NOT NULL;
# 4.选择city在Toronto工作的员工的 last_name , job_id , department_id , department_name
SELECT last_name, job_id, e.department_id, department_name
FROM employees e JOIN departments d
ON e.`department_id` = d.`department_id`
JOIN locations l
ON d.`location_id` = l.`location_id`
WHERE l.`city` = 'Toronto';
# 5.查询员工所在的部门名称、部门地址、姓名、工作、工资，其中员工所在部门的部门名称为’Executive’
SELECT department_name, street_address, last_name, job_id, salary
FROM employees e JOIN departments d
ON e.department_id = d.department_id
JOIN locations l
ON d.`location_id` = l.`location_id`
WHERE department_name = 'Executive'

# 6.选择指定员工的姓名，员工号，以及他的管理者的姓名和员工号，结果类似于下面的格式
/* employees Emp# manager Mgr#
kochhar 101 king 100
*/
SELECT e.last_name 'employees', e.`employee_id` 'Emp#', m.last_name 'manager', m.`employee_id` 'Mgr#'
FROM employees e 
LEFT JOIN employees m
ON e.`manager_id` = m.employee_id;
# 7.查询哪些部门没有员工
#方式1：
SELECT d.department_id
FROM departments d LEFT JOIN employees e
ON e.department_id = d.`department_id`
WHERE e.department_id IS NULL

#方式2：
SELECT department_id
FROM departments d
WHERE NOT EXISTS (
SELECT *
FROM employees e
WHERE e.`department_id` = d.`department_id`
)
# 8. 查询哪个城市没有部门
SELECT l.location_id,l.city
FROM locations l LEFT JOIN departments d
ON l.`location_id` = d.`location_id`
WHERE d.`location_id` IS NULL
# 9. 查询部门名为 Sales 或 IT 的员工信息
SELECT employee_id,last_name,department_name
FROM employees e,departments d
WHERE e.department_id = d.`department_id`
AND d.`department_name` IN ('Sales','IT');

-- 第7章_单行函数
# 1.显示系统时间(注：日期+时间)
SELECT NOW();
# 2.查询员工号，姓名，工资，以及工资提高百分之20%后的结果（new salary）
SELECT employee_id, last_name, salary, salary*1.2 'new salary'
FROM employees;
# 3.将员工的姓名按首字母排序，并写出姓名的长度（length）
SELECT last_name, LENGTH(last_name)
FROM employees
ORDER BY last_name;
# 4.查询员工id,last_name,salary，并作为一个列输出，别名为OUT_PUT
SELECT CONCAT(employee_id,',', last_name,',', salary) OUT_PUT
FROM employees;
# 5.查询公司各员工工作的年数、工作的天数，并按工作年数的降序排序
SELECT DATEDIFF(SYSDATE(), hire_date)/365 work_years, DATEDIFF(SYSDATE(), hire_date) work_days
FROM employees
ORDER BY work_years DESC;
# 6.查询员工姓名，hire_date , department_id，满足以下条件：
# 雇用时间在1997年之后，department_id
# 为80 或 90 或110, commission_pct不为空
SELECT last_name, hire_date, department_id
FROM employees
#WHERE hire_date >= '1997-01-01'
#WHERE hire_date >= STR_TO_DATE('1997-01-01', '%Y-%m-%d')
WHERE DATE_FORMAT(hire_date,'%Y') >= '1997'
AND department_id IN (80, 90, 110)
AND commission_pct IS NOT NULL;
# 7.查询公司中入职超过10000天的员工姓名、入职时间
SELECT last_name,hire_date
FROM employees
#WHERE TO_DAYS(NOW()) - to_days(hire_date) > 10000;
WHERE DATEDIFF(NOW(),hire_date) > 10000;

SELECT CONCAT(last_name, ' earns ', TRUNCATE(salary, 0) , ' monthly but wants ',
TRUNCATE(salary * 3, 0)) "Dream Salary"
FROM employees;

# 9
-- job grade
-- AD_PRES A
-- ST_MAN B
-- IT_PROG C
-- SA_REP D
-- ST_CLERK E
-- 产生下面的结果
-- Last_name Job_id Grade
-- king AD_PRES A
SELECT last_name Last_name, job_id Job_id,
	CASE job_id 
		WHEN 'AD_PRES' THEN 'A'
		WHEN 'ST_MAN' THEN 'B'
		WHEN 'IT_PROG' THEN 'C'
		WHEN 'SA_REP' THEN 'D'
		WHEN 'ST_CLERK' THEN 'E'
		ELSE 'F'
		END "grade"
FROM employees;

#1.where子句可否使用组函数进行过滤?
-- 不可以
#2.查询公司员工工资的最大值，最小值，平均值，总和
SELECT MAX(salary),MIN(salary),AVG(salary),SUM(salary)
FROM employees;
#3.查询各job_id的员工工资的最大值，最小值，平均值，总和
SELECT job_id,MAX(salary),MIN(salary),AVG(salary),SUM(salary)
FROM employees
GROUP BY job_id;
#4.选择具有各个job_id的员工人数
SELECT job_id,COUNT(*)
FROM employees
GROUP BY job_id;
# 5.查询员工最高工资和最低工资的差距（DIFFERENCE）
SELECT (MAX(salary) - MIN(salary)) difference
FROM employees;
# 6.查询各个管理者手下员工的最低工资，其中最低工资不能低于6000，没有管理者的员工不计算在内
SELECT manager_id, MIN(salary)
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING MIN(salary) > 6000;
# 7.查询所有部门的名字，location_id，员工数量和平均工资，并按平均工资降序
SELECT department_name, location_id, COUNT(employee_id), AVG(salary) avg_sal
FROM employees e RIGHT JOIN departments d
ON e.`department_id` = d.`department_id`
GROUP BY department_name, location_id
ORDER BY avg_sal DESC;
# 8.查询每个工种、每个部门的部门名、工种名和最低工资
SELECT department_name,job_id,MIN(salary)
FROM departments d LEFT JOIN employees e
ON e.`department_id` = d.`department_id`
GROUP BY department_name,job_id;