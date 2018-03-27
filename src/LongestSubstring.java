import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
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
