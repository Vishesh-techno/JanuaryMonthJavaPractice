import java.util.ArrayList;
import java.util.List;

public class SevenJanuary {
    public static void permutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        boolean[] used = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (used[curr - 'a']) continue;
            used[curr - 'a'] = true;
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutations(newStr, ans + curr);
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
//        vertical check
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

//        diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

//        diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static boolean nQueesns(char[][] board, int row) {
        if (row == board.length) {
//            printBoard(board);
            count++;
            return true;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                if (nQueesns(board, row + 1)) {
                    return true;
                }
                board[row][j] = 'X';
            }
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        System.out.println("------Chess Board--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void board(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 'X';
            }
        }
    }

    static int count = 0;

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
//        Recursion Case
        findSubSets(str, ans + str.charAt(i), i + 1); // yes Case
        findSubSets(str, ans, i + 1); // No case
    }

    public static List<List<Integer>> findSubSetsNumber(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int n = res.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }

    public static void generateSubSet(int index, int[] nums, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            generateSubSet(i + 1, nums, curr, res);
//            curr.removeLast();
            curr.remove(curr.size() - 1);
        }
    }

    public static List<List<Integer>> findSubSetsNumberII(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubSet(0, nums, new ArrayList<>(), res);
        return res;
    }

    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        generateSubSetII(1, n, new ArrayList<>(), res, k);
        return res;
    }

    private static void generateSubSetII(int start, int n, List<Integer> curr, List<List<Integer>> res, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start; i <= n; i++) {
            curr.add(i);
            generateSubSetII(i + 1, n, curr, res, k);
            curr.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum3(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        generateSumSubSet(1, 9, new ArrayList<>(), res, n, k);
        return res;
    }

    private static void generateSumSubSet(int start, int end, List<Integer> curr, List<List<Integer>> res, int k, int target) {
        if(target == 0 && curr.size() == k) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start; i <= end; i++) {
            curr.add(i);
            generateSumSubSet(i + 1, end, curr, res, k, target - i);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        permutations("abc", "");
        int n = 3;
        char[][] board = new char[n][n];
        board(board);
        if (nQueesns(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is Not Possible");
        }
        System.out.println("The No. of possible solution is: " + count);
        findSubSets("ABC", "", 0);
        System.out.println(findSubSetsNumber(new int[]{4, 5, 6}));
        System.out.println(findSubSetsNumberII(new int[]{4, 5, 6}));
        System.out.println(combinations(4, 2));
        System.out.println(combinationSum3(4, 7));
    }
}
