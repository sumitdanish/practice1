package string;

public class PrintWordSentence {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[][] str = {{"you", "we", ""},
                {"have", "are", ""},
                {"sleep", "eat", "drink"}};
        int row = 3;
        int col = 3;
        new PrintWordSentence().printWord(row, col, str);
    }


    public void printWord(int row, int col, String[][] str) {
        String[] out = new String[row];
        for (int i = 0; i < col; i++) {
            if (str[0][i] != "") {
                printWordList(str, 0, i, row, col, out);
            }
        }
    }

    public void printWordList(String[][] str, int row, int col, int R, int C, String[] out) {
        out[row] = str[row][col];
        if (row == R - 1) {
            for (String s : out) {
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < R; i++) {
            if (str[row + 1][i] != "") {
                printWordList(str, row + 1, i, R, C, out);
            }
        }
    }

}
