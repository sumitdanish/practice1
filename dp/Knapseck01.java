package dp;

public class Knapseck01 {

    static int[][] dp;

    public Knapseck01(int row, int col) {
        // TODO Auto-generated constructor stub
        dp = new int[row + 1][col + 1];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] v = {60, 100, 120};
        int[] w = {10, 20, 30};
        int W = 50;
        Knapseck01 k = new Knapseck01(W, v.length);
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= v.length; j++) {
                dp[i][j] = 0;
            }
        }
        int m = k.maxWeight2(w, v, W, w.length);
        System.out.println(m);
    }

	/*recursion*/

    public int maxWeight(int[] w, int[] v, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }
        if (w[n - 1] > W) {
            return maxWeight(w, v, W, n - 1);
        } else {
            return max(v[n - 1] + maxWeight(w, v, W - w[n - 1], n - 1), maxWeight(w, v, W, n - 1));
        }
    }

	/*topdown*/

    public int maxWeight1(int[] w, int[] v, int W, int n) {
        if (dp[W][n] != -1) {
            return dp[W][n];
        }
        if (W == 0 || n == 0) {
            return 0;
        }
        if (w[n - 1] > W) {
            dp[W][n] = maxWeight1(w, v, W, n - 1);
        } else {
            dp[W][n] = max((v[n - 1] + maxWeight1(w, v, W - w[n - 1], n - 1)), maxWeight1(w, v, W, n - 1));
        }
        return dp[W][n];
    }

    public int maxWeight2(int[] w, int[] v, int W, int n) {
        int[][] dp1 = new int[W + 1][n + 1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= n; j++) {
                dp1[i][j] = 0;
            }
        }

        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp1[i][j] = 0;
                } else if (w[j - 1] > i) {
                    dp1[i][j] = dp1[i][j - 1];
                } else {
                    dp1[i][j] = max(v[j - 1] + dp1[W - w[j - 1]][j - 1], dp1[i][j - 1]);
                }
            }
        }
        return dp1[W][n];
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }


}
