#
# @lc app=leetcode id=3136 lang=python
#
# [3136] Valid Word
#

# @lc code=start
class Solution(object):
    def isValid(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if len(word) < 3:
            return False
        contains_vowel = False
        contains_consonant = False
        for i in word:
            if i.isalpha() == True:
                if i in 'aeiou' or i in 'AEIOU':
                    contains_vowel = True
                else:
                    contains_consonant = True
            else:
                if i < "0" or i > "9":
                    return False
        return contains_vowel and contains_consonant
        
# @lc code=end

