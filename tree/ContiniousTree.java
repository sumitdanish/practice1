package tree;

public class ContiniousTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BT1 tn = new BT1();
        ContiniousTree ct = new ContiniousTree();
        boolean b = ct.isContiniuos(tn.createBT1());
        System.out.println(b);
    }

    public boolean isContiniuos(BT1 tn) {
        if (tn == null) {
            return true;
        }
        if (tn.getLeft() == null && tn.getRight() == null) {
            return true;
        }
        if (tn.getLeft() != null) {
            return Math.abs(tn.getData() - tn.getLeft().getData()) == 1 && isContiniuos(tn.getLeft());
        }
        if (tn.getRight() != null) {
            return Math.abs(tn.getData() - tn.getRight().getData()) == 1 && isContiniuos(tn.getRight());
        }

        return Math.abs(tn.getData() - tn.getLeft().getData()) == 1
                && Math.abs(tn.getData() - tn.getRight().getData()) == 1 && isContiniuos(tn.getLeft())
                && isContiniuos(tn.getRight());

    }
}

class BT1 {
    private BT1 left;
    private BT1 right;
    private int data;
    private BT1 bt1 = null;

    BT1() {

    }

    public BT1(int data) {
        super();
        this.data = data;
    }

    public BT1 getLeft() {
        return left;
    }

    public void setLeft(BT1 left) {
        this.left = left;
    }

    public BT1 getRight() {
        return right;
    }

    public void setRight(BT1 right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BT1 createBT1() {
        bt1 = new BT1(7);
        bt1.setLeft(new BT1(5));
        bt1.setRight(new BT1(8));
        bt1.getLeft().setLeft(new BT1(1));
        bt1.getLeft().setRight(new BT1(3));
        bt1.getRight().setRight(new BT1(5));
        return bt1;
    }
}