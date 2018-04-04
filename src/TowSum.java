import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TowSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        for(int i=0;i<nums.length ;i++){
            for(int j=i+1;j<nums.length ;j++){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }


    /**
     *
     * @param ob the object two dimentional array
     * @param order the order of rules you like to be sort by.
     */
    public static void sort(int[][] ob, final int[] order) {
        Arrays.sort(ob, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                int[] one = (int[]) o1;
                int[] two = (int[]) o2;
                for (int i = 0; i < order.length; i++) {
                    int k = order[i];
                    if (one[k] > two[k]) {
                        return 1;
                    } else if (one[k] < two[k]) {
                        return -1;
                    } else {
                        continue;  //如果按一条件比较结果相等，就使用第二个条件进行比较。
                    }
                }
                return 0;
            }
        });
    }


    /**
     * the member k means the kth row you what to be sort by.
     */
    class mycom implements Comparator<Object>{
        int k=0;
        mycom(int k){
            this.k=k;
        }
        public int compare(Object o1, Object o2) {
            int[] one = (int[]) o1;
            int[] two = (int[]) o2;
            if(one[k]>two[k])return 1;
            else if(one[k]<two[k])return -1;
            return 0;
        }
    }

    /**
     *
     * @param ob the object you want to sort.
     */
    void sort(int [][] ob){
        Arrays.sort(ob, new mycom(0));

    }


    public int[] twoSum2(int[] nums, int target) {
        int[] result= new int[2];
        //build the two dimensional array.
        int[][] temp = new int [nums.length][2];
        for(int i=0;i<nums.length;i++){
            temp[i][0]=nums[i];
            temp[i][1]=i;
        }
        //sort the array.
        sort(temp);
        //find the pairs;
        int i=0,j=temp.length-1;
        while(i<j){
            if(temp[i][0]+temp[j][0]==target){
                result[0]=temp[i][1];
                result[1]=temp[j][1];
                return result;
            }
            else if(temp[i][0]+temp[j][0]<target){
                i++;
            } else {
                j--;
            }
        }

        return result;
    }


    class sum_03 {
        /**
         *
         * @param nums
         * @param target
         * @return
         * the reason why it has O(n) time. is:
         * containskey(),get() takes O(1) time.
         */
        public int[] twoSum(int[] nums, int target) {
            int []result = new int[2];
            HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
            for(int i=0;i<nums.length;i++){
                if(hashMap.containsKey(nums[i])){
                    result[0]=hashMap.get(nums[i]);
                    result[1]=i;
                    return result;
                }else{
                    hashMap.put(target-nums[i],i);
                }

            }
            return new int[]{0,0};
        }


    }
}




