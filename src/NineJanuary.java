import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NineJanuary {
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

    /* public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubSetII(1, n, new ArrayList<>(), res, k);
        return res;
    }

    private static void generateSubSetII(int start, int n, List<Integer> curr, List<List<Integer>> res, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            generateSubSetII(i + 1, n, curr, res, k);
            curr.removeLast();
        }
    }
*/
    public static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutations(nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void generatePermutations(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            generatePermutations(nums, used, curr, res);
            used[i] = false;
            curr.removeLast();
        }
    }

    public static List<String> permutationsABC(int n1, int n2, int n3) {
        List<String> res = new ArrayList<>();
        generatePermutationsABC(n1, n2, n3, new StringBuilder(), res);
        return res;
    }

    private static void generatePermutationsABC(int a, int b, int c, StringBuilder curr, List<String> res) {
        if (a == 0 && b == 0 && c == 0) {
            res.add(curr.toString());
            return;
        }
        if (a > 0) {
            curr.append('a');
            generatePermutationsABC(a - 1, b, c, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (b > 0) {
            curr.append('b');
            generatePermutationsABC(a, b - 1, c, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (c > 0) {
            curr.append('c');
            generatePermutationsABC(a, b, c - 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public static int sumOfArray(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void rotateArrayByKElements(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotate(nums, 0, n - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);
    }

    public static void rotate(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static double avgOfArray(int[] nums, int k) {
        int n = nums.length;
        double sum = 0, avg = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        avg = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            avg = Math.max(sum, avg);
        }
        return avg / k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(subset(nums));
        System.out.println(combination(3, 2));
        System.out.println(permutation(nums));
        System.out.println(permutationsABC(2, 1, 1));
        System.out.println(sumOfArray(nums));
        rotateArrayByKElements(nums, 45);
        System.out.println(Arrays.toString(nums));
        System.out.println(avgOfArray(nums, 2));
    }

}
