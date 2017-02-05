package mattrix;

public class MattrixChainMulti {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] p = {1, 2, 3, 4};
        int k = new MattrixChainMulti().minCost(p, 1, p.length - 1);
        System.out.println(k);
    }

    public int minCost(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        int minCo = Integer.MAX_VALUE;
        for (int x = i; x < j; x++) {
            int c = minCost(p, i, x) + minCost(p, x + 1, j) + p[i - 1] * p[x] * p[j];
            if (c < minCo) {
                minCo = c;
            }
        }
        return minCo;
    }


}
