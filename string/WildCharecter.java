package string;

public class WildCharecter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String pattern = "ba*ab?ab";
        String input = "baaablab";
        System.out.println(new WildCharecter().isPatternMatch(input, pattern));

    }

    public boolean isPatternMatch(String input, String pattern) {
        if (input.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (pattern.length() > 0 && input.length() == 0 && pattern.charAt(0) == '*') {
            return false;
        }
        if ((pattern.length() > 0 && pattern.charAt(0) == '?') || ((input.length() > 0 && pattern.length() > 0) && (input.charAt(0) == pattern.charAt(0)))) {
            return isPatternMatch(input.substring(1), pattern.substring(1));
        }
        if (input.length() > 0 && pattern.length() > 0 && pattern.charAt(0) == '*') {
            return isPatternMatch(input.substring(1), pattern.substring(0))
                    || isPatternMatch(input.substring(0), pattern.substring(1));
        }
        return false;
    }

    public boolean isPatternMatch1(String input, String pattern) {
        boolean[][] in = new boolean[input.length() + 1][pattern.length() + 1];
        in[0][0] = true;
        for (int i = 1; i <= pattern.length(); i++) {
            if (pattern.charAt(i - 1) == '*') {
                in[0][i] = in[0][i - 1];
            }
        }
        for (int i = 1; i <= input.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if (pattern.charAt(j - 1) == '*') {
                    in[i][j] = in[i - 1][j] || in[i][j - 1];
                } else if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == input.charAt(i - 1)) {
                    in[i][j] = in[i - 1][j - 1];
                } else {
                    in[i][j] = false;
                }
            }
        }
        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                System.out.print(in[i][j] + ",");
            }
            System.out.println();
        }
        return in[input.length()][pattern.length()];
    }

}
