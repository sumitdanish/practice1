package dp;

public class MinCost {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[][] a = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        int minCost = new MinCost().minCost1(a, 2, 2);
        System.out.println(minCost);
    }

    public int minCost(int[][] a, int m, int n) {
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (m == 0 && n == 0) {
            return a[m][n];
        } else {
            return a[m][n] + min1(minCost(a, m - 1, n - 1), minCost(a, m - 1, n), minCost(a, m, n - 1));
        }
    }

    public int minCost1(int[][] a, int m, int n) {
        int[][] min = new int[m + 1][n + 1];
        min[0][0] = a[0][0];
        for (int i = 1; i <= m; i++) {
            min[i][0] = min[i - 1][0] + a[i][0];
        }
        for (int i = 1; i <= n; i++) {
            min[0][i] = min[0][i - 1] + a[0][i];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                min[i][j] = min1(min[i - 1][j - 1], min[i][j - 1], min[i - 1][j]) + a[i][j];
            }
        }
        return min[m][n];
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }

    public int min1(int a, int b, int c) {
        return min(a, b) > c ? c : min(a, b);
    }

}
