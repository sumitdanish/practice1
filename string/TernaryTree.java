package string;

public class TernaryTree {


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] st = {"boats", "boat", "bat", "rat", "cat", "studio"};
        TernaryTree t = new TernaryTree();
        TernaryNode root = null;
        for (String s : st) {
            root = t.insert(root, s, 0);
        }
        boolean b = t.search("bat", root);
        System.out.println(b);

    }


    public TernaryNode insert(TernaryNode root, String word, int pos) {
        if (root == null) {
            if (word.length() <= pos) {
                return root;
            }
            root = new TernaryNode(word.charAt(pos));
            root.setLeft(null);
            root.setRight(null);
            root.setMid(null);
            if (pos == word.length() - 1) {
                root.setEnd(true);
                return root;
            } else {
                root.setMid(insert(root, word, pos + 1));
            }
        }
        if (word.charAt(pos) < root.getCh()) {
            root.setLeft(insert(root.getLeft(), word, pos));
        } else if (word.charAt(pos) == root.getCh()) {
            if (word.length() - 1 == pos) {
                root.setEnd(true);
            } else {
                root.setMid(insert(root.getMid(), word, pos + 1));
            }
        } else {
            root.setRight(insert(root.getRight(), word, pos));
        }
        return root;
    }

    public boolean search(String word, TernaryNode root) {
        int pos = 0;
        while (root != null && pos < word.length()) {
            char ch = word.charAt(pos);
            if (ch < root.getCh()) {
                root = root.getLeft();
            } else if (ch == root.getCh()) {
                if (word.length() - 1 == pos && root.isEnd()) {
                    return true;
                }
                pos++;
            } else {
                root = root.getRight();
            }
        }
        return false;
    }

}
