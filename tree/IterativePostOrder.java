package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class IterativePostOrder {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        TreeNode tn = null;
        CreateTree ct = new CreateTree();
        Scanner sc = new Scanner(new File("tree.txt"));
        for (String s : sc.next().split(",")) {
            int data = Integer.parseInt(s);
            tn = ct.createTree(tn, data);
        }
        new IterativePostOrder().postOrder1(tn);
    }

    private void postOrder(TreeNode tn) {
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        st1.push(tn);
        while (!st1.isEmpty()) {
            TreeNode t1 = st1.pop();
            st2.push(t1);
            if (t1 != null && t1.getLeft() != null) {
                st1.push(t1.getLeft());
            }
            if (t1 != null && t1.getRight() != null) {
                st1.push(t1.getRight());
            }
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.pop().getData() + ",");
        }
    }

    private void postOrder1(TreeNode tn) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        do {
            while (tn != null) {
                if (tn.getRight() != null) {
                    st.push(tn.getRight());
                }
                st.push(tn);
                tn = tn.getLeft();
            }
            if (!st.isEmpty()) {
                tn = st.pop();
                if (tn.getRight() != null && !st.isEmpty() && st.peek().getData() == tn.getRight().getData()) {
                    st.pop();
                    st.push(tn);
                    tn = tn.getRight();
                } else {
                    System.out.print(tn.getData() + ",");
                    tn = null;
                }
            }

        } while (!st.isEmpty());
    }

}
