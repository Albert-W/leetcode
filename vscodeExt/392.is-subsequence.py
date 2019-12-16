#
# @lc app=leetcode id=392 lang=python3
#
# [392] Is Subsequence
#

# @lc code=start
class Solution:
    # runtime beats 98.49 % 
    def isSubsequence(self, s: str, t: str) -> bool:
        # 使用find加速查找        
        j = 0 
        # 在t中寻找s 的每个字符
        for i in s :
            k = t[j:].find(i)
            if k == -1:
                return False
            j = j+k+1
            print(j)
        return True

    # runtime beats 16.29 %
    def isSubsequence_1(self, s: str, t: str) -> bool:
        # 双指针，一次循环
        i = 0 
        j = 0 
        while i<len(s) and j < len(t):
            if s[i] == t[j]:
                i = i+1
            j = j+1
        if i == len(s):
            return True
        else:
            return False    
    
                    
        
# @lc code=end

