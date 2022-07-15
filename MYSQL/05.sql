CREATE TABLE test_double1(
f1 FLOAT,
f2 FLOAT(5,2),
f3 DOUBLE,
f4 DOUBLE(5,2)
);
DESC test_double1;

INSERT INTO test_double1
VALUES(123.456,123.456,123.4567,123.45);
#Out of range value for column 'f2' at row 1
INSERT INTO test_double1
VALUES(123.456,1234.456,123.4567,123.45);

SELECT * FROM test_double1;

CREATE TABLE test_double2(
f1 DOUBLE
);
INSERT INTO test_double2
VALUES(0.47),(0.44),(0.19);

SELECT SUM(f1)
FROM test_double2;