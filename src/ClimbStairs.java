/*
70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

public class ClimbStairs {
    //iteration
    public int climbStairs(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        int a=1,b=2,c=0;
        for(int i=2;i<n;i++){

            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }


    //Dynamic Programming & recurrence
    //n=44, Time Limit Exceeded
    public int climbStairs2(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 2;
        return climbStairs2(n-1)+climbStairs2(n-2);

    }


}
