package coding.linkedlistproblems;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

//https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
//Clone a linked list with next and random pointer
public class CloneLinkedListAndRandomPoint {
    public static void main(String[] args) {

        List1609 list = new List1609();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random =
                list.head.next.next.next;
        list.head.next.next.random =
                list.head.next.next.next.next;
        list.head.next.next.next.random =
                list.head.next.next.next.next.next;
        list.head.next.next.next.next.random =
                list.head.next;

        List1609 clone = list.clone();

        System.out.println("Original linked list");
        list.print();
        System.out.println("\nCloned linked list");
        clone.print();
    }
}

class N16091 {
    int data;
    N16091 next, random;

    public N16091(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

class List1609 {
    N16091 head;

    public List1609() {
        this.head = null;
    }

    public void push(int data) {
        N16091 node = new N16091(data);
        node.next = this.head;
        this.head = node;
    }

    public void print() {
        if(head == null) {
            return;
        }
        N16091 tmp = head;
        while (tmp != null) {
            System.out.println("Data: " + tmp.data + " || " +
                    "Random data: " + (tmp.random != null ? tmp.random.data: -1) + " ");
            tmp = tmp.next;
        }
    }

    public List1609 clone() {
        if(head == null) {
            return null;
        }

        Map<N16091,N16091> map = new HashMap<>();
        N16091 tmp = head;
        while (tmp!=null) {  // creates a hashmap with original linked list and new cloned nodes of the linked list.
            map.put(tmp, new N16091(tmp.data));
            tmp = tmp.next;
        }
        //now we need to link the next and random of the newly created linked list
        //iterating over the map
        for (N16091 key: map.keySet()) {
            N16091 cloneNode = map.get(key);
            cloneNode.next = map.get(key.next); // this points to the new node created. hence linking that to the clonedNode
            cloneNode.random = map.get(key.random);
        }
        List1609 clonedList = new List1609();
        clonedList.head = map.get(head); // current head points to the head of the new list created
        return clonedList;
    }
}
