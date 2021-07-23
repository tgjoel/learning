-- 2nd largest value in a column in Table

SELECT MAX (column_name) FROM table_name
WHERE column_name NOT IN (SELECT Max (column_name) FROM table_name);

-- SQL Query to find Max Salary from each department.
 SELECT DeptID, MAX(Salary) FROM Employee  GROUP BY DeptID.
