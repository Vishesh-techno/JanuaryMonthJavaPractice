import java.util.Arrays;

public class SixteenJanuary {
    public static void divide(int[] nums, int start, int end) {
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
        int idx1 = start, idx2 = mid + 1, x = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (nums[idx1] < nums[idx2]) {
                merged[x++] = nums[idx1++];
            } else {
                merged[x++] = nums[idx2++];
            }
        }
        while (idx1 <= mid) {
            merged[x++] = nums[idx1++];
        }
        while (idx2 <= end) {
            merged[x++] = nums[idx2++];
        }

        for (int i = 0, j = start; i < merged.length; i++, j++) {
            nums[j] = merged[i];
        }
    }

    public static int[] sorting(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    public static int hammingWeight(int n) { // count no. of ones in the binary no. of given "n"
        int count = 0;

        while (n > 0) {
            if ((n & 1) == 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 7, 466, 59, 465, 418, 4, 64, 6, 49, 641, 64646, 469865, 46};
        System.out.println(Arrays.toString(sorting(nums)));

        System.out.println(hammingWeight(458545476));
    }
}
