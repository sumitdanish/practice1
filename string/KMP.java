package string;

public class KMP {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        KMP k = new KMP();
        String pattern = "igg";
        String input = "abxabcabcaby";
        for (int l : new KMP().lps(pattern)) {
            System.out.print(l + ",");
        }
        //k.match(input, pattern);
    }

    public void match(String input, String pattern) {
        int i = 0;
        int j = 0;
        int[] lp = lps(pattern);

        while (i < input.length()) {
            if (input.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
                if (j == pattern.length()) {
                    System.out.println("String is matched at : " + (i - j));
                    j = lp[j - 1];
                }
            } else {
                if (j > 0) {
                    j = lp[j - 1];
                } else {
                    i++;
                }
            }
        }

    }

    private int[] lps(String p) {
        int[] lp = new int[p.length()];
        int i = 1;
        int len = 0;
        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                lp[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lp[len - 1];
                } else {
                    lp[len] = 0;
                    i++;
                }
            }
        }
        return lp;
    }
}
