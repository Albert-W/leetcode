#
# @lc app=leetcode id=56 lang=python3
#
# [56] Merge Intervals
#

# @lc code=start
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        res = []
        sorted_intervals = sorted(intervals, key=lambda x: x[0])
        i = 0
        while( i < len(sorted_intervals)): 
            start = sorted_intervals[i][0]
            end = sorted_intervals[i][1]
            while (i + 1 < len(sorted_intervals) and end >= sorted_intervals[i+1][0]):
                i += 1 
                end = max(end, sorted_intervals[i][1])
            res.append([start, end])
            i += 1
            
        
        return res
        
# @lc code=end

