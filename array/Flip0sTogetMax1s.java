package array;

public class Flip0sTogetMax1s {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        new Flip0sTogetMax1s().flip1(a, 1);
    }


    public void flip1(int[] a, int m) {
        int wl = 0;
        int wr = 0;
        int z = 0;
        int maxLen = Integer.MIN_VALUE;
        int ind = 0;
        while (wr < a.length) {
            if (z <= m) {
                if (a[wr] == 0) {
                    z++;
                }
                wr++;
            }
            if (z > m) {
                if (a[wl] == 0) {
                    z--;
                }
                wl++;
            }
            if (wr - wl > maxLen) {
                maxLen = wr - wl;
                ind = wl;
            }
        }
        //System.out.println(maxLen);
        for (int i = 0; i < maxLen; i++) {
            if (maxLen + i < a.length && a[maxLen + i] == 0) {
                System.out.println((maxLen + i));
            }
        }
    }


    public void flip(int[] a, int m) {
        int len = Integer.MIN_VALUE;
        int en = 0;
        for (int i = 0; i < a.length; i++) {
            int z = 0;
            for (int j = i; j < a.length; j++) {
                if (a[j] == 0) {
                    z++;
                }
                if (z <= m) {
                    if (len < (j - i + 1)) {
                        len = j - i + 1;
                        en = i;
                    }
                } else {
                    break;
                }
            }
        }
        //System.out.println(len);
        for (int i = 0; i < len; i++) {
            if (a[en + i] == 0) {
                System.out.println((en + i));
            }
        }
    }

}
