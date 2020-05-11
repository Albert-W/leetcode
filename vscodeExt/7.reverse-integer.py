#
# @lc app=leetcode id=7 lang=python3
#
# [7] Reverse Integer
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        if x < 0:
            return 0 - self.reverse(-x)
        result = 0    
        while x != 0 :
            result *= 10
            result += x % 10
            x = x//10 
            #print(result)
            # 防止溢出导致符号改变
            # 此int 最大为 2^64 -1 
        #if result < 0:
        #    return 0   
        # 2 ^ 32 xor
        # 2 ** 31 power 
        # 通过大小判断溢出
        if result >= 2 ** 31:
            return 0
        # 通过位运算判断溢出
        # 不能仅判断第32位
        # 1 << 31 # 32int最小值  -2^31
        #if (result & (1<<31)) >> 31 == 1:
        #    return 0

        return result     

        
# @lc code=end
