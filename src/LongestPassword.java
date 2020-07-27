public class LongestPassword {
    
}
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        String[] memo = S.split("\\s+");
        //System.out.println(Arrays.toString(memo));
        int max = -1;
        for(String x : memo){
            if(isValid(x)){
                //System.out.println(x);
                if(x.length()>max){
                    max = x.length();
                }
            }
        }
        return max;
        
    }
    boolean isValid(String s){
        String regex = "[a-zA-Z0-9]+";
        if (!s.matches(regex)){
            return false;
        }
        int count = 0;
        for(int i = 0;i<s.length();i++){
            if( '0'<= s.charAt(i)  && s.charAt(i) <= '9'){
                count += 1;
            }
        }
        if (count % 2 == 0){
            return false;
        }
        if( (s.length() - count)% 2 == 1){
            return false;
        }
        return true;
        
    }
}