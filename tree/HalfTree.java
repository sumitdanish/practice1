package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HalfTree {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("dt.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        System.out.println(new HalfTree().halfTree(tn));
    }


    public int halfTree(TreeNode tn) {
        if (tn == null) {
            return 0;
        }
        if (tn.getLeft() == null && tn.getRight() == null) {
            return 0;
        }
        if (tn.getLeft() == null || tn.getRight() == null) {
            return 1;
        }
        return halfTree(tn.getLeft()) + halfTree(tn.getRight());
    }
}
