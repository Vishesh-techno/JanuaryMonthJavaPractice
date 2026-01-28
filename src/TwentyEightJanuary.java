import java.util.Arrays;

public class TwentyEightJanuary {
    public static void rotateArray(int[] nums, int d) {
        d = d % nums.length;
        rotate(nums, 0, d - 1);
        rotate(nums, d, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }

    public static void rotate(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        rotateArray(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
