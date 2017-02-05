package array;

public class FIndMissingInTwoArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FIndMissingInTwoArray f = new FIndMissingInTwoArray();
        int[] a1 = {2, 3, 4, 5};
        int[] a2 = {2, 3, 4, 5, 6};
        int n = a1.length;
        int m = a2.length;
        if (n > m) {
            int x = f.findMissing(a1, a2, n);
            System.out.println(x);
        } else if (n < m) {
            int x = f.findMissing(a2, a1, m);
            System.out.println(x);
        } else {
            System.out.println("Invalid input");
        }

    }

    public int findMissing(int[] a1, int[] a2, int size) {
        if (size == 1) {
            return a1[0];
        }
        if (a1[0] != a2[0]) {
            return a1[0];
        }
        int low = 0;
        int highe = size - 1;
        int mid = 0;
        while (low < highe) {
            mid = (low + highe) / 2;
            if (a1[mid] == a2[mid]) {
                low = mid;
            } else {
                highe = mid;
            }
            if (low == highe - 1) {
                break;
            }
        }
        return a1[highe];
    }

}
