/*
Write a function to find the longest common prefix string amongst an array of strings.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";

        for(int i=0;i<strs[0].length();i++){
            int j=1;
            while (j<strs.length ){
                //ab ,abc when strs[0] is the shortest;
                if (i==strs[j].length()) return strs[0].substring(0,i);
                //check next one;
                if(strs[j].charAt(i)==strs[0].charAt(i))j++;
                else return strs[0].substring(0,i);
            }

        }
        return strs[0];

    }
}
