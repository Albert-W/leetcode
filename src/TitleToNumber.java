/*
171. Excel Sheet Column Number
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
//math
public class TitleToNumber {
    //6ms;
    public int titleToNumber2(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int len = chars.length - 1;
        for (int i = 0; i <= len; i++) {
            res = res * 26 + chars[i] - 'A' + 1;

        }
        return res;

    }


    //7ms
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int len = chars.length - 1;
        for (int i = len; i >= 0; i--) {
            res += (chars[i] - 'A' + 1) * Math.pow(26, len - i);

        }
        return res;

    }
}
