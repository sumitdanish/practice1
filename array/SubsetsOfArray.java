package array;

public class SubsetsOfArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] b = {1, 2, 3};
        int[] a = new int[b.length];
        new SubsetsOfArray().subset(a, b, 0);
    }

    public void subset(int[] a, int[] b, int len) {
        if (len == a.length - 1) {
            a[len] = 0;
            print(a, b);
            a[len] = 1;
            print(a, b);
            return;
        }
        if (len < a.length) {
            a[len] = 0;
            subset(a, b, len + 1);
            a[len] = 1;
            subset(a, b, len + 1);
        }
    }

    public void print(int[] a, int[] b) {
        boolean isEmpty = false;
        System.out.print("{");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                System.out.print(b[i] + ",");
                isEmpty = true;
            }
        }
        if (isEmpty) {
            System.out.print("}");
        } else {
            System.out.print(" * }");
        }
    }
}
