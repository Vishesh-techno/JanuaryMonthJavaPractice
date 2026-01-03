import java.util.HashMap;
import java.util.Map;

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

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "lee"));
    }
}
