import java.util.*;
public class StoneWall {
    public static void main(String[] args) {
        int[] a = {2, 5, 1, 4, 6, 7, 9, 10, 1};
        int r = new Solution().solution(a);
        System.out.println(r);
    }
    
}

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] H) {
        // write your code in Java SE 8
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        // stack.push(H[0]);
        for(int i:H){
            if(stack.isEmpty()){
                stack.push(i);
            } else {
                // 比当前头更高，则入栈待处理
                if(i>stack.peek()){
                    stack.push(i);
                // 比当前低，处理它，并处理它之前的item    
                } else while(!stack.isEmpty() && i<stack.peek()){
                    sum += 1;
                    stack.pop();
                } 
                // 如果不相等，则入栈。相等不处理。 
                if(stack.isEmpty() ||  i != stack.peek()){
                    stack.push(i);
                } 
            
            }
            //System.out.println(stack);
        }
        sum += stack.size();
        return sum;
    }
}