/*
69. Sqrt(x)
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */
public class MySqrt {
    //binary search method
    //multiply and sum need to avoid overflow.
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        if(x==1) //divide by zero.
            return 1;
        int start=0,end=x;
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;

            if(mid==x/mid)
                return mid;
            //mid^2<x, mid can't be smaller.
            if(mid<x/mid){
                start=mid+1;
            }else {
                //mid can't be greater.
                end=mid-1;
            }
        }
        return end;
    }

    //O(n) solution.
    public int mySqrt2(int x) {
        if(x==0)
            return 0;
        if(x<=3)//x=1,2,3
            return 1;
        //x=4,5
        for(int i=0;i<=x/2+1;i++){
            if(i*i==x)
                return i;

            //i*i > Integer.MAX_VALUE;
            if(i*i>x||i*i<0)
                return i-1;
        }
        return 0;
    }
}
