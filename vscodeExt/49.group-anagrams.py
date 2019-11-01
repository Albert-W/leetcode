#
# @lc app=leetcode id=49 lang=python3
#
# [49] Group Anagrams
#

# @lc code=start
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = {}
        for item in strs:
            sorted_str = ''.join(sorted(item))
            if sorted_str not in d:
                d[sorted_str]=[item]
            else:    
                d[sorted_str].append(item)       
        return d.values()


    def isAnagrams(self, s1, s2):
        if len(s1)!= len(s2):
            return False
        return sorted(s1) == sorted(s2)     
        # 不仅到两者元素种类相等，而且个数相等    
        # for i in s1:
        #     if i not in s2:
        #         return False
        #     else:
        #         if s1.count(i) != s2.count(i):
        #             return False        
        # return True            



# @lc code=end

s1 = "eat"
s2 = "tae"
print(Solution().isAnagrams(s1,s2))