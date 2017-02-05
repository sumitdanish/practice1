package string;

public class Combination {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abc";
        new Combination().combination(s, "");
    }

    public void combination(String s, String result) {
        int len = result.trim().length();
        if (len != 0) {
            System.out.println(result);
        }
        for (int i = 0; i < s.length(); i++) {
            combination(s.substring(i + 1), result + s.charAt(i));
        }
    }
}
