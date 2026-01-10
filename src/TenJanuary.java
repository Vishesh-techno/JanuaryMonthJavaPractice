import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TenJanuary {
    public static int secondLargest(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (first > nums[i] && nums[i] > second) {
                second = nums[i];
            }
        }
        return second;
    }

    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubset(0, nums, new ArrayList<>(), res);
        return res;
    }

    private static void generateSubset(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            generateSubset(i + 1, nums, curr, res);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combination(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        generateCombination(1, n, new ArrayList<>(), res, k);
        return res;
    }

    private static void generateCombination(int idx, int n, List<Integer> curr, List<List<Integer>> res, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i <= n; i++) {
            curr.add(i);
            generateCombination(i + 1, n, curr, res, k);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutaion(nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void generatePermutaion(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            generatePermutaion(nums, used, curr, res);
            used[i] = false;
            curr.removeLast();
        }
    }

    public static String reverseAString(String s) {
        String revString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            revString += s.charAt(i);
        }
        return revString;
    }

    public static String revString(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;

        while (start <= end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }

    public static boolean checkPalindrome(String str) {
        String s = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            char start = words[i].charAt(0);
            char end = words[i].charAt(words[i].length() - 1);
            if ((start == 'a' || start == 'e' || start == 'i' || start == 'o' || start == 'u') && (end == 'a' || end == 'e' || end == 'i' || end == 'o' || end == 'u')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of Array: ");
        n = sc.nextInt();
        System.out.println("Enter the Elements of Array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("The Second Largest Element is: " + secondLargest(arr));

        String str = "Vishesh";
        System.out.println("\"" + str + "\"");

        System.out.println("The Subsets are: " + subset(arr));
        System.out.println("The Combinations are: " + combination(3, 2));
        System.out.println("The Permutations are: " + permutation(arr));
        System.out.print("Enter a Single word: ");
        String s = sc.next();
        System.out.println("Original String: " + s);
        System.out.println("Reversed String: " + reverseAString(s));
        System.out.println("Reversed String: " + revString(s));
        if (checkPalindrome(s)) {
            System.out.println("This is a Palindrome");
            System.out.println(revString(s));
        } else {
            System.out.println("This is not a Palindrome");
        }

        System.out.println("the no. of vowel in a given string array: " + vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
    }
}
