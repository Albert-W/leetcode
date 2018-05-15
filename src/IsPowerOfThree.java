/*
326. Power of Three
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 */
public class IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        //n=243 时失败；
//        int x =(int)(Math.log(n)/Math.log(3)); //理论上x=5,结果x=4;
        int x = (int) Math.round(Math.log(n) / Math.log(3));
        return n == Math.pow(3, x);
    }


    public boolean isPowerOfThree4(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return (n > 0 && 1162261467 % n == 0);
    }


    //减少循环内判断语句
    public boolean isPowerOfThree3(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }


    //87ms;
    public boolean isPowerOfThree2(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        return true;

    }
}
