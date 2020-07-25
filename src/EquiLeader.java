public class EquiLeader {
    
}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        // find the overall leader.
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
        int leader = 0;
        count = 0;
        for(int i :A){
            if(i == A[index]){
                count ++;
            }
        }
        if(count > A.length/2){
            leader = A[index];
        } else {
            return 0;
        }
        
        
        // count the equi leader. 
        int res = 0; //result
        int num = 0; // numder of D
        for(int j=0;j<A.length;j++){
            if(A[j] == leader){
                num += 1;
            }
            
            if( num > (j+1)/2 && (count-num) > (A.length - j -1)/2 ){
                res += 1;
            }
        }
        return res;
        
    }
}