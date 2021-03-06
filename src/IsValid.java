/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class IsValid {
    //
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            if(s.charAt(i)==')' ){
                if(stack.empty()||stack.peek()!='(')
                    return false;
                else
                    stack.pop();
            }
            if(s.charAt(i)=='}' ){
                if(stack.empty()||stack.peek()!='{')
                    return false;
                else
                    stack.pop();
            }
            if(s.charAt(i)==']' ){
                if(stack.empty()||stack.peek()!='[')
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.empty();

    }

    //this is not correct.
    public boolean isValid2(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)))
                set.remove(s.charAt(i));
            else
                set.add(s.charAt(i));
        }
        return s.length() == 0;
    }

    //"([)]"
    public boolean isValid3(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('(',0);
        map.put(')',0);
        map.put('{',0);
        map.put('}',0);
        map.put('[',0);
        map.put(']',0);
        for(int i =0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
        }
        return map.get('(') == map.get(')') &&
            map.get('{') == map.get('}') &&
            map.get('[') == map.get(']');

    }



//    enum parentheses1{
//        ONE('(',1);
//        private Character c;
//        private Integer i;
//        private parentheses1(Character c,Integer i){
//            this.c = c;
//            this.i =i;
//        }
//
//
//    }


}
