--
-- @lc app=leetcode id=595 lang=mysql
--
-- [595] Big Countries
--

-- @lc code=start
# Write your MySQL query statement below
select name, population, area
from World
where area >= 3000000 or population >= 25000000

-- @lc code=end

