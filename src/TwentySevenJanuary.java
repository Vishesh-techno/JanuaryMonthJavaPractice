import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class TwentySevenJanuary {
    public static boolean parenthesisIsBalanced(String s) {
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stk.push(c);
            } else {
                if (stk.isEmpty()) return false;
                char top = stk.peek();
                if (c == ']' && top != '[' ||
                        c == ')' && top != '(' ||
                        c == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    public static int findEquilibrium(int[] nums) { // find a index where left and right is equal
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        int lefSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - lefSum - nums[i];
            if (lefSum == rightSum) {
                return i;
            }
            lefSum += nums[i];
        }
        return -1;
    }

    public static int kthSmallest(int[] arr, int k) {
//        Arrays.sort(arr);
//        return arr[k-1];   // 1st Approach

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        while (k != 1) {
            k--;
            pq.poll();
        }
        return pq.peek();
    }

    public static ArrayList<Integer> findTwoElement(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int repeat = -1, missing = -1;
        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;

            if (arr[idx] < 0) {
                repeat = Math.abs(arr[i]);
            } else {
                arr[idx] = -arr[idx];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        res.add(missing);
        res.add(repeat);
        return res;

//        BruteForce Approach
//        ArrayList<Integer> res = new ArrayList<>();
//        Arrays.sort(arr);
//        int repeat = -1;
//        for(int i=0; i<arr.length-1; i++){
//            if(arr[i] == arr[i+1]){
//                repeat = arr[i];
//                break;
//            }
//        }
//        res.add(repeat);
//        int xor = 0;
//        for(int i=1; i<=arr.length; i++){
//            xor = xor ^ i;
//        }
//        int xor1 = 0;
//        for(int i=0; i<arr.length; i++){
//            xor1 = xor1 ^ arr[i];
//        }
//        int missing = (xor^xor1)^repeat;
//        res.add(missing);
//        return res;
    }

    public static int peak(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        String s = "[{{(";
        System.out.println(parenthesisIsBalanced(s));
        int[] arr = {1, 2, 5, 2, 72, 256, 28, 2, 9, 2, 1, 82, 5, 1, 8, 1, 5, 2, 4};
        System.out.println(kthSmallest(arr, 10));
        System.out.println(findEquilibrium(arr));
        int[] nums = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElement(nums));
        int[] num = {1, 2, 4, 5, 7, 8, 3};
        System.out.println(peak(num));
    }
}
