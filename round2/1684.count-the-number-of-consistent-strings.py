#
# @lc app=leetcode id=1684 lang=python3
#
# [1684] Count the Number of Consistent Strings
#

# @lc code=start
class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        res = 0
        s = set(allowed)
        for w in words:
            for c in w:
                if c not in s:
                    res += 1
                    break

        return len(words) - res
        
# @lc code=end

