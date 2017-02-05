package mattrix;

public class Rotate90 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int dimen = 3;
        new Rotate90().rotate(mat, dimen);
    }

    public void rotate(int[][] mat, int dimen) {
        for (int i = 0; i < dimen / 2; i++) {
            for (int j = i; j < dimen - i - 1; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][dimen - i - 1];
                mat[j][dimen - i - 1] = mat[dimen - i - 1][dimen - j - 1];
                mat[dimen - i - 1][dimen - j - 1] = mat[dimen - j - 1][i];
                mat[dimen - j - 1][i] = temp;
            }
        }
        for (int i = 0; i < dimen; i++) {
            for (int j = 0; j < dimen; j++) {
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }
    }

}
