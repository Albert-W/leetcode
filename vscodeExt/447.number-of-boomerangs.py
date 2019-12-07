#
# @lc app=leetcode id=447 lang=python3
#
# [447] Number of Boomerangs
#

# @lc code=start
class Solution:
    # dis[i,j] = dis[i, k]
    def numberOfBoomerangs(self, points: List[List[int]]) -> int:
        res = 0 
        i = 0
        # 对每一个i, 建立一个d[key = distance, value = count] # 求An(2)
        while i < len(points):
            d = {}
            j = 0
            while j < len(points) :
                if j != i:
                    s = self.distance(points[i], points[j] )
                    if s in d:
                        d[s] += 1
                    else:
                        d[s] = 1
                j += 1   
                # print("s is", s)
                # print("d[s] is", d[s])

            for value in d.values():
                # print(value)
                res += value*(value - 1)            
            i +=1
            # print("one round")
        return res

    def distance(self, A, B):
        res = (A[0]-B[0])**2 + (A[1]-B[1])**2
        # print(res)
        return res


# @lc code=end

