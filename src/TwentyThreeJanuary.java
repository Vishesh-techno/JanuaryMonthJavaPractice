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

        for (int i = 0; i < arr.length; i++) {
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(subArraySum(arr, 12));
    }
}
