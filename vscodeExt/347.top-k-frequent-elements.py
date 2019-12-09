#
# @lc app=leetcode id=347 lang=python3
#
# [347] Top K Frequent Elements
#

# @lc code=start
import heapq
class Solution:
    def topKFrequent_1(self, nums: List[int], k: int) -> List[int]:
        assert k> 0 
        # 统计频率
        # d (num, freq)
        d = {}
        for i in nums:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
        # 维护频率最高的k个元素。 
        # priority_queue（freq, number）
        q = []

        for key, value in d.items():
            if len(q) == k:
                # 需要比较大小，移出较小的
                # q与第一个数比较
                if value > q[0][0]:
                    heapq.heappop(q)
                    heapq.heappush(q,(value,key))
            elif len(q) < k:
                heapq.heappush(q,(value,key))

        res = []
        for i in q:
            print(i)
            res[:0]=(i[1],)
        return res            
                        
    # 顺序相反，也可以pass. 
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        #counter ( value: counts )
        counter = collections.Counter(nums)
        queue = []
        for n in counter:
            # q (counts, value)
            heapq.heappush(queue,(counter[n],n))
            if len(queue) > k:
                heapq.heappop(queue)
        res = []
        # 展开了tuple, 取第二个，输出结果
        for c, n in queue:
            print(c,n)
            res.append(n)
        return res


# @lc code=end

