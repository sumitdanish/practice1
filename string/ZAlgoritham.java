package string;

import java.util.ArrayList;
import java.util.List;

public class ZAlgoritham {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "aaabcxyzaaaabczaaczabbaaaaaabc";
        String pattern = "aaabc";
        new ZAlgoritham().getSubstring(input, pattern);

    }

    public void getSubstring(String input, String pattern) {
        List<Integer> list = new ArrayList<>();
        int[] zind = zIndex(input);
        for (int i = 0; i < input.length(); i++) {
            if (zind[i] == pattern.length()) {
                list.add(i - pattern.length() - 1);
            }
        }
        for (int len : list) {
            System.out.println(len + ",");
        }
    }

    private int[] zIndex(String input) {
        int[] zind = new int[input.length()];
        int l = 0;
        int r = 0;
        int k = 0;
        zind[0] = 0;
        for (k = 1; k < input.length(); k++) {
            if (k > r) {
                l = r = k;
                while (r < input.length() && input.charAt(r) == input.charAt(r - l)) {
                    r++;
                }
                zind[k] = r - l;
                r--;
            } else {
                int k1 = k - l;
                if (zind[k1] < r - k + 1) {
                    zind[k] = zind[k1];
                } else {
                    l = k;
                    while (r < input.length() && input.charAt(r) == input.charAt(r - l)) {
                        r++;
                    }
                    zind[k] = r - l;
                    r--;
                }
            }
        }
        return zind;
    }

}
