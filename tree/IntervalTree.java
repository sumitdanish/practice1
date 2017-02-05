package tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntervalTree {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(new File("int.txt"));
        IntervalTreeImpl interval = null;
        IntervalTree inter = new IntervalTree();
        while (sc.hasNext()) {
            String[] s = sc.next().split(",");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            Interval i = new Interval(x, y);
            interval = inter.intervalTree(i, interval);
        }
        inter.intOrder(interval);
    }

    public IntervalTreeImpl intervalTree(Interval in, IntervalTreeImpl tree) {
        if (tree == null) {
            IntervalTreeImpl i = new IntervalTreeImpl(in);
            tree = i;
            tree.setMax(in.getY());
            return tree;
        }
        if (in.getX() < tree.getInterval().getX()) {
            tree.setLeft(intervalTree(in, tree.getLeft()));
        } else {
            tree.setRight(intervalTree(in, tree.getRight()));
        }
        if (tree.getMax() <= in.getY()) {
            tree.setMax(in.getY());
        }
        return tree;
    }

    public boolean isOverlap(Interval in, IntervalTreeImpl tree) {
        Interval i1 = tree.getInterval();
        return i1.getY() <= in.getY() && in.getX() < i1.getY();
    }

    public IntervalTreeImpl overlap(IntervalTreeImpl tree, Interval interval) {
        if (tree == null) {
            return null;
        }
        if (isOverlap(interval, tree)) {
            return tree;
        }
        if (tree.getLeft() != null && interval.getX() <= tree.getMax()) {
            return overlap(tree.getLeft(), interval);
        } else {
            return overlap(tree.getRight(), interval);
        }
    }

    public void intOrder(IntervalTreeImpl tree) {
        if (tree != null) {
            intOrder(tree.getLeft());
            System.out.println("{ " + tree.getInterval().getX() + " : " + tree.getInterval().getY() + " : }" + tree.getMax());
            intOrder(tree.getRight());
        }
    }
}

class IntervalTreeImpl {
    private Interval interval;
    private int max;
    private IntervalTreeImpl left;
    private IntervalTreeImpl right;

    public IntervalTreeImpl(Interval interval) {
        // TODO Auto-generated constructor stub
        this.interval = interval;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public IntervalTreeImpl getLeft() {
        return left;
    }

    public void setLeft(IntervalTreeImpl left) {
        this.left = left;
    }

    public IntervalTreeImpl getRight() {
        return right;
    }

    public void setRight(IntervalTreeImpl right) {
        this.right = right;
    }
}

class Interval {
    private int x;
    private int y;

    public Interval(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
