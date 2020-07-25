public class Dominator {
    public static void main(String[] args) {
        // int[] a = {0, 5, 1, 2, 3, 2, 9, 2, 2};
        int[] a = {2, 9, 2, 20, 5, 1, 2, 3, 2, 9, 2, 2};
        int r = new Solution().solution(a);
        System.out.println(r);
    }    
}

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // sort and find the middle one. O(nlgn) 
        
        // voting methods. 
        // find the only possible dominator. 
        int count = 1;
        //int item = 0;
        int index = 0;
        for(int i=1;i<A.length;i++){
            if (A[i] == A[index]){
                count ++;
            } else {
                count --;
                if(count <= 0){
                    index = i;
                    count = 1;
                }
            }
            // System.out.println(index +" " + count);
        }
        // confirm that it is the dominator. 
        count = 0;
        for(int i :A){
            if(i == A[index]){
                count ++;
            }
        }
        if(count > A.length/2){
            return index;
        } else {
            return -1;
        }
    }

}