/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();

        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0;i<numRows;i++){
            sb[i] = new StringBuilder();
        }
        // for( StringBuilder si:sb){
        //     si = new StringBuilder();
        // }

        int i = 0;
        while(i < c.length){
            
            for(int j = 0;j<numRows && i<c.length;j++){
                sb[j].append(c[i]);
                i+=1;
            }
            for(int k = numRows -2;k>0 && i<c.length;k--){
                sb[k].append(c[i]);
                i+=1;
            }
        }
        StringBuilder res = new StringBuilder(); 
        for(i = 0;i<numRows;i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}
// @lc code=end

