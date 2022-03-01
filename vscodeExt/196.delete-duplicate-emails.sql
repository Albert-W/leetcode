--
-- @lc app=leetcode id=196 lang=mysql
--
-- [196] Delete Duplicate Emails
--

-- @lc code=start
# Write your MySQL query statement below

delete from Person
where id not in (
    select * from (
            select min(id) 
            from Person
            group by email 
    ) as p
) 

-- @lc code=end

