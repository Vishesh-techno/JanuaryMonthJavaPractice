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
    }
}
