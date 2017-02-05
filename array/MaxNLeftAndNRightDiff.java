package array;

import java.util.Stack;

public class MaxNLeftAndNRightDiff {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {2, 4, 8, 7, 7, 9, 3};
        new MaxNLeftAndNRightDiff().diff(a);
    }

    public void diff(int[] a) {
        int[] ls = new int[a.length];
        int min = 0;
        ls[0] = 0;
        lsrs(a, ls);
        for (int l : ls) {
            System.out.print(l + ",");
        }
    }

    public void lsrs(int[] a, int[] ls) {
        Stack<Integer> st = new Stack<Integer>();
        int ele = 0;
        ls[0] = 0;
        //st.push(a[0]);
        for (int i = 0; i < a.length; i++) {
            while (!st.isEmpty() && st.peek() >= a[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ls[i] = st.peek();
            } else {
                ls[i] = 0;
            }
            st.push(a[i]);

        }
    }


    public void reverse(int[] a) {
        int i = 0;
        int j = a.length;
        while (i <= j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

}
