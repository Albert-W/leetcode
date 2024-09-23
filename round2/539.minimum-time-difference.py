#
# @lc app=leetcode id=539 lang=python3
#
# [539] Minimum Time Difference
#

# @lc code=start
class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        # convert the string into int (minutes)
        def convertTime(s):
            arr = s.split(":")
            return int(arr[0]) * 60 + int(arr[1])
        
        times = [convertTime(a) for a in timePoints]
        times.sort()
        # print(times)
        res = 24 * 60
        for i in range(1, len(times)):
            res = min(res, times[i] - times[i-1])
        # There is a chance that [00:00, 23:59]
        res = min(res, times[0] + 1440 - times[-1])
        return res
# @lc code=end

