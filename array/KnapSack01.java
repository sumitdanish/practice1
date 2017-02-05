package array;

public class KnapSack01 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int w = 50;
        int n = 3;
        System.out.println(new KnapSack01().maxValDP(wt, val, n, w));
    }

    public int maxVal(int[] wt, int[] val, int n, int w) {
        if (n == 0) {
            return 0;
        }
        if (wt[n - 1] > w) {
            return maxVal(wt, val, n - 1, w);
        }
        return max((val[n - 1] + maxVal(wt, val, n - 1, w - wt[n - 1])), maxVal(wt, val, n - 1, w));
    }


    public int maxValDP(int[] wt, int[] val, int n, int w) {
        int[][] dp = new int[w + 1][n + 1];
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (i - wt[j - 1] >= 0) {
                    dp[i][j] = max((val[j - 1] + dp[i - wt[j - 1]][j - 1]), dp[i][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[w][n];
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

}
