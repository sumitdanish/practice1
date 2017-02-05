package array;

public class FlipSubArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {0, 1, 0, 0, 1, 1, 0};
        System.out.println(new FlipSubArray().max0s(a));
    }

    public int max0s(int[] a) {
        int maxZeros = 0;
        int zc = 0;
        int max_so_far = Integer.MIN_VALUE;
        int maxSum = a[0];
        boolean flag = false;
        int st = 0;
        int end = 0;
        for (int i = 1; i < a.length; i++) {
            maxSum += a[i];

            if (a[i] == 0) {
                zc++;
            } else {
                if (!flag) {
                    st = i;
                }
                if (max_so_far < maxSum) {
                    max_so_far = maxSum;
                    end = i;
                    flag = true;

                }
                if (maxSum <= 0) {
                    maxSum = 0;
                    flag = !flag;
                }
            }
        }
        System.out.println(st + " : " + end);
        return zc + max_so_far;
    }
}
