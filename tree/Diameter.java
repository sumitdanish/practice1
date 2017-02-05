package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diameter {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        TreeNode tn = null;
        Scanner sc = new Scanner(new File("tree.txt"));
        CreateTree ct = new CreateTree();
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        //System.out.println(tn.getLeft().getData());
        System.out.println(new Diameter().diameter(tn));
    }

    public int diameter(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        int lh = height(tn.getLeft());
        int rh = height(tn.getRight());

        int ld = diameter(tn.getLeft());
        int rd = diameter(tn.getRight());

        return max(lh + rh + 1, max(ld, rd));
    }

    public int height(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        return max(height(tn.getLeft()), height(tn.getRight())) + 1;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
