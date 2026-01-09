import java.util.ArrayList;
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subset(nums));
        System.out.println(combination(3, 2));
        System.out.println(permutation(nums));
    }

}
