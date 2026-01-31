import java.util.*;

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

    public static List<Integer> frequencyCount(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 1; i <= arr.length; i++) {
            res.add(map.getOrDefault(i, 0));
        }
        return res;
    }

    public static int countFreq(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.getOrDefault(target, 0);
    }

    public static int countFreqII(int[] arr, int target) {
        int start = firstOcc(arr, target);
        if (start == -1) return 0;
        int last = lastOcc(arr, target);
        return last - start + 1;
    }

    private static int firstOcc(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static int lastOcc(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {32011, 123, 1045, 1205, 254, 28763, 6537, 3161};
        System.out.println(getMinMax(arr));
        int[] arr1 = {2, 3, 2, 3, 5};
        int[] arr2 = {1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 4, 5};
        System.out.println(frequencyCount(arr1));
        System.out.println(countFreq(arr1, 2));
        System.out.println(countFreqII(arr2, 2));
    }
}
