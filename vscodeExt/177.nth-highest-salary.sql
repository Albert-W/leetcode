--
-- @lc app=leetcode id=177 lang=mysql
--
-- [177] Nth Highest Salary
--

-- @lc code=start
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set N = N -1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary
        from Employee
        order by salary desc
        limit 1 offset N
      
  );
END
-- @lc code=end

