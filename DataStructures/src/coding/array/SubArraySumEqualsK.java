package coding.array;

import java.util.HashMap;

//Number of subarrays with sum equals K
public class SubArraySumEqualsK {
    public static void main(String[] args) {
        // {1,1,1} k = 2 ; {1,2,3} k = 3
        //{3, 4, 7, 2, -3, 1, 4, 2} k = 7 ans: 4
        //  {-1, -1, 1}; k = 0;
        int[] a = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 7;
        System.out.println(subArraySum(a, k));
    }

    private static int subArraySum(int[] a, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
