#
# @lc app=leetcode id=202 lang=python3
#
# [202] Happy Number
#

# @lc code=start
class Solution:
    def isHappy(self, n: int) -> bool:
        # 记录过程，防止产生循环。
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
        # 构成循环，返回false 
        else:
            return False
# @lc code=end

