#
# @lc app=leetcode id=5 lang=python3
#
# [5] Longest Palindromic Substring
#

# @lc code=start
# Time Limit Exceeded
# "aaaaaaaaaaaaaaaaaaa"
class Solution_fail:
    
    def longestPalindrome(self, s: str) -> str:
        if len(s)< 2:
            return s 
        maxL = 1 # 最长子串长度
        startI = 0 # 开始index
        i = 0
        while i < len(s):
            l = 0
            while i + l <= len(s):
                if self.isPalindrome(s[i:i+l]):
                    if l > maxL: 
                        maxL = l 
                        startI = i 
                l+=1
            i+=1
        return s[startI: startI + maxL]

    def isPalindrome(self,s: str):
        if s == s[::-1]:
            return True
        else:
            return False  

class Solution:
    
    def longestPalindrome(self, s: str) -> str:
        if len(s)< 2:
            return s 
        maxL = 1 # 最长子串长度
        startI = 0 # 开始index
        i = 0
        while i < len(s):
            l = 0
            while i + l <= len(s):
                if self.isPalindrome(s[i:i+l]):
                    if l > maxL: 
                        maxL = l 
                        startI = i 
                l+=1
            i+=1
        return s[startI: startI + maxL]

    def isPalindrome(self,s: str):
        if s == s[::-1]:
            return True
        else:
            return False  
     
# @lc code=end

