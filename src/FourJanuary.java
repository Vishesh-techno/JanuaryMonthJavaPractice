import java.util.*;

public class FourJanuary {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<List<String>>();

        for (String str : strs) {
            char[] ch = str.toCharArray(); // step1 - convert string to array
            Arrays.sort(ch); // sort string array

            String key = new String(ch); // declare a sorted string as a key

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>()); // if not exist add key and value as empty list
            }

            map.get(key).add(str); // add value in list
        }

        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            res.add(e.getValue()); // add value in res from map
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> res = groupAnagrams(strs);

        System.out.println(res);
    }
}
