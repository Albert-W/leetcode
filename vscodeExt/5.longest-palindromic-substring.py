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
    # 超时
    def longestPalindrome_1(self, s: str) -> str:
        if len(s)< 2:
            return s 
        maxL = 1 # 最长子串长度
        startI = 0 # 开始index
        i = 0
        while i < len(s):
            l = 0
            while i + l <= len(s):
                if self.isPalindrome2(s[i:i+l]):
                    if l > maxL: 
                        maxL = l 
                        startI = i 
                l+=1
            i+=1
        return s[startI: startI + maxL]

    # 功能函数在此
    def longestPalindrome(self, s: str) -> str:
        if len(s)< 2:
            return s 
        #记录最终要返回的状态    
        start = 0 # 
        end = 0 # 
        # j = 0
        # 
        # 从0 到 len(s)//2 - 1
        i = 0 # 游标 
        while i < len(s):
            # two cases:
            # 1, 偶数子串            
            j = 0
            while j <= i and i+j+1 < len(s):
                if s[i-j] == s[i+j+1]:
                    if 2*j+2 > end - start:
                        start = i -j 
                        end = i+j+1
                    j += 1
                else:
                    break         
            # 2,奇数子串
            j = 1 
            while j <= i and i+j <len(s):    
                # 共用i,j时 已经变动
                if s[i-j] == s[i+j]:
                    if 2*j + 1 > end - start:
                        start = i-j
                        end = i+j         
                    j += 1
                else:
                    break
            i += 1

        return s[start: end+1]    

    def isPalindrome(self,s: str):
        if s == s[::-1]:
            return True
        else:
            return False  
    # len()为偶数时，比较的长度为 len()//2 - 1 # 4, 比较0，1
    # len()为奇数时，比较的长度为 len()//2 - 1 # 3，比较0
    def isPalindrome2(self,s: str):
        if len(s) < 2:
            return True 
        # 实际取值为0...len(s)//2 - 1    
        for i in range(len(s)//2 ):
            if(s[i] != s[len(s)-1-i]):
                return False
        return True         

# @lc code=end

