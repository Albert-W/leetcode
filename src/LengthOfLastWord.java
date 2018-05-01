/*
58. Length of Last Word
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length()==0)return 0;
        char[] chars=s.toCharArray();
        int i=chars.length-1;
        //while 循环越界；
        while(i>=0 && chars[i]==' ')i--;
        int count=0;
        while(i>=0 && chars[i--]!=' '){
            count++;
        }
        return count;

    }
}
