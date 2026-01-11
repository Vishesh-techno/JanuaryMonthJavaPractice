import java.util.Scanner;

public class ElevenJanuary2 {
    public static int digitSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum = sum + digit;
            n = n / 10;
        }
        return sum;
    }

    public static int sumOfNumber(int n, int r) {
        if (r == 0) return 0;

        int sumN = digitSum(n);
        int total = sumN * r;

        while (total >= 10) {
            total = digitSum(total);
        }
        return total;
    }

    public static int calculateFine(int[] arr, int date, int fine) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (date % 2 == 0 && arr[i] % 2 != 0) {
                count++;
            } else if (date % 2 != 0 && arr[i] % 2 == 0) {
                count++;
            }
        }
        return count * fine;
    }

    public static int decTobinToDec(int n) {
        String bin = "";
        while (n != 0) {
            bin = (n & 1) + bin;
            n = n >> 1;
        }
        bin = bin.replaceAll("1", "2");
        bin = bin.replaceAll("0", "1");
        bin = bin.replaceAll("2", "0");
        return Integer.parseInt(bin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        int r = sc.nextInt();
//        int sum = 0;
//        for(int i=1; i<r; i++){
//            while(n != 0){
//                int digit = n % 10;
//                sum = sum + digit;
//                n = n / 10;
//            }
//        }
//        System.out.println(sumOfNumber(n, r));
        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int date = sc.nextInt();
//        int fine = sc.nextInt();
//        System.out.println(calculateFine(arr, date, fine));
        System.out.println(decTobinToDec(n));
    }
}
