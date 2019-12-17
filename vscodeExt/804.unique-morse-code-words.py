#
# @lc app=leetcode id=804 lang=python3
#
# [804] Unique Morse Code Words
#

# @lc code=start
class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        list = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        mset = set()
        for word in words:
            # print(word)
            morse = ""
            for i in word:
                # print(i)
                morse += list[ ord(i) - ord('a')]

            if morse not in mset:  
                mset.add(morse)

        return len(mset)          

        
# @lc code=end

