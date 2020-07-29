import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Brackets {
    
}
class Solution {
    // ???????
    public int solution(String S) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return 0;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return 0;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                        return 0;
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }



    // 自己的
    // 通过
    public int solution_p(String S) {
        // write your code in Java SE 8
        Map<Character,Character> m = new HashMap<>();
        m.put('(', ')');
        m.put('[', ']');
        m.put('{', '}');

        Deque<Character> d = new ArrayDeque<>();

        for(int i = 0 ;i<S.length();i++){
            if(m.containsKey(d.peek()) &&   S.charAt(i) == m.get( d.peek())){
                d.pop();
            } else {
                d.push(S.charAt(i));
            }
        }
        if( d.size() == 0){
            return 1;
        } else {
            return 0;
        }

    }
}
