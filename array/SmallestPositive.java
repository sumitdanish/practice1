package array;

public class SmallestPositive {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-1, 3, 3, 7, -6, 8, -10, 15};
        System.out.println(new SmallestPositive().minPositive(a));


    }

    public int minPositive(int[] a) {
        segregate(a);
        int size = 0;
        for (int k : a) {
            if (k > 0) {
                size++;
            }
        }
        int min = 0;
        for (int i = 0; i < size; i++) {
            if (Math.abs(a[i] - 1) < size && a[Math.abs(a[i] - 1)] > 0) {
                a[Math.abs(a[i] - 1)] = -a[Math.abs(a[i] - 1)];
            }
        }
        for (int i = 0; i < size; i++) {
            if (a[i] > 0) {
                return i + 1;
            }
        }
        return min;
    }

    public void segregate(int[] a) {
        int i = 0;
        int j = 0;
        while (i < a.length) {
            if (a[i] <= 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
            i++;
        }
        i = 0;
        j = a.length - 1;
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            j--;
            i++;
        }

    }
}
