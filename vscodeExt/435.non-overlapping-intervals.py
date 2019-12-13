#
# @lc app=leetcode id=435 lang=python3
#
# [435] Non-overlapping Intervals
#

# @lc code=start
class Solution:
    # 使用贪心算法
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        n = len(intervals)
        if n == 0:
            return 0
        # 按结束区间排序 
        intervals.sort(key = lambda x:x[1])
        # 记数
        res = 1
        # 前一个数的结尾
        pre = intervals[0][1]
        for i in range(1, n):
            # i 区间的开头
            if pre <= intervals[i][0]:
                res += 1
                pre = intervals[i][1]
        return n - res        
                

    # Time Limit Exceeded 17/18
    def eraseOverlapIntervals_E1(self, intervals: List[List[int]]) -> int:
        if len(intervals) == 0:
            return 0
        # intervals =  sorted(intervals, key=lambda a:a[0])
        intervals.sort()
        # intervals = sorted(intervals) #默认按第一列排序
        # print(intervals)
        # print(sorted(intervals))
        memo = [1]*len( intervals)

        for i in range(1, len(intervals)):
            for j in range(i):
                if intervals[j][1] <= intervals[i][0]:
                    memo[i] = max(memo[i],  memo[j] + 1)
            # print(memo)    
        return len(intervals) - max(memo)           

# @lc code=end

