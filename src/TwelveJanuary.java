import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwelveJanuary {
    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                str = "FizzBuzz";
                res.add(str);
            } else if (i % 3 == 0) {
                str = "Fizz";
                res.add(str);
            } else if (i % 5 == 0) {
                str = "Buzz";
                res.add(str);
            } else {
                str = i + "";
                res.add(str);
            }
        }
        return res;
    }

    public static boolean powerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public static int countPrime(int n) {
        boolean[] used = new boolean[n];
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (used[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += i) {
                used[j] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                count++;
            }
        }
        return count;
    }

    public static int romanToInteger(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int tot = 0;
        for (int i = 0; i < s.length(); i++) {
            int currVal = map.get(s.charAt(i));
            if (i < s.length() - 1 && currVal < map.get(s.charAt(i))) {
                tot -= currVal;
            } else {
                tot += currVal;
            }
        }
        return tot;
    }

    public static void primeFactors(int n) {
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n /= i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(fizzBuzz(50));
        System.out.println(powerOfThree(729));
        System.out.println(countPrime(10));
        primeFactors(11);
        System.out.println();
        System.out.println(romanToInteger("MCMMMMMMMMMMMMMMMMMMMMMXVIIICDDDLLLLLV"));
    }
}
