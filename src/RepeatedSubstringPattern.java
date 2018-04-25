/*
459. Repeated Substring Pattern
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern2(String s) {
        for(int i=0;i<s.length()/2 ;i++){
            if(s.length()%(i+1)==0){
                String temp=s.substring(0,i+1);//the length is i+1:[0,...,i]
                int j=i+1;
                //s.startsWith(temp,j) the first character is s[j] to compare with;
                while(j<=s.length() && s.startsWith(temp,j))j+=i+1;
                if(j==s.length())
                    return true;
            }

        }
        return false;

    }

    public boolean repeatedSubstringPattern(String s) {


        for (int i = 0; i < s.length() / 2; i++) {
            while (s.length() % (i + 1) != 0) i++; //make the loops as less as possible;
            if (i >= s.length() / 2) return false;

            String temp = s.substring(0, i + 1);//the length is i+1:[0,...,i]
            int j = i + 1;
            //s.startsWith(temp,j) the first character is s[j] to compare with;
            while (j <= s.length() && s.startsWith(temp, j)) j += i + 1;
            if (j == s.length())
                return true;
        }
        return false;
    }
}
