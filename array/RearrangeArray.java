package array;

public class RearrangeArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {50, 40, 70, 60, 90};
        int[] ind = {3, 0, 4, 1, 2};
        for (int i : new RearrangeArray().reaareng1(a, ind)) {
            System.out.print(i + ",");
        }
    }

    public int[] rarrane(int[] a, int[] ind) {
        int[] temp = new int[ind.length];
        for (int i = 0; i < ind.length; i++) {
            temp[ind[i]] = a[i];
        }
        for (int i = 0; i < ind.length; i++) {
            a[i] = temp[i];
            ind[i] = i;
        }
        return a;
    }

    public int[] reaareng1(int[] a, int[] ind) {
        int oldI = 0;
        int oldE = 0;
        for (int i = 0; i < ind.length; i++) {
            if (ind[i] != i) {
                oldI = ind[ind[i]];
                System.out.println(oldI + " : " + oldE);
                oldE = a[ind[i]];
                a[ind[i]] = a[i];
                ind[ind[i]] = ind[i];
                a[i] = oldE;
                ind[i] = oldI;
            }
        }
        return a;
    }

}
