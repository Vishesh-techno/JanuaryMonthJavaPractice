import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        System.out.println(fizzBuzz(50));
        System.out.println(powerOfThree(729));
    }
}
