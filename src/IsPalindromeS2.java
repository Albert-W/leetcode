/*
680. Valid Palindrome II
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class IsPalindromeS2 {
    //可忽略的次数，即递归的次数
    int count = 2;//添加static 后再线编译故障，可能因为重复编译；

    //当需要遍历时，转化为char[]
    public boolean validPalindrome(String s) {
        char c[] = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            if (c[i] != c[j]) {
                return validPalindrome(c, i + 1, j) || validPalindrome(c, i, j - 1);
            }
            i++;
            j--;
        }
        return true;

    }

    boolean validPalindrome(char[] c, int i, int j) {
        while (i < j) {
            if (c[i] != c[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome3(String s) {
        int i = 0, j = s.length() - 1;

        char start, end;
        while (i < j) {
            start = s.charAt(i);
            end = s.charAt(j);
            //如果一次机会用完
            if (start != end && count == 0) {
                return false;
            }
            //如果还有机会
            if (start != end && count > 0) {
                count--;
                //i->j-1 || i+1->j;
                return validPalindrome3(s.substring(i, j)) || validPalindrome3(s.substring(i + 1, j + 1));
            }

            //如果相等
            i++;
            j--;
        }
        return true;
    }


    //Time Limit Exceeded
    public boolean validPalindrome2(String s) {
        int i = 0, j = s.length() - 1;
        boolean b = false;
        for (int k = 0; k < s.length(); k++) {
            b = validPalindrome(s, 0, s.length() - 1, k);
            if (b == true) {
                return true;
            }


        }
        return b;
    }

    //如果从i到j对称，true, O(n);
    boolean validPalindrome(String s, int i, int j, int k) {
        char start, end;
        while (i < j) {
            if (i == k) i++;
            if (j == k) j--;
            start = s.charAt(i);
            end = s.charAt(j);

            if (start != end) return false;
            i++;
            j--;

        }
        return true;
    }
}
