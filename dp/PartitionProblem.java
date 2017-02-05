package dp;

public class PartitionProblem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 5, 11, 5};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum % 2 != 0) {
            System.out.println("no sum");
        } else {
            //System.out.println(new PartitionProblem().isPartition(a, sum/2,a.length));
            new PartitionProblem().isPartition1(a, sum, a.length);
        }
    }

    public boolean isPartition(int[] a, int sum, int len) {
        if (sum == 0) {
            return true;
        }
        if (len == 0 && sum != 0) {
            return false;
        }
        if (a[len - 1] > sum) {
            return isPartition(a, sum, len - 1);
        }
        return isPartition(a, sum, len - 1) || isPartition(a, sum - a[len - 1], len - 1);
    }

    public void isPartition1(int[] a, int sum, int len) {
        boolean[][] p = new boolean[sum / 2 + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            p[0][i] = true;
        }
        for (int i = 1; i <= sum / 2; i++) {
            p[i][0] = false;
        }
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= len; j++) {
                p[i][j] = p[i][j - 1];
                if (i >= a[j - 1]) {
                    p[i][j] = p[i][j] || p[i - a[j - 1]][j - 1];
                }
            }
        }
        System.out.println(p[sum / 2][len]);
    }
}
