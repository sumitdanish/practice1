package array;

public class TrappingWater {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {3, 0, 0, 2, 0, 4};
        System.out.println(new TrappingWater().trapping1(a));
    }

    public void trapping(int[] a) {
        int maxs = Integer.MIN_VALUE;
        int[] maxRightLen = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (maxs < a[i]) {
                maxs = a[i];
                maxRightLen[i] = maxs;
            } else {
                maxRightLen[i] = maxs;
            }
        }
        int w = 0;
        int maxLeft = 0;
        for (int i = 0; i < a.length; i++) {
            w += max(min(maxLeft, maxRightLen[i]) - a[i], 0);
            if (maxLeft < a[i]) {
                maxLeft = a[i];
            }
        }
        System.out.println(w);
    }

    public int trapping1(int[] a) {
        int res = 0;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            if (a[left] < a[right]) {
                if (a[left] > maxLeft) {
                    maxLeft = a[left];
                } else {
                    res += maxLeft - a[left];
                }
                left++;
            } else {
                if (a[right] > maxRight) {
                    maxRight = a[right];
                } else {
                    res += maxRight - a[right];
                }
                right--;
            }
        }
        return res;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }
}
