/*
342. Power of Four
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?
 */
public class IsPowerOfFour {

    //n > 0 && (n & (n - 1)) == 0 保证n 是2的次幂，2进制表示中只存在一个1；
    //4进制要保证这唯一的1出现在遇数位上。即n & 0x 55555555 !=0
    public boolean isPowerOfFour(int n) {
        return (n > 0 && (n & (n - 1)) == 0
            && (n & 0x55555555) != 0);
    }

    public boolean isPowerOfFour2(int num) {
        if (num <= 0) return false;
        while (num % 4 == 0) {
            num /= 4;
        }
        return num == 1;

    }
}
