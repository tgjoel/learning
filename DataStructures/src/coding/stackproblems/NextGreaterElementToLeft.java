package coding.stackproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementToLeft {

    public static void main(String[] args) {
        int arr[] = {11, 21, 12, 3, 15, -1, 0, 5, 18};  // {4, 5, 2, 25}  // {13, 7, 6, 12}
        printNGEToLeft(arr);
    }

    private static void printNGEToLeft(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                ans.add(-99);
                stack.add(arr[i]);
                continue;
            }
            int popedElement = Integer.MIN_VALUE;
            while (!stack.isEmpty() && popedElement <= arr[i]) {
                popedElement = stack.pop();
            }
            // popped element is greater than the current element.need to check this condition first as stack can be empty
            if (popedElement > arr[i]) {
                ans.add(popedElement);
                stack.push(popedElement); // pushing the poped element back
            } else {
                ans.add(-99);
            }
            stack.add(arr[i]);
        }
        ans.forEach(ele -> System.out.print(ele + " "));
    }
}
