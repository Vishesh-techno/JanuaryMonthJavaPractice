import java.util.Arrays;

public class TwentyFiveJanuary {
    public static void sort0s1s2s(int[] nums) {
        int start = 0, end = nums.length - 1, mid = 0;

        while (mid <= end) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                start++;
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort0s1s2s(arr);
        System.out.println(Arrays.toString(arr));
    }
}
