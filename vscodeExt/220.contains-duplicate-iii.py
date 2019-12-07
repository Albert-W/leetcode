#
# @lc app=leetcode id=220 lang=python3
#
# [220] Contains Duplicate III
#

# @lc code=start
class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        # index 之差为k
        # value 之差为t 
        # 按照 value 创建桶。每个桶的容量为t, 在同一个桶表明value 之差小于 t

        if t<0:
            return False
        # len(d) 最长为 k, 超过就删除最早的元素。形成滑动窗口 
        d = collections.OrderedDict()
     
        for i, val in enumerate(nums):
            n = val // max(1,t)  # 防止t = 0    
            # 取出val 与桶内元素比较
            # 如果本桶有其他元素，表明成功
            # if len(d)>=2:
            #     return True
            # 如果相邻的桶有元素，且value 绝对值小于t
            for j in (n-1, n ,n+1):
                if j in d and abs(val - d[j] )<= t :
                    return True
            d[n] = val

            # 添中一个元素，就删除一个元素，保持最大为k
            if i>= k :
                d.popitem(last = False)
        return False        
        
        
# @lc code=end

