import java.util.Arrays;
import java.util.HashSet;

/*
762. Prime Number of Set Bits in Binary Representation
Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.

(Recall that the number of set bits an integer has is the number of 1s present when written in binary. For example, 21 written in binary is 10101 which has 3 set bits. Also, 1 is not a prime.)

Example 1:

Input: L = 6, R = 10
Output: 4
Explanation:
6 -> 110 (2 set bits, 2 is prime)
7 -> 111 (3 set bits, 3 is prime)
9 -> 1001 (2 set bits , 2 is prime)
10->1010 (2 set bits , 2 is prime)
Example 2:

Input: L = 10, R = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
 */
//bit manipulation;//初始化
public class CountPrimeSetBits {
    int[] i = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
    HashSet<Integer> set = new HashSet(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));

    //use array[] as the map; 22ms;
    public int countPrimeSetBits3(int L, int R) {
        boolean[] map = new boolean[32]; //默认为false;
        int[] i = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int j = 0; j < i.length; j++) {
            map[i[j]] = true;
        }
        int count = 0;
        for (int j = L; j <= R; j++) {
            if (map[Integer.bitCount(j)]) count++;
        }
        return count;
    }

    //use the build-in function bitcount();31ms;
    public int countPrimeSetBits2(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(Integer.bitCount(i))) count++;
        }
        return count;
    }

    //36ms;
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(countBits(i))) count++;
        }
        return count;
    }

    int countBits(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    boolean isPrime(int num) {
        return set.contains(num);
    }
}
