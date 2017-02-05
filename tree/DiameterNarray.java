package tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by summit on 2/2/17.
 */
public class DiameterNarray {

    public static void main(String[] args) {
        try {
            DiameterNarray da = new DiameterNarray();
            Narry narry = new Narry('A');
            narry.getChild().put('B', new Narry('B'));
            narry.getChild().put('F', new Narry('F'));
            narry.getChild().put('D', new Narry('D'));
            narry.getChild().put('E', new Narry('E'));
            narry.getChild().get('B').getChild().put('K', new Narry('K'));
            narry.getChild().get('B').getChild().put('J', new Narry('J'));
            narry.getChild().get('B').getChild().get('K').getChild().put('N', new Narry('N'));
            narry.getChild().get('B').getChild().get('K').getChild().put('M', new Narry('M'));
            narry.getChild().get('E').getChild().put('C', new Narry('C'));
            narry.getChild().get('E').getChild().put('H', new Narry('H'));
            narry.getChild().get('E').getChild().put('I', new Narry('I'));
            narry.getChild().get('D').getChild().put('G', new Narry('G'));
            int d = da.diameter(narry);
            System.out.println(d);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int depth(Narry narry) {
        if (narry == null) {
            return 0;
        }
        int maxDepth = 0;
        Iterator it = narry.getChild().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            maxDepth = max(maxDepth, depth((Narry) m.getValue()));
        }
        return maxDepth + 1;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int diameter(Narry narry) {
        if (narry == null) {
            return 0;
        }
        int max1 = 0;
        int max2 = 0;
        Iterator it = narry.getChild().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            int h = depth((Narry) m.getValue());
            if (max1 < h) {
                max2 = max1;
                max1 = h;
            } else if (max2 < h) {
                max2 = h;
            }
        }
        int maxDia = 0;
        Iterator it1 = narry.getChild().entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry m;
            m = (Map.Entry) it1.next();
            maxDia = max(maxDia, diameter((Narry) m.getValue()));
        }
        return max(max1 + max2 + 1, maxDia);
    }
}

class Narry {
    private char data;
    private Map<Character, Narry> child;

    public Narry(char data) {
        this.data = data;
        child = new HashMap<>();
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public Map<Character, Narry> getChild() {
        return child;
    }

    public void setChild(Map<Character, Narry> child) {
        this.child = child;
    }
}
