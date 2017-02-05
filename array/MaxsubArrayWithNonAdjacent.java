package array;

public class MaxsubArrayWithNonAdjacent {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {5, 5, 10, 40, 50, 35};
        int maxSum = new MaxsubArrayWithNonAdjacent().maxSum(a);
        System.out.println(maxSum);
    }

    public int maxSum(int[] a) {
        int encl = 0;
        int new_enc = 0;
        int incl = a[0];

        for (int i = 1; i < a.length; i++) {
            new_enc = max(incl, encl);
            incl = encl + a[i];
            encl = new_enc;
        }
        return max(encl, incl);
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
