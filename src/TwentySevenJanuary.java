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

    public static void main(String[] args) {
        String s = "[{{(";
        System.out.println(parenthesisIsBalanced(s));
        int[] arr = {1, 2, 5, 2, 72, 256, 28, 2, 9, 2, 1, 82, 5, 1, 8, 1, 5, 2, 4};
        System.out.println(kthSmallest(arr, 10));
    }
}
