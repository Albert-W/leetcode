import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    /**
     * @param s the target string.
     * @return the length of the longest substring
     * <p>
     * method: use int[256] as a map to check whether the character exists or not.
     */
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int count=0;
            byte[] map = new byte[256];
            while (j < s.length() && map[s.charAt(j)] == 0) {

                count++;
                map[s.charAt(j)] = 1;
                j++;
            }
            if(count>length)length=count;
        }
        return length;

    }
}
