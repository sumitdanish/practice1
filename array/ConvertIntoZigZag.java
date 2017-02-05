package array;

public class ConvertIntoZigZag {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {4, 3, 7, 8, 6, 2, 1};
        for (int k : new ConvertIntoZigZag().zigzag(a)) {
            System.out.print(k + ",");
        }
    }

    public int[] zigzag(int[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (flag) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            } else {
                if (a[i] < a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
            flag = !flag;
        }
        return a;
    }
}
