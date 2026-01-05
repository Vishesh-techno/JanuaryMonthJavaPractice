import java.util.HashMap;
import java.util.Map;

public class Fivejanuary {
//    public static int numJewelsInStones(String jewels, String stones){
//        Map<Character, Integer> map = new HashMap<>();
//
//        char[] ch = jewels.toCharArray();
//
//        for(int i=0; i<ch.length; i++){
//            if(map.containsKey(ch[i])){
//                map.put(ch[i], map.get(ch[i]) + 1);
//            }else{
//                map.put(ch[i], 1);
//            }
//        }
//
//        int count = 0;
//
//        char[] ch1 = stones.toCharArray();
//
//        for(int i=0; i<ch1.length; i++){
//            if(map.containsKey(ch1[i])){
//                map.put(ch1[i], map.get(ch1[i]) + 1);
//            }else{
//                map.put(ch1[i], 1);
//            }
//        }
//        return count;
//    }

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
