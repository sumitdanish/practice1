package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MirrorOfTree {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("tree.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        ct.inOrder(tn);
        System.out.println();
        new MirrorOfTree().mirror(tn);
        ct.inOrder(tn);
    }


    public void mirror(TreeNode tn) {
        if (tn == null) {
            return;
        }
        mirror(tn.getLeft());
        mirror(tn.getRight());
        TreeNode t = tn.getLeft();
        tn.setLeft(tn.getRight());
        tn.setRight(t);
    }

}
