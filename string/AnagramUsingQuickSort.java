package string;

public class AnagramUsingQuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] ch = "eopqki".toCharArray();
        new AnagramUsingQuickSort().quickSort(0, ch.length - 1, ch);
    }


    public void quickSort(int left, int right, char[] ch) {
        int mid = (left + right) / 2;
        int p = ch[mid] / 2;
        int i = left;
        int j = right;
        while (i <= j) {
            while (p > ch[i]) {
                i++;
            }
            while (p < ch[j]) {
                j--;
            }
            if (i <= j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        if (i < right) {
            quickSort(i, right, ch);
        }
        if (j > left) {
            quickSort(left, j, ch);
        }
    }

}
