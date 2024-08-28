// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        // [20, 50] gcd is 10, 
        // 20 / 10 = 2, 50 / 10 = 5, shoud be divisor of gcd

        int res = 0;
        for (int i = 0; i< A.length; i++) {
            if (isValid(A[i], B[i])) {
                res += 1;
            }
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public boolean isValid(int a, int b) {
        int c = gcd(a, b);
        int a_c = gcd(a, c);

        // a_c may be 64, c may be 10, b_c may be 25 
        while (a_c != 1) {
            a = a / a_c;
            a_c = gcd(a, c);
        }
        if (a != 1) {
            return false;
        }

        int b_c = gcd(b, c);
        while (b_c != 1) {
            b = b / b_c;
            b_c = gcd(b, c);
        }
        if (b != 1) {
            return false;
        }
        return true;
    }
}


    // [2, 8] -> c = 2,
    public boolean isValid(int a, int b) {
        // the gcd of a and b may contain multiple prime factors such as 2, 2, 2, 3 
        int c = gcd(a, b);
        // It may by like 64 
        int a_c = a / c;
        while (a_c % c == 0 && c != 1) {
            a_c = a_c / c;
        }
        int b_c = b / c; 
        while (b_c % c == 0 && c != 1) {
            b_c = b_c / c;
        }
        // System.out.printf("%d + %d + %d \n", a,b,c);
        return c % a_c == 0 && c % b_c == 0; 
    }
}