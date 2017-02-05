package mattrix;

public class CelebretyProblem {

    public static void main(String[] args) {
        int n = 4;
        boolean[][] known = {{false, false, true, false},
                {false, false, true, false},
                {false, false, false, false},
                {false, false, true, true}};
        System.out.println(new CelebretyProblem().stranger(known, n));
    }

    public int stranger(boolean[][] known, int n) {
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (known[a][b]) {
                a++;
            } else {
                b--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != a) {
                if (known[a][i] || !known[i][a]) {
                    return -1;
                }
            }
        }
        return a;
    }
}
