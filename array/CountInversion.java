package array;

public class CountInversion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {8, 4, 2, 1};
        System.out.println(new CountInversion().inversion1(a));
    }

    public int inversion1(int[] a) {
        int inv = 0;
        for (int i = 0; i < a.length - 2; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    for (int k = j + 1; k < a.length; k++) {
                        if (a[j] > a[k]) {
                            inv++;
                        }
                    }
                }
            }
        }
        return inv;
    }

    public int inversion(int[] a) {
        int inv = 0;
        for (int i = 1; i < a.length; i++) {
            int gre = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[i]) {
                    gre++;
                }
            }
            int smal = 0;
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    smal++;
                }
            }
            inv += gre * smal;
        }
        return inv;

    }

}
