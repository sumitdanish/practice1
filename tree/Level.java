package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Level {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("tree.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        new Level().level(tn);
    }


    public void level(TreeNode tn) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(0);
        q2.add(tn);
        while (!q2.isEmpty()) {
            TreeNode t = q2.poll();
            if (t.getLeft() != null) {
                q2.add(t.getLeft());
            }
            if (t.getRight() != null) {
                q2.add(t.getRight());
            }
            q1.add(q1.poll() + 1);
        }
    }
}
