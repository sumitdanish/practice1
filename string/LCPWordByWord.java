package string;

public class LCPWordByWord {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] str = {"geeksforgeeks", "geeks", "geek", "geezer"};
        String s = new LCPWordByWord().divideAndCon(str, 0, str.length - 1);
        System.out.println(s);
    }

    public String compare(String s1, String s2) {
        String result = "";
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                result = result + String.valueOf(s1.charAt(i));
            }
            i++;
            j++;
        }
        return result;
    }

    public void lcpInWord(String[] str) {
        String result = str[0];
        for (int i = 1; i < str.length; i++) {
            result = compare(result, str[i]);
        }
        System.out.println(result);
    }


    public String divideAndCon(String[] str, int low, int high) {
        if (low == high) {
            return str[low];
        }
        int mid = (low + high) / 2;
        String str1 = divideAndCon(str, low, mid);
        String str2 = divideAndCon(str, mid + 1, high);
        return compare(str1, str2);
    }
}
