import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for(int i : nums1){
            s.add(i);
        }
        
        for(int i : nums2){
            if(s.contains(i) && !l.contains(i) ){
                l.add(i);
            }
        }
        // 11 ms
        // return l.stream().mapToInt(i->i).toArray();

        // 6ms
        int[] res = new int[l.size()];
        int j = 0;
        for(int i:l){
            res[j] = i;
            j++;
        }
        return res;

        
    }
}
// @lc code=end

