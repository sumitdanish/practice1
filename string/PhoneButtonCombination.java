package string;

import java.util.HashMap;
import java.util.Map;

public class PhoneButtonCombination {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(1, ".");
        map.put(0, " ");
        String s = "23";
        int index = 0;
        char[] ch = new char[s.length()];
        new PhoneButtonCombination().phoneCombination(s, map, index, ch);
    }

    public void phoneCombination(String s, Map<Integer, String> map, int index, char[] ch) {
        if (index == s.length()) {
            System.out.println(String.valueOf(ch));
            return;
        }
        String p = map.get(Integer.parseInt(String.valueOf(s.charAt(index))));
        for (int i = 0; i < p.length(); i++) {
            ch[index] = p.charAt(i);
            phoneCombination(s, map, index + 1, ch);
        }
    }
}
