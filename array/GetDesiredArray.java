package array;

public class GetDesiredArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {2, 3};
        int n = new GetDesiredArray().minSteps(a);
        System.out.println(n);
    }

    public int minSteps(int[] a) {
        int count = 0;
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                n--;
            }
        }
        while (n > 0) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] % 2 != 0) {
                    a[i] = a[i] - 1;
                    if (a[i] == 0) {
                        n--;
                    }
                    count++;
                }

            }
            if (n == 0) {
                break;
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] / 2;
            }

            count++;
        }
        return count;
    }

}
