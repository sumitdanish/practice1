package string;

public class RankOfTheString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "STRING";
        System.out.println(new RankOfTheString().rank(str));
    }


    public int rank(String str) {
        int rank = 1;
        int x = 0;
        for (int i = 0; i < str.length(); i++) {
            x = 0;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) > str.charAt(j)) {
                    x++;
                }
            }
            rank += x * fact(str.length() - i - 1);
        }

        return rank;
    }

    public int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

}
