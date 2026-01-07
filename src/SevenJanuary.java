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

    }
}
