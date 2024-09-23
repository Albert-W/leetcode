#
# @lc app=leetcode id=2220 lang=python3
#
# [2220] Minimum Bit Flips to Convert Number
#

# @lc code=start
class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
        # Get the XOR between start & goal. 
        xor = start ^ goal
        # Count the i in it
        xor.bit_count
        return bin(xor).count('1')

        
# @lc code=end

