package string;

public class RemoveBandAC {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "bbbbd";
        new RemoveBandAC().removeBandAC(str);
    }

    public void removeBandAC(String str) {
        int i = 0;
        int j = 0;
        char[] ch = str.toCharArray();
        for (i = 1; i < ch.length; i++) {
            if (j < ch.length && ch[j] == 'b') {
                ch[j] = ' ';
            } else if (i < str.length() && str.charAt(i) == 'b') {
                ch[i] = ' ';
            } else if (i + 1 < str.length() && str.charAt(i) == 'a' && str.charAt(i + 1) == 'c') {
                ch[i + 1] = ' ';
                ch[i] = ' ';
            }
            j++;
        }

        System.out.println(String.valueOf(ch));
    }

}
