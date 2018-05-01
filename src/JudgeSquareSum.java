/*
633. Sum of Square Numbers
Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
 */
public class JudgeSquareSum {
    public boolean judgeSquareSum(int c) {
        if(c==0)return true;//as the Data base demand;
        int first=0,second=(int)Math.sqrt(c);
        //return as soon as possible;
        while (first<=second){
            if(first*first+second*second==c)
                return true;
            if(first*first+second*second>c){
                second--;
            } else first++;
        }
        return false;

    }
}
