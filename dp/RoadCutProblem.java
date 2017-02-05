package dp;

public class RoadCutProblem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20};
        int len = 8;
        int val = new RoadCutProblem().maxPrice1(p, len);
        System.out.println(val);
    }


    public int maxPrice(int[] p, int len) {
        if (len <= 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = maxVal(max, p[i] + maxPrice(p, len - i - 1));
        }
        return max;
    }

    public int maxPrice1(int[] p, int len) {
        int[] max = new int[len + 1];
        max[0] = 0;
        for (int i = 1; i <= len; i++) {
            max[i] = p[i - 1];
        }
        for (int i = 2; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if (max[j] + max[i - j] > max[i]) {
                    max[i] = max[j] + max[i - j];
                }
            }
        }
        return max[len];
    }

    public int maxVal(int a, int b) {
        return a > b ? a : b;
    }


}
