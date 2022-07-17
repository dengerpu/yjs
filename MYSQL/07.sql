CREATE TABLE test_trigger (
id INT PRIMARY KEY AUTO_INCREMENT,
t_note VARCHAR(30)
);
CREATE TABLE test_trigger_log (
id INT PRIMARY KEY AUTO_INCREMENT,
t_log VARCHAR(30)
);

DELIMITER //
CREATE TRIGGER before_insert
BEFORE INSERT ON test_trigger
FOR EACH ROW
BEGIN
	INSERT INTO test_trigger_log (t_log)
	VALUES('before_insert');
END //
DELIMITER ;

INSERT INTO test_trigger (t_note) VALUES ('测试 BEFORE INSERT 触发器');
SELECT *FROM test_trigger_log;

DELIMITER //
CREATE TRIGGER after_insert
AFTER INSERT ON test_trigger
FOR EACH ROW
BEGIN
	INSERT INTO test_trigger_log (t_log)
	VALUES('after_insert');
END //
DELIMITER ;

INSERT INTO test_trigger (t_note) VALUES ('测试 AFTER INSERT 触发器');

SELECT * FROM test_trigger_log;

SHOW TRIGGERS;