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

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 4, 5, 3, 145, 65, 52, 41, 5, -1100, 3, 2, 45, -3000, 3, 21, 5, 5, 4, 415, -200, 524, 100, 5, 5, 5};
        System.out.println(maxSumSubArray(nums));
    }
}
