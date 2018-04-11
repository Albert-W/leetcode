import java.lang.annotation.Target;
import java.util.*;

/*
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class FourSum {
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<4)
            //return null; 不能用[] 不等于 null.
            return res;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--){
            List<List<Integer>> s = threeSum(Arrays.copyOfRange(nums,0,i),-nums[i]+target);
            for(List<Integer> item :s)
                item.add(nums[i]);

            res.addAll(s);
            while(i-1>0 && nums[i-1]==nums[i])
                i--;
        }
        return res;

    }

    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<3)
            //return null; 不能用[] 不等于 null.
            return res;
        Arrays.sort(nums);

        for(int i=nums.length-1;i>=0;i--){
            Set<List<Integer>> s = twosumofsortarray(
                Arrays.copyOfRange(nums,0,i),-nums[i]+ target);
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

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<4)
            //return null; 不能用[] 不等于 null.
            return res;

        int i=0,j=1,m=2,n=3;
        fourSum(nums,target,i,j,m,n,res);
        return res;
    }
    public void fourSum(int[] nums, int target, int i,int j, int k,int l,List<List<Integer>> res) {
        List<Integer> tmp = new ArrayList<Integer>();
        if(nums.length<4)
            //return null; 不能用[] 不等于 null.
            return ;

        if(!(i<j&&j<k&&k<l&&l<nums.length)) {
            return;
        }   else {
            if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                tmp.add(nums[k]);
                tmp.add(nums[l]);
                res.add(tmp);
                //return ;
            }
            //it does not work out. too redundant

                fourSum(nums,target,i+1,j,k,l,res);
                fourSum(nums,target,i,j+1,k,l,res);
                fourSum(nums,target,i,j,k+1,l,res);
                fourSum(nums,target,i,j,k,l+1,res);

            return;
        }

        //return;
    }
}
