package tree;

public class PrintNodeWithKLeaves {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BT b = new BT();
        BT tn = b.getBT();
        new PrintNodeWithKLeaves().printNode(tn, 3);
    }


    public int printNode(BT tn, int k) {
        if (tn == null) {
            return 0;
        }
        if (tn.getLeft() == null && tn.getRight() == null) {
            return 1;
        }
        int kSum = printNode(tn.getLeft(), k) + printNode(tn.getRight(), k);
        if (kSum == k) {
            System.out.println(tn.getData());
        }
        return kSum;
    }

}
