import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/*
7. Reverse Integer
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


 */
public class Reverse {
    public int reverse2(int x) {
        //Math.abs(Integer.MIN_VALUE:-2147483648) returns Integer.MIN_VALUE
        if(x==Integer.MIN_VALUE)
            return 0;
        if(x<0)return -1*reverse2(Math.abs(x));

        ArrayList<Integer> a=new ArrayList<>();
        while(x!=0){
            a.add(x%10);
            x=x/10;
        }
        //String s=a.toString();
        //int result = Integer.parseInt(s);
        long result=0;
        for(int i=0;i<a.size();i++){
            result *=10;
            result += a.get(i);
        }
        //if x =-1147483648 the reverse is bigger then Integer.MAX_VALUE
        if(result>Integer.MAX_VALUE)
            return 0;

        return (int)result;
    }

    public int reverse(int x) {
        if(x==Integer.MIN_VALUE)
            return 0;
        if(x<0)return -1*reverse2(Math.abs(x));
        /*
        the core part.
        within one loop reverse is done.
         */
        long result =0;
        while(x!=0){
            result *=10;
            result += x%10;
            x=x/10;
        }
        //if x =-1147483648 the reverse is bigger then Integer.MAX_VALUE
        if(result>Integer.MAX_VALUE)
            return 0;

        return (int)result;

    }

}

