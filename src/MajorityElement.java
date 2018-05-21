import java.util.Arrays;
import java.util.HashMap;

/*
169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {
    //bit manipulation;
    // O(32n);18ms;
    //由于每一位上的数只有0，1 因此可以方便统计；
    public int majorityElement6(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) count++;

            }
            if (count > nums.length / 2) {
                res = res | (1 << i);
            }

        }
        return res;
    }


    //Divide and Conquer method
    //O(nlgn) 7ms;
    public int majorityElement5(int[] nums) {
        return major(nums, 0, nums.length - 1);
    }

    int major(int[] nums, int sta, int end) {
        if (sta == end) return nums[sta];
        int mid = sta + (end - sta) / 2;
        int lMajor = major(nums, sta, mid);
        int rMajor = major(nums, mid + 1, end);
//        return Math.max(lMajor,rMajor);//this will get the maximum value;
        if (lMajor == rMajor) return lMajor;
        //如果不等，就比较票数；8,8,7,7,7;
        //*如果前一半的票数=后一半的票数，结果一定在后一半。因为后一半的总元素少一;
        return count(nums, sta, mid, lMajor) > count(nums, mid + 1, end, rMajor) ? lMajor : rMajor;
    }

    int count(int nums[], int sta, int end, int value) {
        int res = 0;
        for (int i = sta; i <= end; i++) {
            if (nums[i] == value) res++;
        }
        return res;
    }


    //HashMap method
    //O(n) 37ms;
    public int majorityElement4(int[] nums) {
        if (nums.length <= 1) return nums[0];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                int count = hashMap.get(nums[i]);
                hashMap.put(nums[i], count + 1);
                if (count + 1 > nums.length / 2) return nums[i];
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        return 0;
    }


    //first sort, then count;O(nlgn);9ms;
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);

        //this part is double faster than the count method below;
        for (int i = 0; i < nums.length / 2 + 1; i++) {
            int j = i + nums.length / 2;
            if (j < nums.length && nums[i] == nums[j]) return nums[i];
        }
        return 0;
/**************************start**************************/
//        int count=0;
//        int k=nums[nums.length/2];
//        for(int num:nums){
//            if(num==k)count++;
//        }
//        if(count>nums.length/2)
//            return k;
//        else return 0;
/**************************end  **************************/

    }

    //count method;O(n);6ms;
    //即众数的计数，要超过其他所有计数之和。
    //Moore Voting Algorithm 与叫多数投票算法；TC O(n) SC O(1);
    /*
    扔掉一个众数和一个非众数，众数不变
    扔掉两个非众数，众数不变
     */

    public int majorityElement3(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) count++;
            else if (count > 1) count--;
            else res = nums[i];
        }
        return res;
    }


    //when the array is {1,1,1,1……}, Time limit exceeded;
    //quick partition method; O(nlgn);
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int mid = findIndexK(nums, 0, nums.length - 1, nums.length / 2);
        int count = 0;
        for (int num : nums) {
            if (num == mid) count++;
        }
        if (count > nums.length / 2)
            return mid;
        else return 0;


    }

    //find the number with index of k;
    int findIndexK(int[] nums, int sta, int end, int k) {
        int q = partition(nums, sta, end);
        if (q == k) return nums[q];
        if (q < k) return findIndexK(nums, q + 1, end, k);
        else return findIndexK(nums, sta, q - 1, k);
    }

    //partition method;
    int partition(int[] nums, int sta, int end) {
        if (sta == end) return sta;
        int k = nums[end];
        int i = sta;
        for (int j = sta; j < end; j++) {
            if (nums[j] <= k) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
        }
        int t = nums[i];
        nums[i] = nums[end];
        nums[end] = t;
        return i;
    }
}
