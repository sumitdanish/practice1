package array;

public class NumberFromGivenSequence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] ch = "DDIDDIID".toCharArray();
        new NumberFromGivenSequence().number(ch);
    }

    public void number(char[] ch) {

        int le = 0;
        int cm = 0;
        int nd = 0;
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'I':
                    int j = i + 1;
                    while (j < ch.length && ch[j] == 'D') {
                        nd++;
                        j++;
                    }
                    if (i == 0) {
                        cm = nd + 2;
                        //le = le + 1;
                        System.out.print(++le);
                        System.out.print(cm);
                        le = cm;
                    } else {
                        cm = cm + nd + 1;
                        le = cm;
                        System.out.print(cm);
                    }
                    for (int k = 0; k < nd; k++) {
                        //le = le - 1;
                        System.out.print(--le);
                        i++;
                    }
                    break;
                case 'D':
                    if (i == 0) {
                        j = i + 1;
                        while (j < ch.length && ch[j] == 'D') {
                            j++;
                            nd++;
                        }
                        cm = nd + 2;
                        System.out.print(cm);
                        System.out.print((cm - 1));
                        le = cm - 1;
                    } else {
                        System.out.print(le - 1);
                        le--;
                        //le -- ;
                    }
                    break;
            }
        }
    }

}
