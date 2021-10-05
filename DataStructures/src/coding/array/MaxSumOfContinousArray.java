package coding.array;

public class MaxSumOfContinousArray {
    public static void main(String[] args) {
        int[] a = { -2, -3, 4, -1, -2, 5, -3 };
        System.out.println(maxSum1(a));
        System.out.println(maxSum2(a));
    }

    //this solution handles even all the elements are -ve
    private static int maxSum2(int[] a) {
        int maxSum = a[0];
        int currentSum = a[0];
        for (int i = 1; i < a.length; i++) {
            currentSum = Integer.max(a[i], currentSum + a[i]);
            maxSum = Integer.max(currentSum, maxSum);
        }
        return maxSum;
    }

    private static int maxSum1(int[] a) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < a.length; i++) {
            currentSum+=a[i];
            // if the maximum sum is negative, set it to 0 (which represents an empty subarray)
            currentSum = Math.max(currentSum, 0);
            // updating if the current sum is found to be greater than the existing sum
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }
}
