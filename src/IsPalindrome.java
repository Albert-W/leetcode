/*
9. Palindrome Number
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?
 */
public class IsPalindrome {
    //x=12321->1232->123->12
    //t=0->1->12->123
    //x==t/10;
    //因为中间位是相重了。
    public boolean isPalindrome(int x) {
        if(x==0)return true;
        if(x%10==0||x<0)return false;
        int t=0;
        //half of the loop.
        while(x>t){
            t=t*10+x%10;
            x/=10;
        }
        //example: 12321
        return x==t||x==t/10;

    }
}
