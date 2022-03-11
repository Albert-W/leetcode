--
-- @lc app=leetcode id=184 lang=mysql
--
-- [184] Department Highest Salary
--

-- @lc code=start
# Write your MySQL query statement below

select D.name as Department, E.name as Employee, E.salary as Salary
from Employee E, Department D 
where E.departmentId = D.id and

E.salary = (
    select max(salary)
    from Employee E2
    where E2.departmentId = E.departmentId
)


-- @lc code=end

