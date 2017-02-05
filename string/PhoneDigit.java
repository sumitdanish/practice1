package string;

import java.util.HashMap;
import java.util.Map;

public class PhoneDigit {

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
        int[] num = {2, 4, 6, 1, 0, 5};
        char[] ch = new char[num.length + 1];
        new PhoneDigit().phoneDigit(map, num, 0, ch, num.length);

    }

    public void phoneDigit(Map<Integer, String> map, int[] num, int count, char[] ch, int len) {
        if (count == len) {
            System.out.println(String.valueOf(ch));
            return;
        }

        for (int i = 0; i < map.get(num[count]).length(); i++) {
            if (num[count] == 0) {
                ch[count] = ' ';
            }
            if (num[count] == 1) {
                ch[count] = '.';
            } else {
                ch[count] = map.get(num[count]).charAt(i);
            }
            phoneDigit(map, num, count + 1, ch, len);
        }
    }

}
