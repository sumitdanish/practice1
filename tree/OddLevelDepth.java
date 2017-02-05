package tree;

/**
 * Created by summit on 2/2/17.
 */
public class OddLevelDepth {

    public static void main(String[] args) {
        OddLevelDepth o = new OddLevelDepth();
        BT4 bt4 = new BT4();
        bt4 = bt4.createTree();
        int d = o.depth(bt4, 1);
        System.out.println(d);
    }

    public int depth(BT4 bt, int level) {
        if (bt == null) {
            return 0;
        }
        int lc = 0;
        int rc = 0;
        level = level + 1;
        if (level % 2 != 0 && bt.getLeft() == null && bt.getRight() == null) {
            return level;
        }
        lc = depth(bt.getLeft(), level);
        rc = depth(bt.getRight(), level);
        return max(lc, rc);
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}

class BT4 {
    private int data;
    private BT4 left;
    private BT4 right;

    public BT4() {

    }

    public BT4(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BT4 getLeft() {
        return left;
    }

    public void setLeft(BT4 left) {
        this.left = left;
    }

    public BT4 getRight() {
        return right;
    }

    public void setRight(BT4 right) {
        this.right = right;
    }

    public BT4 createTree() {
        BT4 bt = new BT4(4);
        bt.setLeft(new BT4(10));
        bt.setRight(new BT4(2));
        bt.getLeft().setLeft(new BT4(3));
        bt.getLeft().setRight(new BT4(4));
        bt.getLeft().getRight().setLeft(new BT4(44));
        bt.getLeft().getRight().getLeft().setRight(new BT4(12));
        bt.getRight().setRight(new BT4(15));
        bt.getRight().getRight().setLeft(new BT4(9));
        bt.getRight().getRight().setRight(new BT4(8));
        return bt;
    }
}
