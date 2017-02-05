package string;

public class ReverseWord {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "Sumit";
        System.out.println(new ReverseWord().revers(s));
    }


    public String revers(String s) {
        if (s.length() == 0) {
            return "";
        }
        return s.charAt(s.length() - 1) + revers(s.substring(0, s.length() - 1));
    }


    public void reversWord(String s) {
        StringBuilder sb = new StringBuilder();
        String s1 = revers(s);
        int len = s1.length();
        while (len >= 0) {

        }
    }
}
