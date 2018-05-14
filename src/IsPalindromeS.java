/*
125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */
public class IsPalindromeS {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char start, end;
        while (i < j) {
            start = charMap(s.charAt(i));
            end = charMap(s.charAt(j));
            if (start == 0) i++;
            if (end == 0) j--;
            if (start != 0 && end != 0) {
                if (start != end) return false;
                i++;
                j--;
            }
        }
        return true;

    }

    char charMap(char c) {
        //小写和字母不变
        if (c >= 97 && c <= 122 ||
            (c >= 48 && c <= 57)) return c;
        //大写变为小写
        if (c >= 65 && c <= 90) return (char) (c + 32);
        //其他情况
        return 0;
    }


    public boolean isPalindrome2(String s) {
        StringBuilder t = preprocess(s);
        //翻转后的StringBuilder 两者不等；
        StringBuilder rt = new StringBuilder(t).reverse();
//        boolean b= rt.equals(t);
        //String()两者相等
        boolean b = rt.toString().equals(t.toString());
        return b;

    }

    StringBuilder preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                char t = (char) (s.charAt(i) + 32);
                sb.append(t);
            }
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122 ||
                (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                sb.append(s.charAt(i));
            }
        }

        return sb;
    }


}
