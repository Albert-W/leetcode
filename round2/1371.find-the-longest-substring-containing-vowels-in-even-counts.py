#
# @lc app=leetcode id=1371 lang=python3
#
# [1371] Find the Longest Substring Containing Vowels in Even Counts
#

# @lc code=start
class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        res = 0
        memo = [] # To record the ^vowels 
        if s[0] in vowels:
            memo.append(ord(s[0]))
        else:
            memo.append(0)
        for i in s[1:]:
            if i in vowels:
                memo.append(memo[-1] ^ ord(i))
            else:
                memo.append(memo[-1])
        # print(memo)
        # Find the longest sub array 
        appearance = {}
        for i in range(len(memo)):
            if memo[i] == 0:
                res = max(res, i + 1)
            if memo[i] not in appearance:
                appearance[memo[i]] = i 
            else: 
                res = max(res, i - appearance[memo[i]])
            
        return res
            
            
            
        
    
    def findTheLongestSubstring_TLE(self, s: str) -> int:
        vowels = {'a', 'e', 'i', 'o', 'u'}
        res = 0
        memo = [] # To record the ^vowels 
        if s[0] in vowels:
            memo.append(ord(s[0]))
        else:
            memo.append(0)
        for i in s[1:]:
            if i in vowels:
                memo.append(memo[-1] ^ ord(i))
            else:
                memo.append(memo[-1])
        # print(memo)
        # Find the longest sub array 
        for i in range(len(memo)):
            for j in range(i, len(memo)):
                if memo[j] == memo[i]:
                    if memo[i] == 0:
                        res = max(res, j + 1)
                    else:
                        res = max(res, j - i)
        return res
        
# @lc code=end

