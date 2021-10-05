package coding.binarytree;

public class KthSmallestElementBST {
    public static void main(String[] args) {
        N0928_1 root = new N0928_1(5);
        root.left = new N0928_1(3);
        root.left.left = new N0928_1(2);
        root.left.right = new N0928_1(4);
        root.right = new N0928_1(7);
        root.right.left = new N0928_1(6);
        System.out.println(new BST0928_1().kthSmallest(root, 5).data);
    }
}

class N0928_1 {
    int data;
    N0928_1 left;
    N0928_1 right;

    public N0928_1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST0928_1 {

    static int count;

    //using the inorder traversal
    public N0928_1 kthSmallest(N0928_1 root, int k) {
        if (root == null) {
            return null;
        }
        N0928_1 left = kthSmallest(root.left, k);
        if (left != null) { // if the smallest element is found in the left subtree
            return left;
        }
        count++;
        if (count == k) {  // return if the current element is the smallest
            return root;
        }
        return kthSmallest(root.right, k);
    }
}
