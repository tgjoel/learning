package coding.stackproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=NXOOYYwpbg4
//O(n)
public class NextGreaterElementToRight {
    public static void main(String[] args) {
        int arr[] = {11, 21, 12, 3, 15, -1, 0, 5, 8};  // {4, 5, 2, 25}  // {13, 7, 6, 12}
       // printNGE(arr);
        printNGE2(arr);
    }

    //first way
    private static void printNGE2(int[] arr) { // towards right
        Stack<Integer> stack = new Stack<>();
        List<Integer> ansList = new ArrayList<>();  // will have the ans by reversing this list
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ansList.add(-99);
            } else {
                int popedElem = Integer.MIN_VALUE;
                while (!stack.isEmpty() && popedElem <= arr[i]) {
                    popedElem = stack.pop();
                }
                if (popedElem > arr[i]) { // need to check this order as last element can be greater, and then stack will be empty so check greater condition first
                    ansList.add(popedElem);// when the poped elem is greater than the iterating element its the answer
                    stack.push(popedElem); // pushing the element back to the stack for next iteration as its greater, the elements
                    // which are lesser than the current are ignored
                } else { // else the loop exited since the stack is empty so no number is greater than the current.
                    ansList.add(-99);
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(ansList); // need to reverse the ans as we are iterating from the end
        System.out.println(ansList);
    }

    //second way
    private static void printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        //here actually we are comparing the element in the stack with the loop.
        for (int i = 1; i < arr.length; i++) {
            int elm = stack.pop();
            //for all the elements in the stack checking if the current one is the greater element
            while (elm < arr[i]) {
                System.out.println(elm + "--->" + arr[i]);
                if (stack.isEmpty()) {
                    break;
                }
                elm = stack.pop();
            }
            if (elm > arr[i]) {
                stack.push(elm);
            }
            stack.push(arr[i]);
        }
        if (!stack.isEmpty()) {
            for (Integer i : stack) {
                System.out.println(i + "--->" + -11);
            }
        }
    }
}
