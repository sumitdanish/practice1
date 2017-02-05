package string;

public class SubStringByIteration {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "ABCDABC";
        boolean f = new SubStringByIteration().isSubstring(str);
        System.out.println(f);
    }

    public boolean isSubstring(String str) {
        boolean flag = false;
        int lp = lps(str)[str.length() - 1];
        System.out.println(lp);
        if (str.length() % (str.length() - lp) == 0) {
            flag = true;
        }
        return flag;
    }


    public int[] lps(String str) {
        int[] lp = new int[str.length()];
        int i = 0;
        int j = 1;
        for (; j < str.length(); j++) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                lp[j] = i;
            } else {
                if (i > 0) {
                    i = lp[i - 1];
                }
            }
        }
        return lp;
    }
}
