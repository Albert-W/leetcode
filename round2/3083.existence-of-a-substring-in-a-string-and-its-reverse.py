#
# @lc app=leetcode id=3083 lang=python
#
# [3083] Existence of a Substring in a String and Its Reverse
#

# @lc code=start
class Solution(object):
    def isSubstringPresent(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # Your runtime beats 45.24 % 
        # for i in range(len(s)-1):
        #     if "".join(reversed(s[i:i+2])) in s:
        #         return True
        # return False
    
        # Try using a map
        # Your runtime beats 92.26 %
        _set = set()
        for i in range(len(s)-1):
            reversed_str = "".join([s[i+1], s[i]])
            if s[i:i+2] in _set or s[i:i+2] == reversed_str:
                return True
            else: 
                _set.add(reversed_str)
            
        return False 
        
# @lc code=end

