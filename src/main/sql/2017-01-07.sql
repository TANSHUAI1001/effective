# ENGINE=InnoDB使用innodb引擎
# DEFAULT CHARSET=utf8 数据库默认编码为utf-8
# AUTO_INCREMENT=1 自增键的起始序号为1

CREATE TABLE IF NOT EXISTS
  companys (company_id INT PRIMARY KEY , company_name VARCHAR(25))
  ENGINE = INNODB CHARACTER SET utf8;

INSERT INTO companys VALUES (1001,"广铁集团"),(1002,"宁铁集团");

CREATE TABLE IF NOT EXISTS employees (
  employee_id INT,
  employee_name VARCHAR(10),
  company_id INT,
  salary INT,
  birthday DATE,
  PRIMARY KEY (employee_id),
  FOREIGN KEY (company_id) REFERENCES companys(company_id)
)ENGINE = INNODB CHARACTER SET utf8;

# mysql 的标准DDL
CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL DEFAULT '0',
  `employee_name` varchar(10) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `companys` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#innodb foreign key

INSERT INTO employees VALUES (1,"总经理",1001,10000,'1980-02-01'),
  (2,"副总经理",1001,9999,'1979-12-12');

# count(1)不对
# group by
# join
#
SELECT company_id,company_name,count(1) as employee_num
FROM
  (SELECT employee_id,employee_name,salary,birthday,c.company_id,company_name
   FROM employees e RIGHT JOIN companys c ON e.company_id = c.company_id ) as total
GROUP BY company_id;

SELECT e.company_id,company_name,count(employee_id) as employee_num
FROM
  employees e RIGHT JOIN companys c ON e.company_id = c.company_id
GROUP BY company_id;

SELECT c.company_id,company_name,count(employee_id) as employee_num
FROM
employees e RIGHT JOIN companys c ON e.company_id = c.company_id
GROUP BY company_id;

SELECT * FROM employees WHERE birthday < '1980-01-01';

UPDATE employees SET salary = salary *1.1;

CREATE TABLE IF NOT EXISTS a(id INT PRIMARY KEY ,name VARCHAR(10))ENGINE = MyISAM DEFAULT CHARACTER SET utf8;
CREATE TABLE IF NOT EXISTS b(id INT, name VARCHAR(10), a_id INT,
PRIMARY KEY (id),
  FOREIGN KEY (a_id) REFERENCES a(id)
);

