package array;

import java.util.Arrays;

public class MergeTowSortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a1 = {1, 5, 9, 10, 15, 20};
        int[] a2 = {2, 3, 8, 13};
        new MergeTowSortedArray().merge(a1, a2);


    }


    public void merge(int[] a1, int[] a2) {
        int last = 0;
        for (int i = a1.length - 1; i >= 0; i--) {
            last = a2[a2.length - 1];
            int j = 0;
            for (j = a2.length - 2; j >= 0 && a2[j] > a1[i]; j--) {
                a2[j + 1] = a2[j];
            }
            if (j != a2.length - 1) {
                a2[j + 1] = a1[i];
                a1[i] = last;
            }
        }
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
    }


}
