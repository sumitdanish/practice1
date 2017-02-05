package tree;

public class CreateTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public TreeNode createTree(TreeNode tn, int data) {
        TreeNode tree = new TreeNode(data);
        if (tn == null) {
            tn = tree;
            return tn;
        }
        if (tn.getData() > data) {
            tn.setLeft(createTree(tn.getLeft(), data));
        } else {
            tn.setRight(createTree(tn.getRight(), data));
        }
        return tn;
    }

    public void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.getLeft());
            System.out.print(tree.getData() + ",");
            inOrder(tree.getRight());
        }
    }
}
