import java.util.HashMap;

public class TwentyNineJanuary {
    public static boolean isSubset(int[] a, int[] b) {
        if (b.length > a.length) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : b) {
            if (!map.containsKey(i) || map.get(i) == 0) {
                return false;
            }
            map.put(i, map.get(i) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};

        System.out.println(isSubset(a, b));
    }
}
