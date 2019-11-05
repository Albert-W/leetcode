#
# @lc app=leetcode id=202 lang=python3
#
# [202] Happy Number
#

# @lc code=start
class Solution:
    def isHappy(self, n: int) -> bool:
        s = set()
        while n not in s:
            s.add(n)
            sum = 0 
            while n!= 0:
                sum += (n%10) ** 2 
                n = n//10
            print(sum)    
            if sum == 1:
                return True
            n = sum         
            
        else:
            return False
# @lc code=end

