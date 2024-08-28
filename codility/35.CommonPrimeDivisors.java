// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        // Implement your solution here
        // [20, 50] gcd is 10, 
        // 20 / 10 = 2, 50 / 10 = 5, shoud be divisor of gcd

        // Get A number's prime divisor 
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public boolean isValid(int a, int b) {
        
    }
}