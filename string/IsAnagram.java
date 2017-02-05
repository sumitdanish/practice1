package string;

public class IsAnagram {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int k = 2;
        String str1 = "anagram";
        String str2 = "grammar";
        System.out.println(new IsAnagram().isAnnagram(str1, str2, k));
    }

    public boolean isAnnagram(String str1, String str2, int k) {
        boolean flag = false;
        int count = 0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        if (str1.length() != str2.length()) {
            return flag;
        }
        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            count2[str2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            if (count1[str1.charAt(i) - 'a'] < count2[str1.charAt(i) - 'a']) {
                //System.out.println(count1[str1.charAt(i)-'a'] +" : "+count2[str1.charAt(i)-'a'] );
                count++;
            }
        }
        System.out.println(count);
        return count <= k;
    }
}
