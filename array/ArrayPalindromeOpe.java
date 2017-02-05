package array;

public class ArrayPalindromeOpe {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {11, 14, 15, 99, 66, 11};
        int n = new ArrayPalindromeOpe().minNumber(a);
        System.out.println(n);
    }


    public int minNumber(int[] a) {
        int r = 0;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            if (a[start] == a[end]) {
                start++;
                end--;
            } else if (a[start] < a[end]) {
                a[start] = a[start] + a[start + 1];
                start++;
                r++;
            } else {
                a[end] = a[end] + a[end - 1];
                end--;
                r++;
            }
        }
        return r;
    }

}
