package string;

public class SubstringOfUniqueCharecter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] ch = "aabacbebebe".toCharArray();
        int k = 3;
        new SubstringOfUniqueCharecter().countUniquChar(ch, k);
    }

    public boolean isValidCount(int[] count, int k) {
        int val = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                val++;
            }
        }
        return k >= val;
    }

    public void countUniquChar(char[] ch, int k) {
        try {
            int[] count = new int[26];
            int st = 0;
            int end = 0;
            int u = 0;
            int maxLen = 0;
            int maxWindowStart = 0;
            int maxEnd = 0;
            for (int i = 0; i < ch.length; i++) {
                if (count[ch[i] - 'a'] == 0) {
                    u++;
                }
                count[ch[i] - 'a']++;
            }
            if (u < k) {
                System.out.println("Matched char is less than given value !");
                return;
            }
            count = new int[26];
            count[ch[0] - 'a']++;
            for (int i = 1; i < ch.length; i++) {
                count[ch[i] - 'a']++;
                end++;
                boolean flag = isValidCount(count, k);
                while (!flag && st < ch.length) {
                    //System.out.println(ch[st]+" : "+st);
                    count[ch[st] - 'a']--;
                    st++;
                }
                if (end - st + 1 > maxLen) {
                    maxEnd = end;
                    maxLen = end - st + 1;
                    maxWindowStart = st;
                }
            }
            String s = String.valueOf(ch);
            System.out.println(s.substring(maxWindowStart, maxEnd + 1) + " : " + maxLen);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
