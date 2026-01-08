import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightJanuary {
    public static List<List<Integer>> permutations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generatePermutaions(nums, res, used, new ArrayList<>());
        return res;
    }

    private static void generatePermutaions(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            generatePermutaions(nums, res, used, curr);
            used[i] = false;
            curr.removeLast();
        }
    }

    public static List<List<Integer>> uniquePermutations(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        generateUniquePermutations(nums, res, used, new ArrayList<>());
        return res;
    }

    private static void generateUniquePermutations(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            curr.add(nums[i]);
            generateUniquePermutations(nums, res, used, curr);
            used[i] = false;
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        generateSum(0, nums, new ArrayList<>(), res, target);
        return res;
    }

    private static void generateSum(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            generateSum(i + 1, nums, curr, res, target - nums[i]);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        generateSumSubset(0, nums, new ArrayList<>(), res, target);
        return res;
    }

    private static void generateSumSubset(int idx, int[] nums, List<Integer> curr, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;
        for (int i = idx; i < nums.length; i++) {
//            if(i > idx && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            generateSum(i, nums, curr, res, target - nums[i]);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
        System.out.println(permutations(nums));
        System.out.println(uniquePermutations(nums));
        int[] num = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(num, 8));
        int[] arr = {2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }
}
