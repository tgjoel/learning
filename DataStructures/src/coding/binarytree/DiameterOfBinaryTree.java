package coding.binarytree;

/**
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between two end nodes
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {

        N20_1 root = new N20_1(1);
        root.left = new N20_1(2);
        root.right = new N20_1(3);
        root.left.left = new N20_1(4);
        root.left.right = new N20_1(5);
        root.left.left.left = new N20_1(6);
        root.left.left.left.right = new N20_1(7);

        System.out.println("Diameter is " + new BT_20_1().diameter(root));

    }
}

class N20_1 {
    int data;
    N20_1 left;
    N20_1 right;

    public N20_1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Result {
    int res = Integer.MIN_VALUE;
}

class BT_20_1 {

    public int diameterOfBT(N20_1 root, Result result) {
        if(root == null) {
            return 0;
        }

        int left = diameterOfBT(root.left, result);
        int right = diameterOfBT(root.right, result);
        int tmp = 1 + Math.max(left, right);

        int ans = Math.max(tmp, (1+ left + right));
        result.res = ans;
        return tmp;
    }

    public int diameter(N20_1 root) {
        Result res = new Result();
        diameterOfBT(root, res);
        return res.res;
    }
}
