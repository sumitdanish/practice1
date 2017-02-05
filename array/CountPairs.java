package array;

import java.util.HashMap;
import java.util.Map;

public class CountPairs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {5, 5, 5};
        int sum = 10;
        new CountPairs().pairs(a, sum);
    }

    public void pairs(int[] a, int sum) {
        int count = 0;
        Map<Integer, Integer> s = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            int co = 1;
            if (s.containsKey(sum - a[i])) {
                co = s.get(sum - a[i]) + 1;
            }
            s.put(a[i], co);
        }
        for (int i = 0; i < a.length; i++) {
            count += s.get(sum - a[i]);
            if (sum - a[i] == a[i]) {
                count--;
            }
        }
        /*if(count % 2 != 0){
			count = count /2 +1;
		}else{
			count = count/2;
		}*/
        System.out.println(count / 2);
    }

}
