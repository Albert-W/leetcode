import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;

public class Fish {
    
}
class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8

        // Stack 只存向下游的鱼。
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for(int i=0;i<A.length;i++){
            // 向下游则入栈
            if(B[i]==1){
                stack.push(A[i]);
                // 向上流则与栈中元素比较
            } else{
                while(!stack.isEmpty() && stack.peek() < A[i]){
                    stack.pop();
                } 
                if(stack.isEmpty()){
                    sum += 1;
                }
            }
            System.out.println(stack);

        }
        sum += stack.size();
        return sum;

    }
}