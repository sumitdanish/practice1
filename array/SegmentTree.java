package array;

public class SegmentTree {

    static int[] st;

    public SegmentTree(int n) {
        st = new int[2 * n + 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-1, 3, 4, 0, 2, 1};
        SegmentTree se = new SegmentTree(a.length);
        se.buildTree(0, 0, a.length - 1, a);
//		for(int s : st){
//			System.out.print(s+",");
//		}
        int x = se.query(0, 0, a.length, 2, 5);
        System.out.println(x);
    }

    public void buildTree(int node, int start, int end, int[] array) {
        if (start > end) {
            return;
        }

        if (start == end) {
            st[node] = array[start];
            return;
        }
        int mid = (start + end) / 2;
        if (2 * node + 1 < st.length) {
            buildTree(2 * node + 1, start, mid, array);
        }
        if (2 * node + 2 < st.length) {
            buildTree(2 * node + 2, mid + 1, end, array);
        }
        st[node] = min(st[2 * node + 1], st[2 * node + 2]);
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }

    public int query(int node, int start, int end, int min, int max) {
        if (start <= min && end >= max) {
            return st[node];
        }
        System.out.println("sjdhkjsh");
        int mid = (start + end) / 2;
        int x1 = query(2 * node + 1, start, mid, min, max);
        int x2 = query(2 * node + 2, mid + 1, end, min, max);
        return min(x1, x2);
    }
}
