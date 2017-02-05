package dp;

public class Edit {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] str1 = "sunday".toCharArray();
        char[] str2 = "saturday".toCharArray();
        int edit = new Edit().edit1(str1, str2, str1.length, str2.length);
        System.out.println(edit);
    }


    public int edit(char[] str1, char[] str2, int m, int n) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (str1[m - 1] == str2[n - 1]) {
            return edit(str1, str2, m - 1, n - 1);
        } else {
            return 1 + min1(edit(str1, str2, m, n - 1),
                    edit(str1, str2, m - 1, n),
                    edit(str1, str2, m - 1, n - 1));
        }
    }


    public int edit1(char[] str1, char[] str2, int m, int n) {
        int[][] s = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    s[i][j] = j;
                } else if (j == 0) {
                    s[i][j] = i;
                } else if (str1[i - 1] == str2[j - 1]) {
                    s[i][j] = s[i - 1][j - 1];
                } else {
                    s[i][j] = 1 + (min1(s[i - 1][j], s[i][j - 1], s[i - 1][j - 1]));
                }
            }
        }
        return s[m][n];
    }


    public int min(int a, int b) {
        return a > b ? b : a;
    }

    public int min1(int a, int b, int c) {
        return min(a, b) > c ? c : min(a, b);
    }

}
