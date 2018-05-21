/*
231. Power of Two
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Example 2:

Input: 16
Output: true
Example 3:

Input: 218
Output: false

 */
//bit manipulation
public class IsPowerOfTwo {
    //极简
    public boolean isPowerOfTwo(int n) {
        return (n > 0 && (n & (n - 1)) == 0);
    }

    public boolean isPowerOfTwo2(int n) {
        //-16, false;
        if (n <= 0) return false;
        while (n > 1) {
            if ((n & 1) == 1) return false;
            n = n >> 1;
        }
        return true;

    }
}
