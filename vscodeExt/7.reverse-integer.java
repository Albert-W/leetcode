/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    // 采用long 更加严谨的解法。
    public int reverse(int x) {
        // 防止-x<0 的死循环
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return 0-reverse(-x);
        }
        long rs = 0;
        while(x>0){
            // 乘10 会 左移3位多。
            rs = rs * 10 + x%10;
            x = x / 10;
        }
        if(rs > Integer.MAX_VALUE){
            return 0;
        }

        return (int)rs;
    }

    public int reverse2(int x) {
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return 0-reverse(-x);
        }
        int rs = 0;
        while(x>0){
            // 如果溢出发生在*10 阶段
            if(Integer.MAX_VALUE  / 10 < rs ){
                return 0;
            }
            // 乘10 会 左移3位多。
            rs = rs * 10 + x%10;
            // 如果溢出发生在 + 阶段
            if(rs < 0){
                return 0;
            }

            x = x / 10;
        }
        return rs;
    }
}
// @lc code=end

