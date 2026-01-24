import java.util.ArrayList;
import java.util.List;

public class TwentyFourJanuary {
    public static int maxSumSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum = currSum + num;
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum <= 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static int minJumps(int[] nums) {
        int n = nums.length;
        int maxReach = 0, currReach = 0, jumps = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) {
                return -1;
            }
            if (i > currReach) {
                currReach = maxReach;
                jumps++;
            }
            int next = i + nums[i];
            if (maxReach < next) {
                maxReach = next;
            }
        }
        return jumps;
    }

    public static boolean isValidJump(int[] nums) {
        int n = nums.length;
        int currReach = 0, maxReach = 0;
        for (int i = 0; i < n; i++) {
            if (i > maxReach) return false;
            if (i > currReach) currReach = maxReach;
            int nextJump = i + nums[i];
            if (maxReach < nextJump) {
                maxReach = nextJump;
            }
        }
        return true;
    }

    public static List<Integer> leaders(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            if (nums[i] == max) {
                res.add(max);
            }
        }
        res.add(nums[n - 1]);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 8, 1, 5, 5};
        System.out.println(maxSumSubArray(nums));
        System.out.println(minJumps(nums));
        System.out.println(isValidJump(nums));
        System.out.println(leaders(nums));
    }
}
