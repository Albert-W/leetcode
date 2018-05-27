/*
3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
//Hash Table;Two Pointers;String;
public class LengthOfLongestSubstring {
    /**
     * @param s the target string.
     * @return the length of the longest substring
     * <p>
     * method: use int[256] as a map to check whether the character exists or not.
     * use while() to reduce the time complexity to O(n);
     */
    public int lengthOfLongestSubstring_1(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int count = 0;
            byte[] map = new byte[256];
            while (j < s.length() && map[s.charAt(j)] == 0) {

                count++;
                map[s.charAt(j)] = 1;
                j++;
            }
            if (count > length) length = count;
        }
        return length;

    }

    public int lengthOfLongestSubstring_2(String s) {
        int length = 0;
        byte[] map = new byte[256];
        int i = 0, j = 0;
        int count = 0;
        for (; i < s.length(); i++) {

            while (j < s.length() && map[s.charAt(j)] == 0) {
                count++;
                map[s.charAt(j)] = 1;
                j++;
            }
            if (count > length) length = count;
            count--;
            map[s.charAt(i)] = 0;
        }
        return length;
    }

    //i 是子链头，j是子链尾。
    //已经出现过的通过byt[] map记录
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        byte[] map = new byte[256];
        int i = 0, j = 0;
        int count = 0;

        while (i < s.length() && j < s.length()) {
            if(map[s.charAt(j)]==0){
                count++;
                map[s.charAt(j)] = 1;
                j++;
            } else {
                if (count > length) length = count;
                count--;
                map[s.charAt(i)] = 0;
                i++;
            }
        }
        if (count > length) length = count;
        return length;
    }
}
