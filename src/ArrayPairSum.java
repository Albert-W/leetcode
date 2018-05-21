import java.util.Arrays;

/*
561. Array Partition I
Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 */
public class ArrayPairSum {
    //optimize; 17ms;
    public int arrayPairSum3(int[] nums) {
        char[] buckets = new char[20001];
        for (int num : nums) buckets[num + 10000]++;
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < buckets.length; i++) {
            while (i < buckets.length && buckets[i] == 0) i++;
            while (i < buckets.length && buckets[i] != 0) {
                if (odd == true) sum += i - 10000;
                odd = !odd;
                buckets[i]--;
            }
        }
        return sum;
    }


    //the problem gives us the upper and lower bounds;
    //we could use the bucket sort;
    public int arrayPairSum2(int[] nums) {
        //make bucket with the minimum size
        //char.max > nums.length;
        char[] buckets = new char[20001];
        for (int i = 0; i < nums.length; i++) {
            buckets[nums[i] + 10000]++;
        }
        //pick one number after another;
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != 0) {
                if (odd == true) {
                    sum += i - 10000;
                }
                odd = !odd;
                buckets[i]--;
                i--;
            }
        }
        return sum;

    }

    //sort and pick the minimum; 34ms;
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;

    }
}
