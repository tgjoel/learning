package coding.stackproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextSmallerElementToRight {

    public static void main(String[] args) {
        int arr[] = {11, 21, 12, 3, 15, -1, 0, 5, 18};
        printNSEToRight(arr);
    }

    private static void printNSEToRight(int[] arr) {
        int n = arr.length - 1;
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = n; i >=0; i--) {
            if(stack.isEmpty()) {
                ans.add(-99);
                stack.add(arr[i]);
                continue;
            }
            int popeElement = Integer.MAX_VALUE;
            while(!stack.isEmpty() && popeElement > arr[i]){
                popeElement = stack.pop();
            }
            if(popeElement < arr[i]) {
                ans.add(popeElement);
                stack.push(popeElement);
            } else {
                ans.add(-99);
            }
            stack.push(arr[i]);
        }
        Collections.reverse(ans);
        ans.forEach(elem -> System.out.print(elem+ " "));
    }
}
