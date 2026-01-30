import java.util.Arrays;

public class ThirtyJanuary {
    public static int maxProductSubArray(int[] nums) {
        int prod = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            max = Integer.max(max, prod);
            if (prod == 0) prod = 1;
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            max = Integer.max(max, prod);
            if (prod == 0) prod = 1;
        }
        return max;
    }

    public static int[] maxOfSubArrays(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProductSubArray(nums));
        System.out.println(Arrays.toString(maxOfSubArrays(nums, 3)));
    }
}
