package dp;

public class EggsDroping {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int f = 36;
        int n = 2;
        int m = new EggsDroping().eggs1(n, f);
        System.out.println(m);
    }

    public int eggs1(int e, int f) {
        int[][] m = new int[e + 1][f + 1];
        for (int i = 1; i <= e; i++) {
            m[i][1] = 1;
            m[i][0] = 0;
        }
        for (int i = 1; i <= f; i++) {
            m[1][i] = i;
        }
        int res = 0;
        for (int i = 2; i <= e; i++) {
            for (int j = 2; j <= f; j++) {
                m[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    res = 1 + max(m[i - 1][x - 1], m[i][j - x]);
                    if (m[i][j] > res) {
                        m[i][j] = res;
                    }
                }
            }
        }
        return m[e][f];
    }

    public int eggs(int e, int f) {
        if (f == 1 || f == 0) {
            return f;
        }
        if (e == 1) {
            return f;
        }
        int res;
        int max1 = Integer.MAX_VALUE;
        int i;
        for (i = 1; i <= f; i++) {
            res = max(eggs(e - 1, i - 1), eggs(e, f - i));
            if (res < max1) {
                max1 = res;
            }
        }
        return max1 + 1;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

}
