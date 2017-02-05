package array;

import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {4, 5, 2, 32, 3, 25};
        new NextGreater().next1(a);
    }

    public void next(int[] a) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(a[0]);
        int next = 0;
        int val = 0;
        for (int i = 1; i < a.length; i++) {
            next = a[i];
            if (!st.isEmpty()) {
                val = st.pop();
                while (val < next) {
                    System.out.println(val + " > " + next);
                    if (st.isEmpty()) {
                        break;
                    }
                    val = st.pop();
                }
                if (val > next) {
                    st.push(val);
                }
            }
            st.push(next);
        }
        while (!st.isEmpty()) {
            System.out.println(st.pop() + " > " + "-1");
        }
    }

    public void next1(int[] a) {
        int max = a[a.length - 1];
        for (int i = a.length - 1; i >= 0; i--) {
            if (i + 1 < a.length && a[i] < a[i + 1]) {
                System.out.println(a[i] + " > " + a[i + 1]);
            } else if (a[i] < max) {
                System.out.println(a[i] + " > " + max);
            } else {
                System.out.println(a[i] + " > " + "-1");
            }
            if (i + 1 < a.length && a[i + 1] > max) {
                max = a[i + 1];
            }
        }
    }
}
