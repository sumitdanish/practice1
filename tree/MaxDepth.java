package tree;

public class MaxDepth {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {-1, 0, 1, 6, 6, 0, 0, 2, 7};
        new MaxDepth().maxDepth(a);
    }

    public void maxDepth(int[] a) {
        int j = 0;
        int maxDe = Integer.MIN_VALUE;
        int i = 0;
        int count = 0;
        for (i = 0; i < a.length; i++) {
            count = 0;
            j = i;
            while (a[j] != -1) {
                count++;
                j = a[j];
            }
            if (count > maxDe) {
                maxDe = count;
            }
        }
        System.out.println(maxDe);
    }


}
