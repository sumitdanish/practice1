package string;

public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] ch = "geeksskeeg".toCharArray();
        System.out.println(new LongestPalindromeSubsequence().longestLength(ch, 0, ch.length - 1));
    }

    public int longestLength(char[] ch, int st, int en) {
        if (st == en) {
            return 1;
        }
        if (ch[st] == ch[en] && st + 1 == en) {
            return 2;
        }
        if (ch[st] == ch[en]) {
            return 2 + longestLength(ch, st + 1, en - 1);
        }
        return max(longestLength(ch, st + 1, en), longestLength(ch, st, en - 1));
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int longestLength(char[] ch) {
        int maxLen = 0;
        int[][] len = new int[ch.length + 1][ch.length + 1];
        for (int i = 0; i < ch.length; i++) {
            len[i][i] = 1;
        }
        for (int i = 2; i <= ch.length; i++) {
            for (int j = 0; j < ch.length - i + 1; j++) {
                int x = j + i - 1;
                if (ch[j] == ch[x] && i == 2) {
                    len[j][x] = 2;
                } else if (ch[j] == ch[x]) {
                    len[j][x] = 2 + len[j + 1][x - 1];
                } else {
                    len[j][x] = max(len[j + 1][x], len[j][x - 1]);
                }
            }
        }
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                System.out.print(len[i][j] + ",");
            }
            System.out.println();
        }
        maxLen = len[0][ch.length - 1];
        return maxLen;
    }
}
