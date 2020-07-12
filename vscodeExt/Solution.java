import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    // return the right index of end;
    // find from [begin, end]
    public int partition(int[] nums, int begin, int end){
        if(begin < 0 || end >= nums.length){
            return -1;
        }
        int anchor = nums[end];
        // put every elem larger then anchor to the end;
        int place = end -1;
        for(int i = begin;i<=place;){
            //change the direction at here.
            if(nums[i]<=anchor){
                int t = nums[place];
                nums[place] = nums[i];
                nums[i] = t;
                place -=1;
            } else{
                i+=1;
            }
        }
        // swich placeholder and anchor;
        int t = nums[place+1];
        nums[place+1] = anchor;
        nums[end] = t;
        return place+1;
    }

    public static void main(String[] args) {
        int[] a = {0,2,1,3,4,6,3,4};
        // new Solution().partition(a, 0, a.length-1);

        Arrays.sort(Arrays.copyOfRange(a, 0, 4));
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, 4)));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        int[] b = IntStream.range(1, 100).toArray();
        System.out.println(Arrays.toString(b));
    }
}