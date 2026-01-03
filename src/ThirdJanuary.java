import java.util.*;

public class ThirdJanuary {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if (!map1.containsKey(ss) && !map2.containsKey(tt)) {
                map1.put(ss, tt);
                map2.put(tt, ss);
            } else if (map1.get(ss) == null) {
                return false;
            } else if (map2.get(tt) == null) {
                return false;
            } else if (map1.get(ss) != tt && map2.get(tt) != ss) {
                return false;
            }
        }
        return true;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
                list.add(num);
            }
        }

        int[] arr = new int[list.size()];
        int k = 0;
        for (int num : list) {
            arr[k] = num;
            k++;
        }
        return arr;
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "lee"));

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 1};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }
}
