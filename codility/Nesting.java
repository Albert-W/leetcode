import java.util.ArrayDeque;
import java.util.Deque;

public class Nesting {
    
}
class Solution {
    public int solution(String S) {
        // write your code in Java SE 8
        Deque<Character> stack = new ArrayDeque<>();
        for(Character c : S.toCharArray()){
            switch (c){
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.isEmpty()){
                        stack.pop();
                    } else {
                        return 0;
                    }    
            }
            
        }
        return stack.isEmpty()? 1:0;

    }
}