package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoubleTree {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("dt.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        ct.inOrder(tn);
        System.out.println();
        new DoubleTree().doubleTree(tn);
        ct.inOrder(tn);
    }

    public void doubleTree(TreeNode tn) {
        if (tn == null) {
            return;
        }
        doubleTree(tn.getLeft());
        doubleTree(tn.getRight());
        TreeNode t = tn.getLeft();
        tn.setLeft(new TreeNode(tn.getData()));
        tn.getLeft().setLeft(t);
    }
}
