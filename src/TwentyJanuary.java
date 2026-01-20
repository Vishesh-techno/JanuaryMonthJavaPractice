public class TwentyJanuary {
    public static int fibonacci(int n) {
        return helper(n);
    }

    private static int helper(int n) {
        if (n <= 1) {
            return n;
        }
        return helper(n - 1) + helper(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }
}
