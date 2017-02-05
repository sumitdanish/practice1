package string;

public class Permute {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abcde";
        String result = "";
        new Permute().orderPermute(s, result);
        char[] ch = s.toCharArray();
        //new Permute().permute(ch, ch.length);
    }

    public void orderPermute(String s, String result) {
        int len = s.length();
        if (len == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < len; i++) {
            orderPermute(s.substring(0, i) + s.substring(i + 1, len), result + s.charAt(i));
        }

    }

    public void permute(char[] ch, int len) {
        if (len == 1) {
            System.out.println(String.valueOf(ch));
            return;
        }
        for (int i = 0; i < len; i++) {
            swap(ch, i, len - 1);
            permute(ch, len - 1);
            swap(ch, i, len - 1);

        }

    }

    public void swap(char[] ch, int i, int j) {
        char c = ch[i];
        ch[i] = ch[j];
        ch[j] = c;
    }
}
