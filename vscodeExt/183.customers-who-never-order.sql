--
-- @lc app=leetcode id=183 lang=mysql
--
-- [183] Customers Who Never Order
--

-- @lc code=start
# Write your MySQL query statement below

select name as Customers
from Customers
where id not in 
(select customerId 
from Orders)

-- @lc code=end

