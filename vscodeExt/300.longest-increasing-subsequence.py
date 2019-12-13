#
# @lc app=leetcode id=300 lang=python3
#
# [300] Longest Increasing Subsequence
#

# @lc code=start
class Solution:
    #[1,3,6,7,2,4]
    #[1, -1, -1, -1, -1, -1]
    #[1, 3, -1, -1, -1, -1]
    #[1, 3, 6, -1, -1, -1]
    #[1, 3, 6, 7, -1, -1]
    #[1, 2, 6, 7, -1, -1]
    #[1, 2, 4, 7, -1, -1]    
    
    def lengthOfLIS(self, nums: List[int]) -> int:
        # 最长增长串，覆盖之后的结果。 
        lis = [-1]*len(nums)
        # lis 的 结尾index
        size = 0 
        for x in nums:
            # 对分查找到到x 在lis 中的位置
            # 构成以x 结尾的 最长子串。 
            l , r = 0, size
            while l != r :
                mid = (l+r) //2 
                if lis[mid] < x:
                    l = mid + 1
                else:
                    r = mid 
            #找要对应对位置之后，用更小的值覆盖它。  
            lis[l] = x
            size = max(l+1, size)
            # print(lis)
        return size            

    # O(n2)
    def lengthOfLIS_1(self, nums: List[int]) -> int:
        # max() 不能为空
        if len(nums) == 0:
            return 0
        # 起步长度为1,记录包含本元素的最大子长度。     
        memo = [1]*len(nums)
        
        for i in range(1, len(nums)):
            j = i -1 
            while j >= 0 :
                if nums[j]< nums[i]:
                    memo[i] =max(memo[i], memo[j] + 1)
                    # break
                j = j -1     
        print(memo)
        # 返回最大值。 
        return max(memo)
        
# @lc code=end

