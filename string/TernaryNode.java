package string;

public class TernaryNode {

    private Character ch;
    private TernaryNode left;
    private TernaryNode right;
    private TernaryNode mid;
    private boolean end;

    public TernaryNode(Character ch) {
        this.ch = ch;
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    public TernaryNode getLeft() {
        return left;
    }

    public void setLeft(TernaryNode left) {
        this.left = left;
    }

    public TernaryNode getRight() {
        return right;
    }

    public void setRight(TernaryNode right) {
        this.right = right;
    }

    public TernaryNode getMid() {
        return mid;
    }

    public void setMid(TernaryNode mid) {
        this.mid = mid;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }


}
