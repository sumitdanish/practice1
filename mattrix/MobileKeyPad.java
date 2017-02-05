package mattrix;

public class MobileKeyPad {

    int[] row1 = {0, -1, 0, 1, 0};
    int[] col1 = {0, 0, -1, 0, 1};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] keyPad = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}};
        int row = 4;
        int col = 3;
        int n = 2;
        new MobileKeyPad().count(keyPad, row, col, n);
    }

    public void count(char[][] keyPad, int row, int col, int n) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isValid(row, col, i, j, keyPad)) {
                    count += getCount(row, col, i, j, n, keyPad);
                }
            }
        }
        System.out.println(count);
    }

    public boolean isValid(int row, int col, int r, int c, char[][] keyPad) {
        return r >= 0 && c >= 0 && r < row && c < col && (keyPad[r][c] != '*' || keyPad[r][c] != '#');
    }

    public int getCount(int row, int col, int r, int c, int n, char[][] keyPad) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int r1 = r + row1[i];
            int c1 = c + col1[i];
            if (isValid(row, col, r1, c1, keyPad)) {
                count += getCount(row, col, r1, c1, n - 1, keyPad);
            }
        }
        return count;
    }
}
