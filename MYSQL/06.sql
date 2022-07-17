CREATE TABLE test_decimal1(
f1 DECIMAL,
f2 DECIMAL(5,2)
);
DESC test_decimal1;
INSERT INTO test_decimal1(f1,f2)
VALUES(123.123,123.456);
#Out of range value for column 'f2' at row 1
INSERT INTO test_decimal1(f2)
VALUES(1234.34);

SELECT * FROM test_decimal1;

ALTER TABLE test_double2
MODIFY f1 DECIMAL(5,2);

SELECT * FROM test_double2;

SELECT SUM(f1)
FROM test_double2;

CREATE TABLE test_bit1(
f1 BIT,
f2 BIT(5),
f3 BIT(64)
);

INSERT INTO test_bit1(f1)
VALUES(1);
#Data too long for column 'f1' at row 1
INSERT INTO test_bit1(f1)
VALUES(2);
INSERT INTO test_bit1(f2)
VALUES(23);
SELECT * FROM test_bit1;

CREATE TABLE test_year(
f1 YEAR,
f2 YEAR(4)
);
INSERT INTO test_year
VALUES('2020','2021');
SELECT * FROM test_year;

CREATE TABLE test_date1(
f1 DATE
);
INSERT INTO test_date1
VALUES ('2020-10-01'), ('20201001'),(20201001);

INSERT INTO test_date1
VALUES ('00-01-01'), ('000101'), ('69-10-01'), ('691001'), ('70-01-01'), ('700101'),
('99-01-01'), ('990101');

INSERT INTO test_date1
VALUES (000301), (690301), (700301), (990301);

INSERT INTO test_date1
VALUES (CURRENT_DATE()), (NOW());

SELECT * FROM test_date1;

CREATE TABLE test_datetime1(
dt DATETIME
);
INSERT INTO test_datetime1
VALUES ('2021-01-01 06:50:30'), ('20210101065030');
INSERT INTO test_datetime1
VALUES ('99-01-01 00:00:00'), ('990101000000'), ('20-01-01 00:00:00'),
('200101000000');
INSERT INTO test_datetime1
VALUES (20200101000000), (200101000000), (19990101000000), (990101000000);
INSERT INTO test_datetime1

SELECT * FROM test_datetime1;

SELECT UNIX_TIMESTAMP();

CREATE TABLE test_char1(
c1 CHAR,
c2 CHAR(5)
);
DESC test_char1;

INSERT INTO test_char1
VALUES('a','Tom');
SELECT c1,CONCAT(c2,'***') FROM test_char1;

INSERT INTO test_char1(c2)
VALUES('a ');
SELECT CHAR_LENGTH(c2)
FROM test_char1;
SELECT * FROM test_char1;


CREATE TABLE test_varchar1(
NAME VARCHAR #错误
);

#Column length too big for column 'NAME' (max = 21845);
CREATE TABLE test_varchar2(
NAME VARCHAR(65535) #错误
);

CREATE TABLE test_text(
tx TEXT
);
INSERT INTO test_text
VALUES('abc ');
SELECT CHAR_LENGTH(tx)
FROM test_text; #4

CREATE TABLE test_enum(
season ENUM('春','夏','秋','冬','unknow')
);
INSERT INTO test_enum
VALUES('春'),('秋');
# 忽略大小写
INSERT INTO test_enum
VALUES('UNKNOW');
# 允许按照角标的方式获取指定索引位置的枚举值
INSERT INTO test_enum
VALUES('1'),(3);
# Data truncated for column 'season' at row 1
INSERT INTO test_enum
VALUES('ab');
# 当ENUM类型的字段没有声明为NOT NULL时，插入NULL也是有效的
INSERT INTO test_enum
VALUES(NULL);

SELECT * FROM test_enum;

CREATE TABLE test_set(
s SET ('A', 'B', 'C')
);
INSERT INTO test_set (s) VALUES ('A'), ('A,B');
#插入重复的SET类型成员时，MySQL会自动删除重复的成员
INSERT INTO test_set (s) VALUES ('A,B,C,A');
#向SET类型的字段插入SET成员中不存在的值时，MySQL会抛出错误。
INSERT INTO test_set (s) VALUES ('A,B,C,D');
SELECT *
FROM test_set;

CREATE TABLE temp_mul(
gender ENUM('男','女'),
hobby SET('吃饭','睡觉','打豆豆','写代码')
);
INSERT INTO temp_mul VALUES('男','睡觉,打豆豆'); #成功
# Data truncated for column 'gender' at row 1
INSERT INTO temp_mul VALUES('男,女','睡觉,写代码'); #失败
# Data truncated for column 'gender' at row 1
INSERT INTO temp_mul VALUES('妖','睡觉,写代码');#失败
INSERT INTO temp_mul VALUES('男','睡觉,写代码,吃饭'); #成功
SELECT * FROM temp_mul;

CREATE TABLE test_binary1(
f1 BINARY,
f2 BINARY(3),
# f3 VARBINARY,
f4 VARBINARY(10)
);
INSERT INTO test_binary1(f1,f2)
VALUES('a','a');
INSERT INTO test_binary1(f1,f2)
VALUES('尚','尚');#失败
INSERT INTO test_binary1(f2,f4)
VALUES('ab','ab');

SELECT LENGTH(f2),LENGTH(f4)
FROM test_binary1;

CREATE TABLE test_json(
js json
);
INSERT INTO test_json (js)
VALUES ('{"name":"songhk", "age":18, "address":{"province":"beijing",
"city":"beijing"}}');
SELECT *FROM test_json;

SELECT * FROM information_schema.table_constraints
WHERE table_name = 'dept';


CREATE VIEW empvu80
AS
SELECT employee_id, last_name, salary
FROM employees
WHERE department_id = 80;

SELECT * FROM empvu80;

CREATE VIEW empview
AS
SELECT employee_id emp_id,last_name NAME,department_name
FROM employees e,departments d
WHERE e.department_id = d.department_id;

SELECT * FROM empview;

DESC empview;
SHOW TABLE STATUS LIKE 'empview'

SHOW CREATE VIEW empview;