package string;

public class LCSInString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        char[] ch1 = "ABCDGH".toCharArray();
        char[] ch2 = "AEDFHR".toCharArray();
        //System.out.println(new LCSInString().lengthOfMaxOfLCS(ch1, ch2, ch1.length, ch2.length));
        new LCSInString().lcsLength(ch1, ch2);

    }

    public int lengthOfMaxOfLCS(char[] ch1, char[] ch2, int n, int m) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (ch1[n - 1] == ch2[m - 1]) {
            return 1 + lengthOfMaxOfLCS(ch1, ch2, n - 1, m - 1);
        } else {
            return max(lengthOfMaxOfLCS(ch1, ch2, n - 1, m), lengthOfMaxOfLCS(ch1, ch2, n, m - 1));
        }
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public void lcsLength(char[] ch1, char[] ch2) {
        int[][] lcs = new int[ch1.length + 1][ch2.length + 1];
        int i = 0;
        int j = 0;
        for (i = 0; i <= ch1.length; i++) {
            for (j = 0; j <= ch2.length; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (ch1[i - 1] == ch2[j - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        char[] ch3 = new char[lcs[i - 1][j - 1]];
        int x = lcs[i - 1][j - 1];
        System.out.println(x);
        j = ch2.length;
        i = ch1.length;

        while (i > 0 && j > 0) {
            if (x > 0 && ch1[i - 1] == ch2[j - 1]) {
                ch3[x - 1] = ch1[i - 1];
                i--;
                j--;
                x--;
            } else if (lcs[i - 1][j] > lcs[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(String.valueOf(ch3));

    }

}
