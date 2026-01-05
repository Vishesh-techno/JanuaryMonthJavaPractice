import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fivejanuary {
    public static int fourSumCountII(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                int key = i + j;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int key = -1 * (i + j);
                count = count + map.getOrDefault(key, 0);
            }
        }
        return count;
    }

    public static int numJewelsInStones(String jewels, String stones) {
        long startTime = System.nanoTime();
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
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time: " + duration);
        return count;
    }

    public static int numJewelsInStonesII(String jewels, String stones) {
        long startTime = System.nanoTime();
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
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("time: " + duration);
        return count;
    }

    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        System.out.println(numJewelsInStones(jewels, stones));
        System.out.println(numJewelsInStonesII(jewels, stones));

        int[] nums1 = {4, 5, 6, 7};
        int[] nums2 = {6, 7, 5, 4};
        int[] nums3 = {3, 8, 5, 4};
        int[] nums4 = {0, 1, 2, 3, 4};

        int res = fourSumCountII(nums1, nums2, nums3, nums4);
        System.out.println(res);
    }
}
