#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        # if nums == [0,0,0]:
        #     res.append(nums)
        #     return res 
        nums.sort()
        i = 0  # 第一个数
        while i < len(nums):
            j = i+1 # 第二个数
            # 不需要存储下标，可以采用set
            waitSet = set()
            usedSet = set()
            while j<len(nums):
                if nums[j] in waitSet and nums[j] not in usedSet:
                    res.append( [nums[i], 0-nums[i]-nums[j], nums[j]])
                    usedSet.add(nums[j])
                else:
                    waitSet.add(0-nums[i]-nums[j])    
                # # 对j 去重,到倒数第二个。  -2，1，1，1  
                # while j+2 < len(nums) and nums[j] == nums[j+1]:
                #     j+=1
                # else:
                #     j+=1
                j+=1
            # 对 i 进行去重。     
            while i+1 < len(nums) and nums[i]==nums[i+1]:
                i += 1    
            else:
                i += 1    
        # mySet = set(res)
        # res = list(mySet)

        return res           
        
# @lc code=end

