/*
168. Excel Sheet Column Title
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
 */
//math;
public class ConvertToTitle {
    //0ms;
    public String convertToTitle(int n) {
        String sb = "";
        char c = '0';
        while (n != 0) {
            if (n % 26 == 0) {
                c = 'Z';
                n -= 26;
            } else c = (char) (n % 26 - 1 + 'A');
            sb = c + sb;
            n = n / 26;
        }
        return sb;

    }

}
