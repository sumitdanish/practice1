package string;

public class StringBracket {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abcd";
        new StringBracket().printBracket(s, 0, "");
    }

    public void printBracket(String str, int index, String s) {
        if (index == str.length()) {
            System.out.println(s);
            return;
        }
        for (int i = index; i < str.length(); i++) {
            printBracket(str, i + 1, s + "(" + str.substring(index, i + 1) + ")");
        }
    }

}
