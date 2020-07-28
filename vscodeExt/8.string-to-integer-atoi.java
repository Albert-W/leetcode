import java.util.regex.*;

/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    // "+1",  1
    // "3.14"  3
    // " -0012a43"  -12
    // "-5-"  -5

    public int myAtoi(String str) {
        String t = str.trim();
        // String regex = "^[-?]\\d+.*";// "42"失败
        String regex = "^[+-]?\\d+.*";
        if( !t.matches(regex)){
            return 0;
        }

        String[] ary = t.split("\\s+"); // 除去空格
        String[] ary2 = ary[0].split("[a-zA-z]"); // 找出中间的字符
        // Pattern p = Pattern.compile("(^[+-]?\\d+)(.*)");
        // Matcher m = p.matcher(t);
        String d;
        if(ary2[0].indexOf("+", 1) > 0 ){
            int k = ary2[0].indexOf("+", 1);
            d = ary2[0].substring(0, k);
        } else if (ary2[0].indexOf("-", 1) > 0 ){
            int k = ary2[0].indexOf("-", 1);
            d = ary2[0].substring(0, k);
        } else {
            d = ary2[0];
        }
        



        System.out.println(d);
        double x ;
        try {
            x = Double.parseDouble(d);
            
        } catch (Exception e) {
            //TODO: handle exception
            return 0;
        }
        
        if(x > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else if ( x < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else {
            return (int)x;
        }
        
        
    }
}
// @lc code=end

