package array;

public class BlockSwappingAlgo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {0, 1, 2, 3, 4, 5, 6};
        new BlockSwappingAlgo().blockSwapping(a, 3);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }

    public void swap(int[] a, int i1, int i2, int d) {
        for (int i = 0; i < d; i++) {
            int temp = a[i1 + i];
            a[i1 + i] = a[i2 + i];
            a[i2 + i] = temp;
        }
    }

    public void blockSwapping(int[] a, int d) {
        int size = a.length;
        int sizea = d;
        int sizeb = size - d;
        if (d > size) {
            return;
        }
        while (sizea != sizeb) {
            if (sizea < sizeb) {
                swap(a, d - sizea, d + sizeb - sizea, sizea);
                sizeb = sizeb - sizea;
            } else {
                swap(a, d - sizea, d, sizeb);
                sizea = sizea - sizeb;
            }
        }
        swap(a, d - sizea, d, sizea);
    }


}
