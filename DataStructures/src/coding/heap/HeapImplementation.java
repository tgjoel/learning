package coding.heap;

public class HeapImplementation {
    public static void main(String[] args) {

    }
}

class MaxHeap {

    int[] heap;
    int size;

    public MaxHeap(int size) {
        this.size = size;
        this.heap = new int[size];
    }
    //get position of the parent of the element
    public int parentPosition(int elemPos) {
        return (elemPos -1)/2;
    }
    //get the position of the left child of the element
    public int leftChildPosition(int elemPos) {
        return (2 * elemPos);
    }
    //get the position of the right child of the element
    public int rightChildPosition(int elemPos) {
        return (2 * elemPos +1);
    }

    public boolean isLeafNode(int elemPos) {
        return (elemPos >= (size/2) && size > elemPos);
    }

    public void swap(int firstPos, int secondPos) {
        int temp = heap[firstPos];
        heap[firstPos] = heap[secondPos];
        heap[secondPos] = temp;
    }

    /*
        For max heap: compare the child elements and get the largest among them.
        swap it with the element if element is smallest among the child elements
        call heapify on the largest child elements
     */
    public void heapifyDown(int elemPos) {
        //if the element is the leaf node then return
        if(isLeafNode(elemPos)) {
            return;
        }

        int leftPos = leftChildPosition(elemPos);
        int rightPos = rightChildPosition(elemPos);

        int largestChildPos;

        // checking which of the element is the largest
        if(heap[leftPos] >= heap[rightPos]) {
            largestChildPos = leftPos;
        } else {
            largestChildPos = rightPos;
        }
        //comparing the largest among the element and the largest child
        if(heap[largestChildPos] > heap[elemPos]) {
            swap(elemPos, largestChildPos);
            heapifyDown(largestChildPos); // calling the heapify down on the child element that was swapped.
        }

    }
}
