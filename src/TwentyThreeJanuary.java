import java.util.ArrayList;
import java.util.List;

public class TwentyThreeJanuary {
    public static List<Integer> subArraySum(int[] arr, int target) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            sum = sum + arr[right];
            while (sum > target && left <= right) {
                sum = sum - arr[left];
                left++;
            }
            if (sum == target) {
                res.add(left);
                res.add(right);
                return res;
            }
        }
        res.add(-1);
        return res;
    }

    public static int kadanesAlgo(int[] arr) {
        int maxSum = arr[0];
        int currSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = arr[i];
            } else {
                currSum = currSum + arr[i];
            }
            if (maxSum < currSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partIdx = partition(arr, start, end);
        quickSort(arr, start, partIdx - 1);
        quickSort(arr, partIdx + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
//        i++;
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {6, 7, 10, 8, 9, 1, 2, 3, 4, 5};
        System.out.println(subArraySum(arr, 12));
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
