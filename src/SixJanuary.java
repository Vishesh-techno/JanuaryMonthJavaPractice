import java.util.*;

public class SixJanuary {
    public static int lengthOfLongestSubString(String str) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < str.length()) {
            char currChar = str.charAt(right);

            if (map.containsKey(currChar)) {
                int currIdx = map.get(currChar);

                if (currIdx >= left) {
                    left = currIdx + 1;
                }
            }

            maxLen = Math.max(maxLen, right - left + 1);
            map.put(currChar, right);
            right++;
        }
        return maxLen;
    }

    public static int lengthOfLongestSubStringII(String str) {
        Set<Character> set = new HashSet<>();

        int left = 0, right = 0;
        int maxLen = 0;

        while (right < str.length()) {
            char currChar = str.charAt(right);

            while (set.contains(currChar)) {
                set.remove(currChar);
                left++;
            }
            set.add(currChar);
            maxLen = Math.max(maxLen, right - left + 1);
//            map.put(currChar, right);
            right++;
        }
        return maxLen;
    }

//    Find max element in Array

    public static int maxElement(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    //    Reverse an Array
    public static int[] reverseArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }

    public static int reverseArray(int nums) {
        int sum = 0;
        while (nums != 0) {
            int lastDigit = nums % 10;
            nums = nums / 10;
            sum = sum * 10 + lastDigit;
        }
        return sum;
    }

    //    pairs in Array
    public static int pairsInArray(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.print("(" + nums[i] + ", " + nums[j] + ")");
                count++;
            }
            System.out.println();
        }
        return count;
    }

    //    print sub-arrays
    public static void subArray(int[] nums) {
        int ts = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(nums[k]);
                }
                count++;
                System.out.println();
            }
            ts++;
            System.out.println("Total pairs: " + count);
        }
        System.out.println("Total Sub Array: " + ts);

    }

    //    Max SubArray sum
    public static int maxSubArraySum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum; //  {50, 2, 18, 5, 7, 15, 45};
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            for (int j = i; j < nums.length; j++) {
                int end = j;
                sum = 0;
                for (int k = start; k <= end; k++) {
                    sum += nums[k];
                }
                System.out.print(sum + "=>");
                maxSum = Math.max(sum, maxSum);
            }
        }
        System.out.println();
        return maxSum;
    }

    //    prefix sum maxsubArray
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == 0) {
                    sum = prefix[j];
                } else {
                    sum = prefix[j] - prefix[i - 1];
                }
                System.out.println(sum);
//                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i -1];
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    //    kadane's Algorithm
    public static int kadanesAlgorithm(int[] nums) {
        int currSum = 0;
        int maxSum = 0;
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum += num;
            if (maxElement < num) {
                maxElement = num;
            }
            if (currSum <= 0) {
                currSum = 0;
            }
            maxSum = Math.max(currSum, maxSum);
        }
        if (maxElement < 0) {
            return maxElement;
        }
        return maxSum;
    }

    public static int trappedWater(int[] nums) {
//        calculate leftMax boundary
        int[] leftMax = new int[nums.length];
        leftMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(nums[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[nums.length];
        rightMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
        }
        int trappedWater = 0;
        for (int i = 0; i < nums.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - nums[i];
        }
        return trappedWater;
    }

    //    Buy and Sell Stocks
    public static int stockProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (buyPrice < price) {
                int profit = price - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyPrice = price;
            }
        }
        return maxProfit;
    }

    public static void vehicles(int totalVehicles, int totalWheel) {
        int FW = (totalWheel - 2 * totalVehicles) / 2;
        System.out.println("The no. of Four Wheeler is: " + FW);
        System.out.println("The no. of Two Wheeler is: " + (totalVehicles - FW));
    }

    public static void findSubSets(String str, String ans, int i) {
//        base case
        if (i == str.length()) {
            if (ans.isEmpty()) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }

//        Recursion case
//        Yes Choice
        findSubSets(str, ans + str.charAt(i), i + 1);
//        No choice
        findSubSets(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int[] nums = {45, 15, 7, 5, 18, 2, 50};
        System.out.println(maxElement(nums));
        System.out.println(lengthOfLongestSubString(str));
        System.out.println(lengthOfLongestSubStringII(str));
        System.out.println(Arrays.toString(reverseArray(nums)));
        System.out.println(reverseArray(4587));
        System.out.println(pairsInArray(nums));
        subArray(nums);
        int[] num = {1, -2, 6, -1, 3};
//        System.out.println(maxSubArraySum(num));
//        System.out.println(maxSubArray(num));
        System.out.println(kadanesAlgorithm(num));
        int[] water = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(trappedWater(water));
        System.out.println(stockProfit(water));
        vehicles(200, 540);
        findSubSets("abc", "", 0);
    }
}
