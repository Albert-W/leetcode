/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] list = s.split(" ");
        if (list.length != pattern.length()) {
            return false;
        }

        // key=symbol, value=word 
        Map<Character, String> map = new HashMap<>();

        for(int i = 0; i < list.length; i++) {
            // load the map
            if ( map.containsKey( pattern.charAt(i)) ) {
                if (!map.get(pattern.charAt(i)).equals(list[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(list[i])){
                    return false;
                }
                map.put(pattern.charAt(i), list[i]);
            }
        }
        return true;

    }
}
// @lc code=end

