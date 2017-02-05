package string;

public class MultipleOccurence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] ch = "GeeksGeeks".toCharArray();
        char[] ch1 = "Geeks".toCharArray();
        new MultipleOccurence().inPlace(ch, ch1);
    }


    public void inPlace(char[] ch, char[] ch1) {
        int i = 0;
        int j = 0;
        int k = 0;
        for (i = 0; i < ch.length; i++) {
            j = 0;
            int x = i;
            while (x < ch.length && j < ch1.length && ch[x] == ch1[j]) {
                //System.out.println("jk");
                j++;
                x++;
            }
            //System.out.println(j+" : "+ch1.length);
            if (j == ch1.length) {
                //System.out.println("kdjkdjf");
                i = x - 1;
                ch[k] = 'X';
                k++;
            } else {
                ch[k] = ch[i];
                k++;
            }
        }
        String l = String.valueOf(ch);
        System.out.println(l.substring(0, k));
    }

}
