package string;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateAllBinary {

    public static void main(String[] args) {
        String s = "1??_?1_1";
        new GenerateAllBinary().printBinary(s);
    }

    public void printBinary(String s, int index) {
        if (index == s.length()) {
            System.out.println(s);
            return;
        }
        if (s.charAt(index) == '?') {
            char[] ch = s.toCharArray();
            ch[index] = '_';
            printBinary(String.valueOf(ch), index + 1);
            ch[index] = '1';
            printBinary(String.valueOf(ch), index + 1);
        } else {
            printBinary(s, index + 1);
        }
    }


    public void printBinary(String s) {
        Queue<String> q = new LinkedList<String>();
        q.add(s);
        while (!q.isEmpty()) {
            String j = q.poll();
            int i = j.lastIndexOf('?');
            if (i != -1) {
                char[] ch = j.toCharArray();
                ch[i] = '_';
                q.add(String.valueOf(ch));
                ch[i] = '1';
                q.add(String.valueOf(ch));
            } else {
                System.out.println(j);
            }
        }
    }

}
