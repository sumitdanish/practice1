package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FullBInaryTree {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("dt.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        System.out.println(new FullBInaryTree().fullBinaryTree(tn));

    }

    public int fullBinaryTree(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        if (tn.getLeft() != null && tn.getRight() != null) {
            return 1 + fullBinaryTree(tn.getLeft()) + fullBinaryTree(tn.getRight());
        }
        return 0;
    }
}
