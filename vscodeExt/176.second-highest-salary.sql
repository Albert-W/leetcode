--
-- @lc app=leetcode id=176 lang=mysql
--
-- [176] Second Highest Salary
--

-- @lc code=start
# Write your MySQL query statement below

select 
    (select distinct salary 
    from Employee
    order by salary desc
    limit 1 offset 1) as SecondHighestSalary


-- @lc code=end

