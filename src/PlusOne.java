import java.util.Arrays;

/*
66. Plus One
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 */
public class PlusOne {
    //其实可以先判断，后执行；充分利用己知条件；
    //尽早return;
    public int[] plusOne(int[] digits) {

        for(int i=digits.length-1;i>=0 ;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            } else digits[i]=0;
        }
        int[] newdigits= new int[digits.length+1];
        newdigits[0]=1;
        return newdigits;

    }

    //先加一，后判断结果；
    public int[] plusOne2(int[] digits) {
        //flag表示产生进位；
        int flag=0;
        int end=digits.length-1;
        digits[end]++;

        while (end>0 && digits[end]==10){
            digits[end]=0;
            end--;
            digits[end]++;
        }
        if(digits[end]==10){
            digits[end]=0;
            int[] result= new int[digits.length+1];
            result[0]=1;
            for(int i=1;i<result.length;i++){
                result[i]=digits[i-1];
            }
            return result;
        }
        return digits;

    }
}
