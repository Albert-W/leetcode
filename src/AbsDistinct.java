import java.util.*;
public class AbsDistinct {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        l.subList(fromIndex, toIndex)
    }
}

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> s = new HashSet<>();
        for(int i:A){
            if(i>0){
                s.add(-i);
            } else {
                s.add(i);
            }
        }
        return s.size();
        
    }
}