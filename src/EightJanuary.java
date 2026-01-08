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


    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
//        System.out.println(permutations(nums));
        System.out.println(uniquePermutations(nums));
    }
}
