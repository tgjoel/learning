package linkedlist;

//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/?ref=lbp
public class ReverseAlternateKNodes {

	public static void main(String[] args) {

		L11 l1 = new L11();
		l1.append(1);
		l1.append(2);
		l1.append(3);
		l1.append(4);
		l1.append(5);
		l1.append(6);
		l1.append(7);
		l1.append(8);
		l1.append(9);
		l1.append(10);
		l1.print();
		System.out.println();
		l1.reverse(2);
		l1.print();

	}

}

class L11 {
	Node11 head;

	static class Node11 {

		Node11 next;
		int data;

		Node11(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void append(int data) {

		Node11 n = new Node11(data);
		if (head == null) {
			head = n;
			return;
		}

		Node11 tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = n;
	}

	public void print() {
		if (head == null) {
			System.out.println("empty");
		}

		Node11 tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}

	public void reverse(int k) {
		
		//easier way
		head = reverse1(head, k);
		
		//another way
		//head = reverse2(head, k, true);
	}

	private Node11 reverse1(Node11 head, int k) {
		
		
		int count = 0;
		Node11 curr = head;
		Node11 prev = null;
		Node11 next = null;
		
		while(curr!= null && count < k) {
			count++;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		/* first loop reverses the first k numbers, next k numbers need not be reversed.
		after first loop prev will be the starting and head will be the end. 
		hence linking the head to the next value and skipping the next k values without reversing
		moving the head to the next position. Next calling the reverse method again 
		and getting the reversed value to the next of current head;.
		
		*/
			if(head!=null) {
				head.next = curr;
			}
			
			for (int i = 0; i < k && curr!=null; i++) {
				head = curr;
				curr = curr.next;
			}
			
			if(curr!=null) {
				head.next = reverse1(curr, k);
			}

		
		return prev;
	}

	private Node11 reverse2(Node11 head, int k, boolean flag) {

		if (head == null) { 
            return null; 
        } 
		
		int count = 0;
		Node11 curr = head;
		Node11 prev = null;
		Node11 next = null;

		while (curr != null && count < k) {

			next = curr.next;
			if (flag) {
				curr.next = prev;
			}

			prev = curr;
			curr = next;
			count++;
		}

		if (flag) {
			head.next = reverse2(curr, k, !flag);
			return prev;
		} else {
			prev.next = reverse2(curr, k, !flag);
			return head;
		}
	}
}
