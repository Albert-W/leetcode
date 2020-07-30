public class Flags{}
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length<3){
            return 0;
        }
        int[] isPeek = new int[A.length];
        for(int i = 1;i<A.length-1;i++){
            if(A[i] > Math.max(A[i-1],A[i+1])){
                isPeek[i] = 1;
            }
        }
        //System.out.println(Arrays.toString(isPeek));
        // check is it possible;
        int beg = 1;
        // 首尾都插上flag时， 会+1；
        int end = (int)Math.sqrt(A.length) + 1;
        
        
        // int flags = 0;
        while(beg <= end){
            int mid = (beg + end)/ 2;
            if(check(mid, isPeek, A)  ){
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
            
        }

        // 判断最后一次是否满足
        if(check(beg, isPeek, A)){
            return beg;
        } else {
            return beg - 1;
        }

        // return beg ;
        
    }
    
    boolean check(int k, int[] isPeek, int[]A){
        int pos = 0;
        int flags = k;
        while(pos< A.length && flags > 0 ){
            if(isPeek[pos] == 1){
                flags -= 1;
                pos += k;
            } else{
                pos += 1;
            }
        }
        return flags == 0;
    }
}