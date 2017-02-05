package string;

public class Interleaving {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str1 = "abc";
        String str2 = "de";
        String str3 = "XXXYXZ";
        //System.out.println(new Interleaving().isInterleaved2(str1, str2, str3));
        char[] ch = new char[str1.length() + str2.length()];
        new Interleaving().isInterleved(str1, str2, ch, 0);
    }

    public void isInterleved(String str1, String str2, char[] ch, int i) {
        if (str1.length() == 0 && str2.length() == 0) {
            System.out.println(String.valueOf(ch));
            //s = "";
        }
        if (str1.length() != 0) {
            ch[i] = str1.charAt(0);
            isInterleved(str1.substring(1), str2, ch, i + 1);
        }
        if (str2.length() != 0) {
            ch[i] = str2.charAt(0);
            isInterleved(str1, str2.substring(1), ch, i + 1);
        }
    }

    public boolean isInterlaeved1(String str1, String str2, String str3) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < str3.length()) {
            if (i < str1.length() && str1.charAt(i) == str3.charAt(k)) {
                i++;
            } else if (j < str2.length() && str2.charAt(j) == str3.charAt(k)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        return true;
    }

    public boolean isInterleaved2(String str1, String str2, String str3) {
        if (str1 == null || str2 == null) {
            return true;
        }
        if (str3 == null) {
            return false;
        }
        return (str1.length() > 0 && str3.length() > 0 && str1.charAt(0) == str3.charAt(0) && isInterleaved2(str1.substring(1), str2, str3.substring(1))) ||
                (str2.length() > 0 && str3.length() > 0 && str2.charAt(0) == str3.charAt(0) && isInterleaved2(str1, str2.substring(1), str3.substring(1)));
    }

    public boolean inter(String str1, String str2, String str3) {
        boolean[][] b = new boolean[str1.length() + 1][str2.length() + 1];

        return b[str1.length()][str2.length()];
    }


}
