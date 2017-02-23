-- #183. Customers Who Never Order
select Name as Customers from Customers Where id not in (select CustomerId from Orders);

SELECT A.Name from Customers A
WHERE NOT EXISTS (SELECT 1 FROM Orders B WHERE A.Id = B.CustomerId);

SELECT A.Name from Customers A
LEFT JOIN Orders B on  a.Id = B.CustomerId
WHERE b.CustomerId is NULL;


-- 262. Trips and Users
CREATE FUNCTION p1( request_at varchar(20)) RETURNS DOUBLE
BEGIN
DECLARE target INT;
DECLARE total INT;

SELECT COUNT(1) INTO target FROM trips t JOIN users u on t.Client_Id = u.Users_Id
WHERE  t.Request_at = request_at and u.Banned = 'No' and t.Status <> 'completed';

SELECT COUNT(1) INTO total FROM trips t JOIN users u on t.Client_Id = u.Users_Id
WHERE  t.Request_at = request_at and u.Banned = 'No';

if(total < 1 ) THEN return 0;
ELSE return target/total;
END IF;
END;

-- SELECT t,p1(t) WHERE t IN ('2013-10-01','2013-10-02','2013-10-03');

SELECT DISTINCT Request_at, FORMAT(p1(Request_at),2)
FROM trips WHERE trips.Request_at BETWEEN '2013-10-01' and '2013-10-03'

-- suggest answer
select
t.Request_at Day,
round(sum(
case
  when t.Status like 'cancelled_%'
  then 1
  else 0
end)/count(*),2) `Cancellation Rate`
from Trips t
inner join Users u
on t.Client_Id = u.Users_Id and u.Banned='No'
where t.Request_at between '2013-10-01' and '2013-10-03'
group by t.Request_at

-- SELECT COUNT(*) 返回null,若是想返回0，则可select count(*) from (select count(*))
PROCEDURE; function;