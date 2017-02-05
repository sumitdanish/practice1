package string;

public class RemoveDuplicate {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "aabcccdee";
        new RemoveDuplicate().remove(s.toCharArray());
    }

    public void removeAdjacen(char[] str) {
        int j = 0;
        String s = "";
        char[] ch = new char[str.length];
        for (int i = 1; i < str.length; i++) {
            while (i < str.length - 1 && j >= 0 && (str[i] == str[j])) {
                i++;
                j--;
            }
            str[++j] = str[i];
        }
        for (int k = 0; k < j; k++) {
            System.out.print(str[k]);
        }
    }

    public void remove(char[] ch) {
        int i = 0;
        int j = 1;
        int k = 0;
        int x = -1;
        for (i = 0; i < ch.length; i++) {
            while (j < ch.length - 1 && i < ch.length && ch[i] == ch[j]) {
                j++;
            }
            ch[k] = ch[j++];
            i = j;
            if (x == -1) {
                x++;
                ch[x] = ch[k];
                //System.out.println(x+"  : jhj : "+ch[x]);
            } else {
                while (x != k && ch[x] == ch[k]) {
                    k++;
                    System.out.println("kjllkj");
                    x++;
                }
                k++;
                x = k;

                System.out.println(k + " : " + x);
                System.out.println(ch[x]);
            }
        }
        //System.out.println(k);
    }

}
