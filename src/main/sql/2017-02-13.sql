-- 176. Second Highest Salary
SELECT MAX(Salary) as SecondHighestSalary FROM (
  SELECT Salary FROM Employee WHERE Salary < (SELECT MAX(Salary) FROM Employee)
) as RestEmployee;

-- 177. Nth Highest Salary
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M = N - 1;
  RETURN (
    SELECT Salary FROM Employee ORDER BY Salary DESC limit M,1;
-- 此处limit不能使用limit N-1,1
-- You have an error in your SQL syntax;
-- check the manual that corresponds to your MySQL server version
-- for the right syntax to use near '-1,1);END'
-- limit只支持纯数字，不支持运算符
-- Seems like MySQL can only take numeric constants in the LIMIT syntax.
);
END;
SELECT getNthHighestSalary(2);

DROP FUNCTION getNthHighestSalary;

-- 178. Rank Scores
SELECT score,  rank FROM scores
SELECT COUNT(DISTINCT(score))
