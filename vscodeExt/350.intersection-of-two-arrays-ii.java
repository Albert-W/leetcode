import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    // 求交集，元素可重复
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        // Map<Integer, Integer> m2 = new HashMap<>();
        List<Integer> re = new ArrayList<>();
        for(int i:nums1){
            m1.put(i, m1.getOrDefault(i, 0) + 1);
            // if(m1.containsKey(i)){
            //     m1.put(i, m1.get(i)+1);
            // } else {
            //     m1.put(i,1);
            // }
            
        }
        for(int i : nums2){
            if(m1.containsKey(i) && m1.get(i)!=0){
                re.add(i);
                m1.put(i,m1.get(i)-1);
            }
        }
        // int[] r = new int[res.size()];
        // for (int i = 0; i < res.size(); i++) {
        //     r[i] = res.get(i);
        // }
        
        return re.stream().mapToInt(i->i).toArray();
    }
}
// @lc code=end

