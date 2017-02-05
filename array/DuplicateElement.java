package array;

public class DuplicateElement {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 3, 1, 3, 6, 6};
        new DuplicateElement().duplicate(a);
    }


    public void duplicate(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[Math.abs(a[i])] >= 0) {
                a[Math.abs(a[i])] = -a[Math.abs(a[i])];
            } else {
                System.out.println(a[i]);
            }
        }
    }

}
