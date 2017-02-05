package dp;

public class LongestPalindrome {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] str = "GEEKSFORGEEKS".toCharArray();
        int len = new LongestPalindrome().maxLen1(str.length - 1, str);
        System.out.println(len);
    }

    public int maxLen(int n, int m, char[] str) {
        if (n == m) {
            return 1;
        }
        if (str[n] == str[m] && n + 1 == m) {
            return 2;
        }
        if (str[n] == str[m]) {
            return 2 + maxLen(n + 1, m - 1, str);
        } else {
            return max(maxLen(n + 1, m, str), maxLen(n, m - 1, str));
        }
    }

    public int maxLen1(int n, char[] str) {
        int[][] len = new int[n][n];
        for (int i = 0; i < n; i++) {
            len[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int y = 0; y < n - i + 1; y++) {
                int j = y + i - 1;
                if (str[y] == str[j] && i == 2) {
                    len[y][j] = 2;
                } else if (str[y] == str[j]) {
                    len[y][j] = 2 + len[y + 1][j - 1];
                } else {
                    len[y][j] = max(len[y + 1][j], len[y][j - 1]);
                }
            }
        }
        return len[0][n - 1];
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
