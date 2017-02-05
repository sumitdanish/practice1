package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WidthOfTree {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("tree.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        System.out.println(new WidthOfTree().maxWidth(tn));
    }

    public int maxWidth(TreeNode tn) {
        int maxWidth = Integer.MIN_VALUE;
        int h = height(tn);
        for (int i = 0; i <= h; i++) {
            int l = width(tn, i);
            if (maxWidth < l) {
                maxWidth = l;
            }
        }
        return maxWidth;
    }

    public int width(TreeNode tn, int depth) {
        if (tn == null) {
            return 0;
        }
        if (depth == 0) {
            return 1;
        }
        return width(tn.getLeft(), depth - 1) + width(tn.getRight(), depth - 1);
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
