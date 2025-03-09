# Write your MySQL query statement below
-- select e1.name 
-- from Employee e1 
-- JOIN Employee e2 ON 
-- e1.id = e2.managerId 
-- GROUP BY e1.id, e1.name
-- Having count(e2.managerId) > 5;
SELECT e1.name 
FROM Employee e1 
JOIN Employee e2 ON e1.id = e2.managerId 
GROUP BY e1.id, e1.name
HAVING COUNT(e2.managerId) > 4;
