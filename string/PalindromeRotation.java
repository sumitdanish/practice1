package string;

public class PalindromeRotation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "aaaab";
        //System.err.println(s.substring(2,3));
        boolean b = new PalindromeRotation().isPlindromeRotation(s);
        System.out.println(b);
        //System.out.println(new PalindromeRotation().isPalindrome(s));
    }

    public boolean isPlindromeRotation(String str) {
        boolean flag = false;
        if (str == null || str.length() == 1) {
            return true;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            String str1 = str.substring(i + 1, str.length());
            String str2 = str.substring(0, i + 1);
            if (isPalindrome(str1 + str2) && (str1 + str2).length() == str.length()) {
                return true;
            }
        }
        return flag;
    }

    public boolean isPalindrome(String str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 1) {
            return true;
        }
        return (str.charAt(0) == str.charAt(str.length() - 1) && isPalindrome(str.substring(1, str.length() - 1)));
    }

}
