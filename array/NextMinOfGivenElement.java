package array;

public class NextMinOfGivenElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] a = {5, 2, 4, 8, 6, 7};
        int key = 7;
        System.out.println(new NextMinOfGivenElement().nextMin(a, key));

    }


    public int nextMin(int[] a, int key) {
        int min_of_max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < key && min_of_max < a[i]) {
                min_of_max = a[i];
            }
        }
        return min_of_max;
    }

}
