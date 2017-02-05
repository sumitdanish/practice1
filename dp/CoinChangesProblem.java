package dp;

public class CoinChangesProblem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int sum = 5;
        int[] s = {1, 2, 3};
        int c = new CoinChangesProblem().minCoin1(s, sum, s.length);
        System.out.println(c);
    }


    public int minCoin(int[] s, int sum, int len) {
        if (sum == 0) {
            return 1;
        }
        if (len <= 0) {
            return 0;
        }
        if (s[len - 1] > sum) {
            return 0;
        } else {
            return minCoin(s, sum, len - 1) + minCoin(s, sum - s[len - 1], len);
        }
    }

    public int minCoin1(int[] s, int sum, int len) {
        int[] min = new int[sum + 1];
        min[0] = 0;
        for (int i = 1; i <= sum; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        int max1 = Integer.MIN_VALUE;
        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= sum; i++) {

            flag = false;
            for (int j = 0; j < len; j++) {
                if (s[j] <= i && min[i - s[j]] + 1 < min[i]) {
                    min[i] = 1 + min[i - s[j]];
                    max = s[j];
                    flag = true;
                }
            }

        }
        return min[sum];
    }
}
