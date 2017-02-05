package tree;

import java.util.HashMap;
import java.util.Map;

public class PrintNumberOfPath {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BT b = new BT();
        BT tn = b.getBT();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        new PrintNumberOfPath().findPath(tn, map, 0);
        //System.out.println(map.entrySet());
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }

    }

    public void findPath(BT tn, Map<Integer, Integer> map, int len) {
        if (tn == null) {
            return;
        }
        if (tn.getLeft() == null && tn.getRight() == null) {
            int l = 0;
            if (map.containsKey(len)) {
                l = map.get(len);
            }
            map.put(len, l + 1);
        }
        len = len + 1;
        findPath(tn.getLeft(), map, len);
        findPath(tn.getRight(), map, len);
    }
}
