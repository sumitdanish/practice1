package array;

public class ArrayRotation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7};
        new ArrayRotation().rotate2(a, 2);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }

    public void rotate2(int[] a, int d) {
        revers1(a, 0, d - 1);
        revers1(a, d, a.length - 1);
        revers1(a, 0, a.length - 1);
    }

    public void revers1(int[] a, int s, int e) {
        while (s < e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }


    public void reverse(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            int temp = a[0];
            for (int x = 0; x < a.length - 1; x++) {
                a[x] = a[x + 1];
            }
            a[a.length - 1] = temp;
        }
    }

}
