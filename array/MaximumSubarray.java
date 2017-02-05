package array;

public class MaximumSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 12, -5, -6, 50, 3};
        int k = 4;
        new MaximumSubarray().maxSubArray(a, k);
    }

    public void maxSubArray(int[] a, int k) {
        int sum = 0;
        int ave = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        //ave = sum/k;
        max = sum;
        int ind = 0;
        for (int i = k; i < a.length; i++) {
            sum += a[i] - a[i - k];
            if (max < sum) {
                ind = i;
                max = sum;
            }
        }
        System.out.println((k - ind + 1));
    }

}
