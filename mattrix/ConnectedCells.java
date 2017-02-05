package mattrix;

public class ConnectedCells {

    int[] x = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] y = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] mat = {{1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0}};
        int row = 5;
        int col = 5;
        new ConnectedCells().connected(mat, row, col);
    }

    public boolean isSafe(int row, int col, int r, int c, boolean[][] isVis, int[][] mat) {
        return c >= 0 && r >= 0 && c < col && r < row && !isVis[r][c] && mat[r][c] == 1;
    }

    public void dfs(int[][] mat, boolean[][] isVis, int row, int col, int r1, int c1, int a) {
        //if(!isSafe(row, col, r1, c1, isVis, mat)){
        //return;
        //}
        isVis[r1][c1] = true;
        for (int i = 0; i < 8; i++) {
            if (isSafe(row, col, r1 + y[i], c1 + x[i], isVis, mat)) {
                dfs(mat, isVis, row, col, r1 + y[i], c1 + x[i], a + 1);
            }
        }
    }

    public void connected(int[][] mat, int row, int col) {
        boolean[][] isVis = new boolean[row][col];
        int c = 0;
        int a = 0;
        int maxA = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!isVis[i][j] && mat[i][j] == 1) {
                    dfs(mat, isVis, row, col, i, j, a);
                    if (maxA < a) {
                        maxA = a;
                    }
                    c++;
                }
            }
        }
        System.out.println(c + " : " + maxA);
    }
}
