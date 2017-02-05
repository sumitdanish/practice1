package array;

public class MaximumStrictlyIncresingSubArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 2, 4};
        new MaximumStrictlyIncresingSubArray().maxSubArray(a);
    }

    public void maxSubArray(int[] a) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        boolean flag = false;
        int st = 0;
        int end = 0;
        for (int i = 1; i < a.length; i++) {
            currentSum = a[i - 1];
            if (!flag) {
                st = i - 1;
            }
            if (a[i] > a[i - 1]) {
                currentSum += a[i];
                end = i;
                flag = !flag;
            } else {
                maxSum = max(maxSum, currentSum);
                currentSum = 0;
                flag = false;
            }
        }
        System.out.println(st + " : " + end);
        System.out.println(max(maxSum, currentSum));
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

}
