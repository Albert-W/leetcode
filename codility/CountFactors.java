public class CountFactors {

    public static void main(String[] args) {
        int i = 2;
        double d = 2;
        System.out.println( i ==d );
    }
    
}
class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int count = 0;
        for(int i = 1; i<= Math.sqrt(N);i++){
            if(N % i == 0){
                if( i * i == N){
                    count +=1;
                } else {
                    count +=2;
                }
            }
        }
        return count;
    }
}