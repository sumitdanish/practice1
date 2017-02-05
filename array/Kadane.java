package array;

public class Kadane {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        new Kadane().maxSumCOntigious(a);
    }

    public void maxSumCOntigious(int[] a) {
        int maxSum = Integer.MIN_VALUE;
        int st = 0;
        int end = 0;
        int currentSum = 0;
        boolean flag = false;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (!flag) {
                st = i;
            }
            if (maxSum < currentSum) {
                maxSum = currentSum;
                flag = true;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                flag = false;
            }
        }
        System.out.println(maxSum + " : " + st + " : " + end);
    }
}
