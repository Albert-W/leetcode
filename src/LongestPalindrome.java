/*
5. Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int sum = 1;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            int j = 1;

            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }
            if (2 * j - 1 > sum) {
                sum = 2 * j - 1;
                result = s.substring(i - j + 1, i + j);
            }
            j = 0;
            while (i - j >= 0 && i + j + 1 < s.length() && s.charAt(i - j) == s.charAt(i + j + 1)) {
                j++;
            }
            if (2 * j > sum) {
                sum = 2 * j;
                result = s.substring(i - j + 1, i + j + 1);
            }


        }
        return result;
    }
}
