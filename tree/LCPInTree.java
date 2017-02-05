package tree;

public class LCPInTree {

    static int maxLCP = Integer.MIN_VALUE;
    static BT b = new BT();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LCPInTree l = new LCPInTree();
        BT ct = new BT();
        BT c = ct.getBT();
        l.lcpInBT(c, 1);
        System.out.println(maxLCP + " : " + b.getData());
        l.printPath(c, b);
    }


    public boolean printPath(BT b, BT target) {
        if (b == null) {
            return false;
        }
        if (b.getData() == target.getData() ||
                printPath(b.getLeft(), target)
                || printPath(b.getRight(), target)) {
            System.out.print(b.getData() + ",");
            return true;
        }
        return false;

    }


    public void lcpInBT(BT bt, int count) {
        if (bt == null) {
            return;
        }
        if (bt.getLeft() != null && bt.getRight() != null) {
            if (bt.getLeft().getData() > bt.getRight().getData()
                    && bt.getData() < bt.getLeft().getData()
                    && bt.getData() > bt.getRight().getData()) {
                lcpInBT(bt.getLeft(), count);
            } else {
                lcpInBT(bt.getRight(), count);
            }
            count++;
        } else if (bt.getLeft() != null && bt.getRight() == null) {
            count++;
            lcpInBT(bt.getLeft(), count);
        } else if (bt.getRight() != null && bt.getLeft() == null) {
            count++;
            lcpInBT(bt.getRight(), count);
        }
        if (maxLCP < count && bt.getLeft() == null && bt.getRight() == null) {
            b = bt;
            maxLCP = count;
        }
        lcpInBT(bt.getLeft(), count);
        lcpInBT(bt.getRight(), count);
    }

}
