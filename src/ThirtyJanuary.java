import java.util.*;

public class ThirtyJanuary {
    public static int maxProductSubArray(int[] nums) {
        int prod = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            max = Integer.max(max, prod);
            if (prod == 0) prod = 1;
        }
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prod *= nums[i];
            max = Integer.max(max, prod);
            if (prod == 0) prod = 1;
        }
        return max;
    }

    public static int[] maxOfSubArrays(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    public static boolean checkEqual(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while (i != a.length && j != b.length) {
            if (a[i] != b[j]) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static boolean checkEqualOptimal(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : b) {
            if (!map.containsKey(i)) return false;
            map.put(i, map.get(i) - 1);
            if (map.get(i) == 0) {
                map.remove(i);
            }
        }
        return map.isEmpty();
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }

        // nums1 - nums2
        // Set<Integer> set3 = new HashSet<>();
        for (int i : nums1) {
            if (set2.contains(i)) {
                set1.remove(i);
                set2.remove(i);
            }
        }

        // // nums2 - nums1
        // Set<Integer> set4 = new HashSet<>();
        // for (int i : set2) {
        //     if (!set1.contains(i)) {
        //         set4.add(i);
        //     }
        // }

        res.add(new ArrayList<>(set1));
        res.add(new ArrayList<>(set2));
        return res;
    }

    public static void pushZerosToEnd(int[] arr) {
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[x++] = arr[i];
            }
        }
        while (x != arr.length) {
            arr[x++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProductSubArray(nums));
        System.out.println(Arrays.toString(maxOfSubArrays(nums, 3)));
        int[] a = {1, 2, 5};
        int[] b = {2, 4, 15};
        System.out.println(checkEqual(a, b));
        System.out.println(checkEqualOptimal(a, b));
        System.out.println(findDifference(a, b));
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
