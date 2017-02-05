package array;

public class Rearange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        new Rearange().rearange(a);
        System.out.println("Result-------");
        for (int k : a) {
            System.out.print(k + ",");
        }

    }

    public void rightRotate(int[] a, int end, int st) {
        int temp = a[st];
        for (int i = st; i > end; i--) {
            a[i] = a[i - 1];
        }
        a[end] = temp;
        for (int j : a) {
            System.out.print(j + ",");
        }
        System.out.println();
    }

    public void rearange(int[] a) {
        int o = -1;
        for (int ind = 0; ind < a.length; ind++) {
            if (o >= 0) {
                if ((a[ind] >= 0 && a[o] <= 0) || (a[ind] < 0 && a[o] >= 0)) {
                    rightRotate(a, o, ind);
                    if (ind - o > 2) {
                        o = o + 2;
                    } else {
                        o = -1;
                    }
                }
            }
            if (o == -1) {
                if ((a[ind] >= 0 && ind % 2 == 0) || (a[ind] < 0 && ind % 2 != 0)) {
                    o = ind;
                }
            }
        }
    }
}
