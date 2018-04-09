import java.util.*;
/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

/*
为了去重，采用先排序。
以i为指标。i后面的数组中寻找两个和为-nums[i]
 */

public class ThreeSum {
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length==0)
            return res;
        for(int i=0;i<nums.length;i++){
            List<List<Integer>> a = twoSum(Arrays.copyOfRange(nums,i+1, nums.length),-nums[i]);
            for(List<Integer> item : a)
                item.add(nums[i]);
            res.addAll(a);
        }
        return res;


    }

    // there may be different pair of result;
    public List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(nums.length==0)
            return res;

        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
//                result[0]=hashMap.get(nums[i]);
//                result[1]=i;
//                return result;
                ArrayList<Integer> a = new ArrayList<>();
                a.add(nums[i]);
                a.add(target-nums[i]);
                res.add(a);
            }else{
                hashMap.put(target-nums[i],i);
            }

        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<3)
            //return null; 不能用[] 不等于 null.
            return res;
        Arrays.sort(nums);

        for(int i=nums.length-1;i>=0;i--){
            Set<List<Integer>> s = twosumofsortarray(Arrays.copyOfRange(nums,0,i),-nums[i]);
            for(List<Integer> item :s)
                item.add(nums[i]);

            res.addAll(s);
            while(i-1>0 && nums[i-1]==nums[i])
                i--;
        }
        return res;



    }

    public Set<List<Integer>> twosumofsortarray(int[] nums, int target){
        Set<List<Integer>> res = new HashSet<List<Integer>>();

        if(nums.length<2)
            return res;

        int i=0,j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                ArrayList<Integer> a = new ArrayList<>();
                a.add(nums[i]);
                a.add(nums[j]);
                res.add(a);
                i++;

            } else if (nums[i]+nums[j]>target){
                j--;
            } else i++;
        }
        return res;

    }
}
