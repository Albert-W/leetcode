import java.util.HashMap;

/*
136. Single Number
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4

 */
public class SingleNumber {
    //用按位异或求解。
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }


    //还可以通过排序后比较O(nlogn)
    //24ms;
    public int singleNumber2(int[] nums) {
//        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) hashMap.remove(num);
            else hashMap.put(num, 1);
        }
        return hashMap.keySet().iterator().next();
    }


//    public int singleNumber(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(hashSet.contains(nums[i])) hashSet.remove(nums[i]);
//            else hashSet.add(nums[i]);
//        }
//        return hashSet.
//    }
}
