package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InOrderSuccessorPredecessopr {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        InOrderSuccessorPredecessopr i = new InOrderSuccessorPredecessopr();
        TreeNode tn = null;
        Scanner sc = new Scanner(new File("tree.txt"));
        CreateTree tr = new CreateTree();
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = tr.createTree(tn, data);
        }
        System.out.println(tn.getLeft().getData());
        TreeNode su = i.inOrder(tn, tn.getLeft());
        System.out.println(su.getData());
    }

    public TreeNode inOrder(TreeNode tn, TreeNode n) {
        if (tn == null) {
            return null;
        }
        if (n.getRight() != null) {
            return inOrderSuccNode(n.getRight());
        }
        TreeNode succ = null;
        while (tn != null) {
            if (n.getData() < tn.getData()) {
                succ = tn;
                tn = tn.getLeft();
            } else if (n.getData() > tn.getData()) {
                tn = tn.getRight();
            } else {
                break;
            }
        }
        if (succ == null) {
            System.out.println("null");
        }
        return succ;
    }

    public TreeNode inOrderSuccNode(TreeNode tn) {
        if (tn == null) {
            return null;
        }
        TreeNode t = tn.getLeft();
        while (t != null && t.getLeft() != null) {
            tn = tn.getLeft();
        }
        return tn.getLeft();
    }


}
