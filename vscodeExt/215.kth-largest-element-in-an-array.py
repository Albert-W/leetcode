#
# @lc app=leetcode id=215 lang=python3
#
# [215] Kth Largest Element in an Array
#

# @lc code=start
class Solution:

    def findKthLargest(self, nums: List[int], k: int) -> int:
        # New solution. construct a better particion. 
        return self.findKthParticion(nums,0, len(nums)-1, k)

    def findKthParticion(self, list, s, e, k):
        anchor = list[e]
        i = s-1 #[s, i]是 大于anchor的区间。 
        for j in range(s,e):
            if list[j] >= anchor:
                i = i+1 
                if i != j:
                    list[i], list[j] = list[j], list[i] # 小于anchor的向前移动。 
        list[i+1], list[e] = list[e], list[i+1]
        print(list[i+1], i+1)
        if i + 1 == k -1 :
            return list[i+1]
        if i + 1 > k -1:
            return self.findKthParticion( list, s, i, k)
        else:
            return self.findKthParticion(list, i+2, e, k)        
        # return i+1        
        # return -1

    def findKthLargest_1(self, nums: List[int], k: int) -> int:
        index = self.particion(nums, 0, len(nums)-1)
        # k-1 为相要的index 
        if index  == k -1:
            return nums[index]
        if index  < k -1:
            return self.findKthLargest(nums[index+1:], k-index -1)   
        else:
            return self.findKthLargest(nums[:index], k)     

    # sort list[s,e], return the index of anchor    
    def particion(self, list, s , e): #[start,end]是排序范围
        anchor = list[e]
        i = s-1 #[s, i]是 大于anchor的区间。 
        for j in range(s,e):
            if list[j] >= anchor:
                i = i+1 
                if i != j:
                    list[i], list[j] = list[j], list[i] # 小于anchor的向前移动。 
        list[i+1], list[e] = list[e], list[i+1]
        print(i+1)
        return i+1



# @lc code=end

