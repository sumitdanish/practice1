package array;

public class MaximunArraySum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-2, 0, 5, -1, 2};
        int k = 4;
        new MaximunArraySum().maxSum(a, k);
    }

    public void maxSum(int[] a, int k) {
        for (int i = 1; i <= k; i++) {
            int min = Integer.MAX_VALUE;
            int ind = 0;
            for (int x = 0; x < a.length; x++) {
                if (a[x] < min) {
                    min = a[x];
                    ind = x;
                }
            }
            if (min != 0) {
                a[ind] = -a[ind];
            }

        }
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
            sum = sum + a[i];
        }
        System.out.println();
        System.out.println(sum);
    }

}
