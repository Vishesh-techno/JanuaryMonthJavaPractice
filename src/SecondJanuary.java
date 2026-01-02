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

    public static boolean isHappyII(int n) {
        if (n == 1 || n == 7) {
            return true;
        } else if (n < 10) {
            return false;
        } else {
            int sum = 0;
            while (n != 0) {
                int temp = n % 10;
                sum = sum + (temp * temp);
                n = n / 10;
            }
            return isHappyII(sum);
        }
    }

    public static boolean isHappyIII(int n) {
        int slow = n, fast = n;

        while (true) {
            slow = sumOfSquareOfDigits(slow);
            fast = sumOfSquareOfDigits(sumOfSquareOfDigits(fast));

            if (fast == 1) {
                return true;
            }

            if (fast == slow) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        if (isHappy(19)) {
            System.out.println("The Given Number is Happy");
        } else {
            System.out.println("The Given Number is Not Happy");
        }
        if (isHappyII(15)) {
            System.out.println("The Given Number is Happy");
        } else {
            System.out.println("The Given Number is Not Happy");
        }
        if (isHappyIII(9)) {
            System.out.println("The Given Number is Happy");
        } else {
            System.out.println("The Given Number is Not Happy");
        }
    }
}
