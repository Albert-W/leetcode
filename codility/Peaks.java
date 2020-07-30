public class Peaks {
    
}
class Solution {
    //O(N * log(log(N)))
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length< 3){
            return 0;
        }
        int[] isPeek = new int[A.length];
        for(int i = 1;i<A.length -1;i++){
            if(A[i]> Math.max(A[i-1],A[i+1])){
                isPeek[i] =isPeek[i-1] +1;
            } else {
                isPeek[i] =isPeek[i-1];
            }
        }
        isPeek[A.length-1] = isPeek[A.length-2];
        //System.out.println(Arrays.toString(isPeek));
        
        
        // int pace = 1;
        for(int pace = 1;pace <= A.length;pace ++){
            if(A.length % pace != 0){
                continue;
            }
            int j;
            // 判断第一段
            if(isPeek[pace-1]==0){
                continue; 
            }

            // 判断剩余的
            for(j =2 *  pace;j<=A.length;j+=pace){
                
                // 段首 与 前一段 段首比较；只能两段比较
                if(isPeek[j-1] == isPeek[j-pace-1]) {
                    break;
                }
            }
            // 完整匹配，成功
            if(j > A.length ){
                return A.length/pace;
            }
            
        }
        return 0;
    }
}