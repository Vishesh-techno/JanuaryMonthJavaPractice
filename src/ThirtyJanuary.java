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

    public static void main(String[] args) {
        int[] nums = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProductSubArray(nums));
    }
}
