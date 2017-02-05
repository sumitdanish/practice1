package string;

public class LongestPalindromeSubString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] ch = "forgeeksskeegfor".toCharArray();
        new LongestPalindromeSubString().longest(ch);
    }

    public void longest(char[] ch) {
        boolean[][] temp = new boolean[ch.length][ch.length];
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < ch.length; i++) {
            temp[i][i] = true;
        }
        for (int i = 0; i < ch.length - 1; i++) {
            if (ch[i] == ch[i + 1]) {
                maxLength = 2;
                start = i;
                temp[i][i + 1] = true;
            }
        }
        for (int i = 3; i <= ch.length; i++) {
            for (int j = 0; j < ch.length - i + 1; j++) {
                int k = i + j - 1;
                if (temp[j + 1][k - 1] && ch[j] == ch[k]) {
                    temp[j][k] = true;
                    if (i > maxLength) {
                        start = j;
                        maxLength = i;
                    }

                }
            }
        }
        System.out.println(start + " : " + maxLength);
    }

}
