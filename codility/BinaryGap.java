/**
 * Codility
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

* For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
 *  
 * 
 */

public class BinaryGap {
    
}

class Solution {
    public int solution(int N) {
        // write your code in Java SE 8
        int[] record = new int[32];
        for(int i = 0 ;i<32;i++){
            int mask = 1 << i;
            if( (N & mask) != 0 ){
                record[i] = 1;
            }
        }
        //System.out.println(Arrays.toString(record));
        int start = 32;
        int end = 0;
        int max = 0;

        for(int i = 0 ;i< 31;i++){
            if(record[i]== 1 && record[i+1]==0){
                start = i;
            }
            if(record[i]== 0 && record[i+1] ==1 ){
                end = i;
            }
            if(end - start > max){
                max = end-start;
            }
            
        }
        return max;
        
    }
}