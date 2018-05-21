/*
477. Total Hamming Distance
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Now your job is to find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.
 */
//bit manipulation
public class TotalHammingDistance {
    /*
    按每一位来比较，
    比如第32位，有10个0，21个1
    第个1<>0 都会加1
    第32位上的总和就为 10*21；
     */
    //43ms;->40ms;
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int zeros = 0, ones = 0;
            for (int j = 0; j < nums.length; j++) {
//                if((nums[j]>>>i & 1) == 0)zeros++;
                //else ones++;
                //18ms; 减少了判断；时间大幅减少。
                ones += nums[j] >>> i & 1;

            }
//            sum+=zeros*ones;
            sum += ones * (nums.length - ones);
        }
        return sum;
    }


    //36/47 Time Limit Exceeded
    public int totalHammingDistance2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count += hammingDistance(nums[i], nums[j]);
            }
        }
        return count;

    }

    public int hammingDistance(int x, int y) {
        //return hammingWeight(x ^ y);
        int n = x ^ y;
        int count = 0;
        while (n != 0) {
            if (n < 0) count++;
            n = n << 1;
        }
        return count;
    }

    // use sign bit;
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n < 0) count++;
            n = n << 1;
        }
        return count;
    }
}
