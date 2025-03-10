# Write your MySQL query statement below
SELECT p.project_id,
Coalesce(ROUND(AVG(e.experience_years),2),0.00) AS average_years
FROM  Project p Left JOIN 
Employee e ON P.employee_id = e.employee_id
GROUP BY p.project_id