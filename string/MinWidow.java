package string;

public class MinWidow {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "ABBACBAA";
        String p = "BAA";
        new MinWidow().minWindow(s, p);
    }


    public void minWindow(String s, String p) {
        int b = 0;
        int e = 0;
        int count = 0;
        int minWin = Integer.MAX_VALUE;
        int st = 0;
        int end = 0;
        int winLen = 0;
        int[] need = new int[256];
        int[] has = new int[256];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i)]++;
        }
        for (b = 0, e = 0; e < s.length(); e++) {
            if (need[s.charAt(e)] == 0) {
                continue;
            }
            has[s.charAt(e)]++;
            if (has[s.charAt(e)] <= need[s.charAt(e)]) {
                count++;
            }
            if (count == p.length()) {
                while (need[s.charAt(b)] == 0 || has[s.charAt(b)] > need[p.charAt(b)]) {
                    if (has[s.charAt(b)] > need[p.charAt(b)]) {
                        has[s.charAt(b)]--;
                    }
                    b++;
                }
                winLen = e - b + 1;
                if (winLen < minWin) {
                    st = b;
                    end = e;
                    minWin = winLen;
                }
            }

        }
        System.out.println(minWin + " : " + st + " : " + end);
    }
}
