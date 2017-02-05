package tree;

public class SwapNode {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CreateBT cb = new CreateBT();
        BT b = new BT();
        BT bt = b.getBT();
        cb.inOrder(bt);
        System.out.println();
        SwapNode s = new SwapNode();
        s.swap(bt, 2);
        cb.inOrder(bt);
    }

    public void swap(BT bt, int k) {
        if (bt == null) {
            return;
        }
        if (bt.getLeft() == null || bt.getRight() == null) {
            return;
        }
        if (k == 0) {
            BT temp = bt.getLeft();
            bt.setLeft(bt.getRight());
            bt.setRight(temp);
        }
        swap(bt.getLeft(), k - 1);
        swap(bt.getRight(), k - 1);
    }

}
