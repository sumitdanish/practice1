package array;

public class Majority {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int m = new Majority().majority(a);
        System.out.println(m);
    }

    public int majority(int[] a) {
        int m = 0;
        int i = 0;
        int x = a[i];
        int count = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[j] == a[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                i = j;
            }
        }
        //System.out.println(i);
        count = 0;
        for (int n = 0; n < a.length; n++) {
            if (a[n] == a[i]) {
                count++;
                //System.err.println(count);
            }
            if (count > a.length / 2) {
                return a[i];
            }
        }
        return -1;
    }
}
