import java.util.ArrayList;

public class ThirtyOneJanuary {
    public static ArrayList<Integer> getMinMax(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int min = arr[0];
        int max = arr[0];
        for (int j : arr) {
            if (j <= min) {
                min = j;
            } else if (j > max) {
                max = j;
            }
        }
        res.add(min);
        res.add(max);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {32011, 123, 1045, 1205, 254, 28763, 6537, 3161};
        System.out.println(getMinMax(arr));
    }
}
