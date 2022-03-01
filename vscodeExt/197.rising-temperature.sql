--
-- @lc app=leetcode id=197 lang=mysql
--
-- [197] Rising Temperature
--

-- @lc code=start
# Write your MySQL query statement below

-- select today.id 
-- from Weather today, Weather yesterday
-- where datediff( today.recordDate, yesterday.recordDate) = 1 and today.temperature > yesterday.temperature 

select today.id
from Weather today
inner join Weather yesterday on today.recordDate = adddate(yesterday.recordDate, 1)
where today.temperature > yesterday.temperature

-- @lc code=end

