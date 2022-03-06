--
-- @lc app=leetcode id=1179 lang=mysql
--
-- [1179] Reformat Department Table
--

-- @lc code=start
# Write your MySQL query statement below

select id, 
max( if (month = "Jan", revenue, null )) as Jan_Revenue,
max( if (month = "Feb", revenue, null )) as Feb_Revenue,
max( if (month = "Mar", revenue, null )) as Mar_Revenue,
max( if (month = "Apr", revenue, null )) as Apr_Revenue,
max( if (month = "May", revenue, null )) as May_Revenue,
max( if (month = "Jun", revenue, null )) as Jun_Revenue,
max( if (month = "Jul", revenue, null )) as Jul_Revenue,
max( if (month = "Aug", revenue, null )) as Aug_Revenue,
max( if (month = "Sep", revenue, null )) as Sep_Revenue,
max( if (month = "Oct", revenue, null )) as Oct_Revenue,
max( if (month = "Nov", revenue, null )) as Nov_Revenue,
max( if (month = "Dec", revenue, null )) as Dec_Revenue


from Department
group by id 

-- @lc code=end

