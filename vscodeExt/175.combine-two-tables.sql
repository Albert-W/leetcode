--
-- @lc app=leetcode id=175 lang=mysql
--
-- [175] Combine Two Tables
--

-- @lc code=start
# Write your MySQL query statement below
select ptable.firstName, ptable.lastName, atable.city, atable.state 
from Person ptable
left join Address atable on ptable.personId = atable.personId 
-- @lc code=end

