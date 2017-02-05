package string;

/*http://www.geeksforgeeks.org/function-to-find-number-of-customers-who-could-not-get-a-computer/*/

public class NumberOfCustomer {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new NumberOfCustomer().numberOfCustomer("ABCBCADEED", 1));
    }

    public int numberOfCustomer(String str, int n) {
        int res = 0;
        int[] need = new int[26];
        int out = 0;
        for (int i = 0; i < str.length(); i++) {
            int ind = str.charAt(i) - 'A';
            if (need[ind] == 0) {
                need[ind] = 1;
                if (out < n) {
                    out++;
                    need[ind] = 2;
                } else {
                    res++;
                }
            } else {
                if (need[ind] == 2) {
                    out--;
                }
                need[ind] = 0;
            }
        }
        return res;
    }


}

