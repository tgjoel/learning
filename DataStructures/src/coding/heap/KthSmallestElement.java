package coding.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//time complexity --> O(nlogk)
public class KthSmallestElement {

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(7, 4, 6, 3, 9, 1, 0);
        int k = 3;
        System.out.println("Kth smallest element: " + kthSmallest(input, k));
    }

    private static int kthSmallest(List<Integer> input, int k) {
        if (input == null || k > input.size()) {
            return -1;
        }
        // declaring a max heap to find out the smallest element.
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < input.size(); i++) {
            queue.add(input.get(i));
            if (queue.size() > k) {  // Removing the top most elements as the size of the queue is greater than of k
                // and there is no way they could be out kth smallest element
                queue.poll();
            }
        }
        return !queue.isEmpty() ? queue.peek():  -1; // the top element will be the kth smallest element
    }
}
