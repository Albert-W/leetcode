--
-- @lc app=leetcode id=620 lang=mysql
--
-- [620] Not Boring Movies
--

-- @lc code=start
# Write your MySQL query statement below

select id, movie, description, rating
from Cinema
where id % 2 = 1 and description != "boring" 
order by rating desc 

-- @lc code=end

