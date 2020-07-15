/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int l = height.length;
        if (l<3){
            return 0;
        }
        int highest = 0;
        int water =0;
        
        for(int i =0; i< l;i++){
            if(height[i]>highest){
                highest = height[i];
            } else {
                water += highest - height[i];
            }
        }
        int dam = height[l -1];
        for(int i = l-1;i>=0 && height[i]!=highest; i--){
            if(height[i]> dam){
                dam = height[i];
            }
            water -= highest - dam;

        }


        return water;
        
    }
}
// @lc code=end

