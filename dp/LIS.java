package dp;

public class LIS {

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int k = new LIS().lcs1(a, a.length);
        System.out.println(k);
    }


    public int lcs1(int[] a, int n) {
        int max_len = Integer.MIN_VALUE;
        int[] lcs = new int[n];
        for (int i = 0; i < n; i++) {
            lcs[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && 1 + lcs[j] > lcs[i]) {
                    lcs[i] = 1 + lcs[j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (max_len < lcs[i]) {
                max_len = lcs[i];
            }
        }
        return max_len;
    }

    public int lcs(int[] a, int n) {
        if (n == 1) {
            return 1;
        }
        int res = 1;
        int max_len_end = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            res = lcs(a, i);
            if (a[i - 1] < a[n - 1] && 1 + res > max_len_end) {
                max_len_end = 1 + res;
            }
        }
        if (max < max_len_end) {
            max = max_len_end;
        }
        return max_len_end;
    }

}
