package tree;

public class CreateBT {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


    public void inOrder(BT bt) {
        if (bt != null) {
            inOrder(bt.getLeft());
            System.out.print(bt.getData() + ",");
            inOrder(bt.getRight());
        }
    }

}


class BT {
    private BT left;
    private BT right;
    private int data;
    private BT bt = null;

    public BT() {

    }

    public BT(int data) {
        this.data = data;
    }

    public BT getLeft() {
        return left;
    }

    public void setLeft(BT left) {
        this.left = left;
    }

    public BT getRight() {
        return right;
    }

    public void setRight(BT right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BT getBT() {
        bt = new BT(1);
        /*bt.setLeft(new BT(3));
		bt.setRight(new BT(10));
		bt.getLeft().setLeft(new BT(1));
		bt.getLeft().setRight(new BT(6));
		bt.getLeft().getRight().setLeft(new BT(4));
		bt.getLeft().getRight().setRight(new BT(7));
		bt.getRight().setRight(new BT(14));
		bt.getRight().getRight().setLeft(new BT(13));*/
		/*bt.setRight(new BT(9));
		bt.getRight().setLeft(new BT(7));
		bt.getRight().setRight(new BT(10));
		bt.getRight().getRight().setRight(new BT(11));
*/		
		/*bt.setLeft(new BT(2));
		bt.getLeft().setLeft(new BT(3));
		bt.setRight(new BT(4));
		bt.getRight().setLeft(new BT(5));
		bt.getRight().setRight(new BT(6));
		//bt.getRight().getRight().setLeft(new BT(7));
		bt.getRight().getRight().setRight(new BT(18));*/
        bt.setLeft(new BT(2));
        bt.setRight(new BT(3));
        bt.getLeft().setLeft(new BT(4));
        bt.getLeft().setRight(new BT(5));
        bt.getRight().setLeft(new BT(6));
        bt.getRight().setRight(new BT(7));

        return bt;
    }
}