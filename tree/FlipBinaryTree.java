package tree;

import java.util.LinkedList;
import java.util.Queue;

public class FlipBinaryTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BT b1 = new BT();
        BT bt = b1.getBT();
        FlipBinaryTree fb = new FlipBinaryTree();
        fb.printLevel(bt);
        BT b2 = fb.flipTree(bt);
        System.out.println();
        fb.printLevel(b2);

    }

    public BT flipTree(BT bt) {
        if (bt == null) {
            return null;
        }
        if (bt.getLeft() == null && bt.getRight() == null) {
            return bt;
        }
        BT flip = flipTree(bt.getLeft());
        bt.getLeft().setLeft(bt.getRight());
        bt.getLeft().setRight(bt);
        bt.setLeft(null);
        bt.setRight(null);
        return flip;

    }

    public void printLevel(BT b) {
        Queue<BT> queue = new LinkedList<>();
        queue.add(b);
        while (!queue.isEmpty()) {
            BT b1 = queue.poll();
            System.out.print(b1.getData() + ",");
            if (b1.getLeft() != null) {
                queue.add(b1.getLeft());
            }
            if (b1.getRight() != null) {
                queue.add(b1.getRight());
            }
        }
    }
}
