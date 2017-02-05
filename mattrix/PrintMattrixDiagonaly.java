package mattrix;

public class PrintMattrixDiagonaly {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2},
                {3, 4, 5, 6}};
        new PrintMattrixDiagonaly().diagonaly(mat, 4, 4);
    }

    public void diagonaly(int[][] mat, int column, int rows) {
        int col = 0;
        for (int c = 0; c < column; c++) {
            col = c;
            int row = 0;
            for (; col >= 0 && row < rows; col--, row++) {
                System.out.print(mat[row][col] + ",");
            }
            System.out.println();
        }
        for (int r = 1; r < rows; r++) {
            int c = column - 1;
            int r1 = r;
            for (; c >= 0 && r1 < rows; c--, r1++) {
                System.out.print(mat[r1][c] + ",");
            }
            System.out.println();
        }
    }
}
