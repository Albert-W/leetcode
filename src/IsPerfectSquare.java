/*
367. Valid Perfect Square
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 */
public class IsPerfectSquare {
    //binary search method.
    public boolean isPerfectSquare(int num) {
        if(num==0)return false;
        if(num==1)return true;
        int start=0,mid=0,end=num;
        while(start<=end){
            mid=start+(end-start)/2;
            if(mid*mid==num)return true;//2*2<5;
            //if(mid==num/mid)return true;//2=5/2; this is the difference;

            //2=5/2, so ‘=’is important;
            if(mid<=num/mid){
                start=mid+1;
            } else {
                end=mid-1;
            }

        }
        return false;
    }
}
