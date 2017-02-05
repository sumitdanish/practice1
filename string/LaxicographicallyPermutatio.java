package string;

public class LaxicographicallyPermutatio {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] ch = "ABC".toCharArray();
        new LaxicographicallyPermutatio().laxi(ch);
    }

    public void laxi(char[] ch) {
        boolean is = true;
        while (is) {
            System.out.println(String.valueOf(ch));
            int i = firstCharIndex(ch, 0, ch.length - 1);
            if (i == -1) {
                break;
            }
            int cellIndex = cellIndex(ch, i + 1, ch.length - 1, ch[i]);
            swap(i, cellIndex, ch);
            reverse(ch, i + 1, ch.length - 1);
        }
    }

    public void swap(int cell, int i, char[] ch) {
        char temp = ch[cell];
        ch[cell] = ch[i];
        ch[i] = temp;
    }

    public int firstCharIndex(char[] ch, int st, int end) {
        for (int i = end - 1; i >= st; i--) {
            if (ch[i] < ch[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public int cellIndex(char[] ch, int st, int end, char fc) {
        int c = st;
        for (int i = st + 1; i <= end; i++) {
            if (fc < ch[i] && ch[c] > ch[i]) {
                c = i;
            }
        }
        return c;
    }

    public void reverse(char[] ch, int st, int end) {
        while (st < end) {
            char temp = ch[st];
            ch[st] = ch[end];
            ch[end] = temp;
            st++;
            end--;
        }
        //System.out.println(String.valueOf(ch));
    }

}
