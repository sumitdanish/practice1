package string;

public class PatternInExistingString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "engrineers rock";
        String pattern = "egr";
        System.out.println(new PatternInExistingString().isExistPattern(s, pattern));
    }

    public boolean isExistPattern(String s, String pattern) {
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int c = pattern.indexOf(s.charAt(i));
            System.out.println(c);
            if (c + 1 > max) {
                max = c + 1;
            }
            if (c + 1 < max && c != -1) {
                return false;
            }
        }
        return true;
    }
}
