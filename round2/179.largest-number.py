#
# @lc app=leetcode id=179 lang=python3
#
# [179] Largest Number
#

# @lc code=start
from functools import cmp_to_key
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        new = list(map(str, nums))
        new.sort(key=lambda a:a*10, reverse=True)
        if new[0] == "0":
            return "0"
        return "".join(new)
        
    def largestNumber_s(self, nums: List[int]) -> str:
        def compare(a, b):
            return int(b + a) - int(a + b)
        new = [str(a) for a in nums]
        new.sort(key=cmp_to_key(compare))
        res = "".join(new)
        return str(int(res))
    
    def largestNumber_w(self, nums: List[int]) -> str:
        # Transform the int to string, sort the string 
        # 303 vs 330
        new = [str(a) for a in nums]
        new.sort(reverse=True)
        res = ""
        for i in new:
            res += i
        return res
        
# @lc code=end

