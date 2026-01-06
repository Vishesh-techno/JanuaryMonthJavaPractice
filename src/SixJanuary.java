import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public static int lengthOfLongestSubStringII(String str) {
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < str.length()) {
            char currChar = str.charAt(right);

            while (set.contains(currChar)) {
                set.remove(currChar);
                left++;
            }
            set.add(currChar);
            maxLen = Math.max(maxLen, right - left + 1);
//            map.put(currChar, right);
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println(lengthOfLongestSubString(str));
        System.out.println(lengthOfLongestSubStringII(str));
    }
}
