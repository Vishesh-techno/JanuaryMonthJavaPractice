import java.util.Arrays;
import java.util.Scanner;

public class TenJanuary {
    public static int secondLargest(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (first > nums[i] && nums[i] > second) {
                second = nums[i];
            }
        }
        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the size of Array: ");
        n = sc.nextInt();
        System.out.println("Enter the Elements of Array: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("The Second Largest Element is: " + secondLargest(arr));

        String str = "Vishesh";
        System.out.println("\"" + str + "\"");
    }
}
