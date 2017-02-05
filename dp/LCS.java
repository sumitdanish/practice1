package dp;

public class LCS {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] str1 = "ABCDGH".toCharArray();
        char[] str2 = "AEDFHR".toCharArray();
        int lcs = new LCS().lcs1(str1, str2, str1.length, str2.length);
        System.out.println(lcs);
    }


    public int lcs(char[] str1, char[] str2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (str1[m - 1] == str2[n - 1]) {
            return 1 + lcs(str1, str2, m - 1, n - 1);
        } else {
            return max(lcs(str1, str2, m, n - 1), lcs(str1, str2, m - 1, n));
        }
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }


    public int lcs1(char[] str1, char[] str2, int m, int n) {
        int[][] s = new int[n + 1][m + 1];
        for (int i = 0; i < m; i++) {
            s[0][i] = 1;
        }
        for (int j = 0; j < n; j++) {
            s[j][0] = 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    s[i][j] = 0;
                } else if (str2[i - 1] == str1[j - 1]) {
                    s[i][j] = 1 + s[i - 1][j - 1];
                } else {
                    s[i][j] = max(s[i][j - 1], s[i - 1][j]);
                }
            }
        }
        return s[n][m];
    }
}
