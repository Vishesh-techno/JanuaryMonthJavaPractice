public class FifteenJanuary {
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) {
            return false;
        }

        int deltaY21 = coordinates[1][1] - coordinates[0][1];
        int deltaX21 = coordinates[1][0] - coordinates[0][0];
        for (int i = 2; i < coordinates.length; i++) {
            int deltaYI1 = coordinates[i][1] - coordinates[0][1];
            int deltaXI1 = coordinates[i][0] - coordinates[0][0];

            if (deltaY21 * deltaXI1 != deltaYI1 * deltaX21) {
                return false;
            }
        }
        return true;
    }

    public static int numberOfCuts(int n) {
        if (n < 2) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return n;
        }
    }

    public static void main(String[] args) {
        int[][] coordinates = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};

        if (checkStraightLine(coordinates)) {
            System.out.println("the coordinates in Straight Line");
        } else {
            System.out.println("the coordinates not in a Straight Line");
        }

        System.out.println(numberOfCuts(45));
    }
}
