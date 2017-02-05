package array;

public class MaxsubArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //http://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
        // We need to arrange array so that we can get max contigious sub array
        int[] a = {14, 12, 11, 20};
        System.out.println(new MaxsubArray().maxSubArray(a));
    }

    public int maxSubArray(int[] a) {
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int max = a[i];
            for (int j = i + 1; j < a.length; j++) {
                min = min(min, a[j]);
                max = max(a[j], max);
                if (max - min == j - i) {
                    if (maxLen < max - min) {
                        maxLen = max - min + 1;
                    }
                }
            }
        }
        return maxLen;
    }

    public int min(int a, int b) {
        return a > b ? b : a;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}