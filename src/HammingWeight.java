/*
191. Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011
Example 2:

Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 */
//bit manipulation
public class HammingWeight {
    // use sign bit;
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n < 0) count++;
            n = n << 1;
        }
        return count;
    }

    // use >>> to add 0 4ms;
    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = n >>> 1;
        }
        return count;
    }

    // you need to treat n as an unsigned value
    public int hammingWeight2(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;

    }
}
