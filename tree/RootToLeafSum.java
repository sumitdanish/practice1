package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RootToLeafSum {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        Scanner sc = new Scanner(new File("tree.txt"));
        CreateTree ct = new CreateTree();
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        int sum = 17;
        System.out.println(new RootToLeafSum().isPathSum(tn, sum));
    }


    public boolean isPathSum(TreeNode tn, int sum) {
        boolean ans = false;
        if (tn == null && sum == 0) {
            return true;
        }
        if (sum == 0 && tn.getLeft() == null && tn.getRight() == null) {
            return true;
        }
        if (tn.getLeft() != null) {
            sum = sum - tn.getData();
            ans = ans || isPathSum(tn.getLeft(), sum);
        }
        if (tn.getRight() != null) {
            sum = sum - tn.getData();
            ans = ans || isPathSum(tn.getRight(), sum);
        }
        return ans;

    }

}
