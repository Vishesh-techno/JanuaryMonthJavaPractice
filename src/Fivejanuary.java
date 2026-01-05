import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fivejanuary {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int count = 0;

        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        for (char ch : stones.toCharArray()) {
            if (set.contains(ch)) {
                count++;
            }
        }
        return count;
    }

    public static int numJewelsInStonesII(String jewels, String stones) {
        char[] ch = jewels.toCharArray();
        char[] ch1 = stones.toCharArray();
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch1.length; j++) {
                if (ch[i] == ch1[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStonesII(jewels, stones));
    }
}
