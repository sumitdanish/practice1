package string;

public class MinSubStringToEmpty {

    public static void main(String[] args) {
        String s = "1001001";
        s = s.replace('0', '_');
        System.out.println(new MinSubStringToEmpty().isMinSubSequence(s));

    }

    public boolean isPalindrome(String s, int i) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 2), i + 1);
        }
        return false;
    }

    public int isMinSubSequence(String p) {
        if (isPalindrome(p, 0)) {
            return 1;
        }
        return 2;
    }
}
