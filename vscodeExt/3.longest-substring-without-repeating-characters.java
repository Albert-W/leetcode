import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    // use map
    public int lengthOfLongestSubstring(String s) {
        // 记录过往出过的位置，省去了一次查找
        Map<Character,Integer> m = new HashMap<>();

        int max = 0;
        int last = -1; 
        for(int i = 0 ;i<s.length();i++){
            char c = s.charAt(i);
            // 找到子串起始点
            if(m.containsKey(c)){
                int k = m.get(c);
                last = Math.max(last, k);
            } 
            // 更新map ,会覆盖
            m.put(c, i);
            if(i - last >max){
                max = i - last;
            }
            
        }
        return max;
        
    }

    //use indexOf()
    public int lengthOfLongestSubstring_s(String s) {
        if(s.length()==0){
            return 0;
        }


        int max = 0;
        int begin = 0;
        int end = 0;
        //[begin, end] is the test example
        for(;end<s.length();end++){
            char c = s.charAt(end);
            int i = s.indexOf(c,begin);
            // find repeated char
            if(i>=begin && i<end){
                begin = i+1;
            }
            if(end - begin > max){
                max = end -begin;
            }
        }
        return max+1;
        
    }
}
// @lc code=end

