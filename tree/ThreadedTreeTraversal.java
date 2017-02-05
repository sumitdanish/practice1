package tree;

public class ThreadedTreeTraversal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BT2 b = new BT2();
        BT2 b1 = b.createTree();
        new ThreadedTreeTraversal().threadedTree(b1);
    }

    public void threadedTree(BT2 bt) {
        BT2 current = bt;
        while (current != null) {
            if (current.getLeft() == null) {
                System.out.print(current.getName() + ",");
                current = current.getRight();
            } else {
                BT2 pre = current.getLeft();
                while (pre.getRight() != null && pre.getRight() != current) {
                    pre = pre.getRight();
                }
                if (pre.getRight() == null) {
                    pre.setRight(current);
                    current = current.getLeft();
                } else {
                    pre.setRight(null);
                    System.out.print(current.getName() + ",");
                    current = current.getRight();
                }
            }
        }
    }

}

class BT2 {
    BT2 bt = null;
    private BT2 left;
    private BT2 right;
    private String name;

    public BT2(String name) {
        this.name = name;
    }

    public BT2() {

    }

    public BT2 getLeft() {
        return left;
    }

    public void setLeft(BT2 left) {
        this.left = left;
    }

    public BT2 getRight() {
        return right;
    }

    public void setRight(BT2 right) {
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BT2 getBt() {
        return bt;
    }

    public void setBt(BT2 bt) {
        this.bt = bt;
    }

    public BT2 createTree() {
        bt = new BT2("A");
        bt.setLeft(new BT2("B"));
        bt.setRight(new BT2("C"));
        bt.getLeft().setRight(new BT2("E"));
        bt.getLeft().setLeft(new BT2("D"));
        bt.getLeft().getLeft().setLeft(new BT2("H"));
        bt.getLeft().getLeft().setRight(new BT2("I"));
        bt.getRight().setLeft(new BT2("F"));
        bt.getRight().setRight(new BT2("G"));
        bt.getRight().getLeft().setRight(new BT2("J"));
        return bt;
    }
}