package array;

public class CountWays {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 4;
        int m = 4;
        int count = new CountWays().countWays(n, m);
        System.out.println(count);
    }

    public int countWays(int n, int m) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= m && i <= n; i++) {
            count += countWays(n - i, m);
        }
        return count;
    }
}
