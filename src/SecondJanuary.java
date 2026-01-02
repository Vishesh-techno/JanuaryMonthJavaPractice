import java.util.HashSet;
import java.util.Set;

public class SecondJanuary {
    public static int sumOfSquareOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;

            sum = sum + (digit * digit);
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }

            set.add(n);

            n = sumOfSquareOfDigits(n);
        }
        return true;
    }

    public static void main(String[] args) {
        if (isHappy(19)) {
            System.out.println("The Given Number is Happy");
        } else {
            System.out.println("The Given Number is Not Happy");
        }
    }
}
