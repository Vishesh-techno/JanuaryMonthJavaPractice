import java.util.HashMap;
import java.util.Map;

public class SixJanuary {
    public static int lengthOfLongestSubString(String str) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < str.length()) {
            char currChar = str.charAt(right);

            if (map.containsKey(currChar)) {
                int currIdx = map.get(currChar);

                if (currIdx >= left) {
                    left = currIdx + 1;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
            map.put(currChar, right);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println(lengthOfLongestSubString(str));
    }
}
