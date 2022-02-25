--
-- @lc app=leetcode id=182 lang=mysql
--
-- [182] Duplicate Emails
--

-- @lc code=start
# Write your MySQL query statement below

select email as Email
from Person
group by email
having count(id) > 1


-- @lc code=end

