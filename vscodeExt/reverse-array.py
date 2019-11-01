class Solution:
    def reverseArray(self, l) :
        i = 0
        while i < (len(l)+1)//2 :
            t = l[i]
            l[i]= l[len(l)-i-1]
            l[len(l)-i-1] = t 
            i += 1
        return l 


l = [1,2,3,4,5,6]
s = Solution()
t = s.reverseArray(l)
print(t)            
