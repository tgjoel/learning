package coding.array;

import java.util.HashSet;

public class FindTriplet {
    /*
        Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
        Output: 12, 3, 9
        Input: array = {1, 2, 3, 4, 5}, sum = 9
        Output: 5, 3, 1
     */

    public static void main(String[] args) {

        int[] arr =  {1, 2, 3, 4, 5};
        int sum = 9;
        boolean flag = true;

        for(int i = 0; i < arr.length - 2 && flag; i++) { //as last two numbers would be already considered
            int tmp = sum-arr[i]; // found the current difference. now we need to find a pair in the rest of the array where
            // there sum is equal to tmp
            HashSet<Integer> set = new HashSet<>();
            for (int j = i+1; j < arr.length ; j++) {
                if(set.contains(tmp - arr[j])) {
                    System.out.println(arr[i] + " " + arr[j] + " " + (tmp - arr[j]));
                    flag = false;
                    break;
                }
                set.add(arr[j]);
            }
        }
        if(flag) {
            System.out.println("No triplet");
        }
    }
}
