import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Dominator {
    public static void main(String[] args) {
        String s = "hello";
        StringBuilder sb = new StringBuilder("world");
        String s1 = sb.substring(1); //orld
        String s2 = sb.substring(2, 4);//rl
        String s3 = sb.toString(); //world

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        sb.setLength(10);
        sb.append('e');
        System.out.println(sb);
        System.out.println(sb.length());
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