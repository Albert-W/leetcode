#
# @lc app=leetcode id=9 lang=python
#
# [9] Palindrome Number
#

# @lc code=start
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        # Using String
        # return str(x) == str(x)[::-1]
    
        # Using Integer
        if x < 0:
            return False
        old = x
        new = 0
        while x != 0:
            new = new * 10 + x % 10
            x = x // 10 
            
            # print(x, new)
        return old == new
        
# @lc code=end

