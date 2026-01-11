import javax.xml.transform.Source;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ElevenJanuary {
    public static long fact(int n) {
        if (n == 0) {
            return 1;
        }
//        long fn1 = fact(n-1);
        return n * fact(n - 1);
    }

    public static int sumOfNNaturalNo(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = n + sumOfNNaturalNo(n - 1);
        return sum;
    }

    public static int fibonacciNo(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int f1 = fibonacciNo(n - 1);
        int f2 = fibonacciNo(n - 2);
        int sum = f1 + f2;
        return sum;
    }

    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int[] choclateProblem(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index != nums.length) {
            nums[index++] = 0;
        }
        return nums;
    }

    public static int countSunday(String day, int n) {
        int idx = 0;
        String[] days = {"sun", "mon", "tue", "wed", "thu", "fri", "sat"};
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(day)) {
                idx = i;
                break;
            }
        }
        int sunday = (7 - idx) % 7;
        int count = 0;
        if (sunday < n) {
            count = 1;
            count = count + (n - sunday) / 7;
        }
        return count;
    }

    public static void sortOnRisk(int[] nums) {
        divide(nums, 0, nums.length - 1);
    }

    private static void divide(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(nums, start, mid);
        divide(nums, mid + 1, end);
        conquer(nums, start, mid, end);
    }

    private static void conquer(int[] nums, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int x = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                merged[x++] = nums[i++];
            } else {
                merged[x++] = nums[j++];
            }
        }
        while (i <= mid) {
            merged[x++] = nums[i++];
        }
        while (j <= end) {
            merged[x++] = nums[j++];
        }
        for (int a = 0, b = start; a < merged.length; a++, b++) {
            nums[b] = merged[a];
        }
    }

    public static int countElements(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            }
        }
        return count;
    }

    public static int prodOfAllDigits(int n) {
        int prod = 1;
        while (n != 0) {
            if (prod == 0) {
                prod = 1;
            }
            int digit = n % 10;
            prod = prod * digit;
            n = n / 10;
        }
        return prod;
    }

    //  aqua -> a, Black -> b  colours
    public static int countMaxColourInOneSet(String str, int l) {
        int count;
        int maxCount = 0;
        for (int i = 0; i < str.length(); i += l) {
            count = 0;
            for (int j = i; j < i + l && j < str.length(); j++) {
                if (str.charAt(j) == 'a') {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static BigInteger factorail(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorail(n - 1));
    }

    public static BigInteger permutations(int n) {
        return BigInteger.valueOf(2).multiply(factorail(n - 1));
    }

    public static void main(String[] args) {
//        System.out.println(fact(25));
//        System.out.println(sumOfNNaturalNo(100));
//        System.out.println(fibonacciNo(25));
//        System.out.println(isSorted(new int[]{4, 5, 6, 7, 9, 8}, 0));
////        System.out.println(choclateProblem(new int[]{4,5,0,1,9,0,5,0}));
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter The size of array");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(choclateProblem(arr)));
//        System.out.println("Total Sunday: " + countSunday("tue", 6));
//        String day = sc.next().toLowerCase();
//        int n1 = sc.nextInt();
//        System.out.println(countSunday(day, n1));
//        int size = sc.nextInt();
//        int[] baggage = new int[size];
//        for (int i = 0; i < baggage.length; i++) {
//            baggage[i] = sc.nextInt();
//        }
//        sortOnRisk(baggage);
//        for (int i = 0; i < baggage.length; i++) {
//            System.out.print(baggage[i] + " ");
//        }
//        int n2 = sc.nextInt();
//        int[] Elements = new int[n2];
//        for (int i = 0; i < Elements.length; i++) {
//            Elements[i] = sc.nextInt();
//        }
//        System.out.println(countElements(Elements));
//        int n = sc.nextInt();
//        System.out.println(prodOfAllDigits(n));
//        String s = sc.next(); //aaaaaabbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbcacccccccccccccacacacaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
//        System.out.println(countMaxColourInOneSet(s, 40));
        int n = sc.nextInt();
        System.out.println(permutations(n));
    }
}
