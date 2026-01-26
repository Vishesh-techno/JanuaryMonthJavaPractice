import java.util.Arrays;

// Happy Republic Day
public class TwentySixJanuary {
    public static void merge(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        merge(nums, start, mid);
        merge(nums, mid + 1, end);
        mergeSort(nums, start, mid, end);
    }

    private static void mergeSort(int[] nums, int start, int mid, int end) {
        int[] merge = new int[end - start + 1];
        int idx1 = start;
        int idx2 = mid + 1;
        int x = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (nums[idx1] <= nums[idx2]) {
                merge[x++] = nums[idx1++];
            } else {
                merge[x++] = nums[idx2++];
            }
        }

        while (idx1 <= mid) {
            merge[x++] = nums[idx1++];
        }

        while (idx2 <= end) {
            merge[x++] = nums[idx2++];
        }

        for (int i = 0, j = start; i < merge.length; i++, j++) {
            nums[j] = merge[i];
        }
    }

    public static int inversionCount(int[] nums) {
        return countInversion(nums, 0, nums.length - 1);
    }

    private static int countInversion(int[] nums, int start, int end) {
        int count = 0;
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        count += countInversion(nums, start, mid);
        count += countInversion(nums, mid + 1, end);
        count += countInversionHelper(nums, start, mid, end);
        return count;
    }

    private static int countInversionHelper(int[] nums, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];
        int idx1 = start;
        int idx2 = mid + 1;
        int x = 0;
        int count = 0;

        while (idx1 <= mid && idx2 <= end) {
            if (nums[idx1] <= nums[idx2]) {
                merged[x++] = nums[idx1++];
            } else {
                merged[x++] = nums[idx2++];
                count += (mid - idx1 + 1);
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
        return count;
    }

    public static int findMin(int[] nums) { // find minimum in rotatedSorted Array
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    public static int findMinII(int[] nums) { // find minimum in rotatedSorted Array
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {-5, 54, 94, 156, 1, 54, 61, 81, 0, 80, 4, 84, 4};
//        merge(nums, 0, nums.length - 1);
        System.out.println(inversionCount(nums));
        System.out.println(Arrays.toString(nums));
        int[] arr = {3, 3, 1, 3};
        System.out.println(findMin(arr));
        System.out.println(findMinII(arr));
    }
}
