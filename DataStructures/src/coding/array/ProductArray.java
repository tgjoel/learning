package coding.array;

import java.util.Arrays;

public class ProductArray {
    /*
       Input: arr[]  = {10, 3, 5, 6, 2}
       Output: prod[]  = {180, 600, 360, 300, 900}
        180: 3 * 5 * 6 * 2 product of other array
     */

    public static void main(String[] args) {

        int[] arr =  {10, 3, 5, 6, 2};
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] prod = new int[n];
        left[0] = 1;
        right[n-1] = 1;
        
        for (int i = 1; i < n; i++) {
            left[i] = arr[i-1] * left[i-1];
        }

        for (int i = n-2; i >=0 ; i--) {
            right[i] = arr[i+1] * right[i+1];
        }

        for (int i = 0; i < n; i++) {
            prod[i] = left[i] * right[i];
        }
        Arrays.stream(prod).forEach(value -> System.out.print(value + " "));
    }
}
