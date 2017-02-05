package array;

import java.util.HashMap;
import java.util.Map;

public class ExistingSumEle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        new ExistingSumEle().isSum(a, sum);

    }


    public void isSum(int[] a, int sum) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int x : a) {
            int temp = sum - x;
            if (m.containsKey(temp)) {
                System.out.println(sum + " : " + temp + " : " + x);
            }
            m.put(x, x);
        }
    }

}
