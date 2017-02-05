package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxDepthOrHeightOfTree {

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
        System.out.println(new MaxDepthOrHeightOfTree().maxHeightOrDepth(tn));
    }

    public int maxHeightOrDepth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return max(maxHeightOrDepth(tree.getLeft()), maxHeightOrDepth(tree.getRight())) + 1;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
