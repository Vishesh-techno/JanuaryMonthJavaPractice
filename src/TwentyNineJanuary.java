import java.util.*;

public class TwentyNineJanuary {
    public static boolean isSubset(int[] a, int[] b) {
        if (b.length > a.length) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : b) {
            if (!map.containsKey(i) || map.get(i) == 0) {
                return false;
            }
            map.put(i, map.get(i) - 1);
        }
        return true;
    }

    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            set.add(i);
        }
        return new ArrayList<>(set);
    }

    public static ArrayList<Integer> findUnionII(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                if (res.size() == 0 || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
                j++;
            } else if (a[i] < b[j]) {
                if (res.size() == 0 || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
                i++;
            } else {
                if (res.size() == 0 || res.get(res.size() - 1) != b[j]) {
                    res.add(b[j]);
                }
                j++;
            }
        }
        while (i < a.length) {
            if (res.size() == 0 || res.get(res.size() - 1) != a[i]) {
                res.add(a[i]);
            }
            i++;
        }

        while (j < b.length) {
            if (res.size() == 0 || res.get(res.size() - 1) != b[j]) {
                res.add(b[j]);
            }
            j++;
        }
        return res;
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int nextGreater = -1;
            for (int j = i + 1; j < n; j++) {
                if (nextGreater < arr[j]) {
                    nextGreater = arr[j];
                    break;
                }
            }
            res.add(nextGreater);
        }
        return res;
    }

    public static ArrayList<Integer> nextLargerElementII(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        for (int i : arr) {
            res.add(-1);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }

            if (!stk.isEmpty()) {
                res.set(i, stk.peek());
            }

            stk.push(arr[i]);
        }
        return res;
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {11, 7, 1, 13, 21, 3, 7, 3};
        int[] b = {11, 3, 7, 1, 7};
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(isSubset(a, b));
        System.out.println(findUnion(a, b));
        System.out.println(findUnionII(a, b));
        System.out.println(nextLargerElementII(a));
        System.out.println(missingNumber(nums));
    }
}
