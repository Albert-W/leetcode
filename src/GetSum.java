/*
371. Sum of Two Integers
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.

 */
//bit manipulation;recurrence;
public class GetSum {
    //without recurrence
    public int getSum2(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }


    //0ms;
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int temp = a ^ b;
        int x = a & b;
        return getSum(temp, x << 1);
    }
}
