/*
693. Binary Number with Alternating Bits
Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.

Example 1:
Input: 5
Output: True
Explanation:
The binary representation of 5 is: 101
Example 2:
Input: 7
Output: False
Explanation:
The binary representation of 7 is: 111.
Example 3:
Input: 11
Output: False
Explanation:
The binary representation of 11 is: 1011.
Example 4:
Input: 10
Output: True
Explanation:
The binary representation of 10 is: 1010.
 */
//bit manipulation

public class HasAlternatingBits {
    //通位移一位比较
    public boolean hasAlternatingBits(int n) {
        int x = n >> 1;
        //100;1001
//        return ((x+n)==(x^n) && ((x^n)&1)==1);
        x ^= n;
        x++;
        return (x & n) == 0;

    }

    //通过每一位比较, 14ms;
    //positive integer.
    public boolean hasAlternatingBits2(int n) {
        int mask = n & 1; //取未位；
        n = n >> 1;
        while (n != 0) {
            if ((mask & 1) == (n & 1)) {
                return false;
            }
            ;
            //或者 mask = 1- mask; 会在0，1之间跳转
            mask++;
            n = n >> 1;
        }
        return true;

    }
}
