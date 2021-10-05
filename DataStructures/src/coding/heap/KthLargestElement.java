package coding.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//time complexity --> O(nlogk)
public class KthLargestElement {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(7, 8, 6, 3, 19, 1, 0);
        int k = 3;
        System.out.println("Kth Largest element: " + kthLargest(input, k));
    }

    private static int kthLargest(List<Integer> input, int k) {
        if(input == null || k > input.size()) {
            return -1;
        }

        //creates a Min heap to find the kth smallest element.
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.size(); i++) {
            queue.add(input.get(i));
            if(queue.size() > k) {
                queue.poll(); // removing the top element
            }
        }
        return !queue.isEmpty() ? queue.peek():  -1;  // returnin the topmost element as it would be the kth largest element
    }
}
