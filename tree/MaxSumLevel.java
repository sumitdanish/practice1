package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxSumLevel {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("tree.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        new MaxSumLevel().maxSumLevel(tn);
    }

    public void maxSumLevel(TreeNode tn) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        q1.add(tn);
        int n = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (true) {

            n = q1.size();
            int x = n;
            sum = 0;
            while (n > 0) {
                TreeNode t = q1.poll();
                sum += t.getData();
                if (t.getLeft() != null) {
                    q1.add(t.getLeft());
                }
                if (t.getRight() != null) {
                    q1.add(t.getRight());
                }
                n--;
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (q1.size() == 0) {
                System.out.println("N : " + maxSum);
                break;
            }
        }
    }

}
