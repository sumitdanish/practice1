package array;

public class MaximumMirrors {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] ch = {{'B', 'B', 'O', 'B', 'B'},
                {'B', 'B', 'B', 'B', 'O'},
                {'B', 'B', 'B', 'B', 'B'},
                {'B', 'O', 'O', 'B', 'O'},
                {'B', 'B', 'B', 'O', 'B'}
        };
        new MaximumMirrors().mirror(ch, 5, 5);
    }

    public void mirror(char[][] ch, int row, int col) {
        int[] v = new int[row];
        int[] h = new int[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ch[i][j] == 'B') {
                    continue;
                }
                h[i] = j;
                System.out.println("col : " + i + " : " + j);
                break;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ch[j][i] == 'B') {
                    continue;
                }
                v[i] = j;
                //System.out.println("row : "+i +" : "+ j);
                break;
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (v[j] != 0 && h[i] != 0 && i > v[j] && j > h[i]) {
                    System.out.println(i + " : " + j);
                    //System.out.println(j+" : "+h[i]);
                    count++;
                }
            }
        }
        System.out.println("Count : " + count);

    }
}
