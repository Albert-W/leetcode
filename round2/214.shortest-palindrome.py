#
# @lc app=leetcode id=214 lang=python3
#
# [214] Shortest Palindrome
#

# @lc code=start
class Solution:
    def shortestPalindrome(self, s: str) -> str:
        i = len(s) 
        while i > 0:
            if self.isPalindrome(s[0:i]):
                break
            i -= 1
        # print(s[i:])
        # print(s[:i-1:-1])
        return s[:i-1:-1]+ s
        
    def isPalindrome(self, s):
        return s == s[::-1]
        
# @lc code=end

