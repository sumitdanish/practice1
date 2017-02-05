package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(new File("emp.txt"));
        Graph4 gl = new Graph4();
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            gl.addEadge(s[0].trim(), s[1].trim());
        }
        String name1 = "Rajesh";
        String name2 = "Ravi";
        Map<String, Graph4List> g = gl.getMap();
        Graph4List g1 = gl.lca(name1.trim(), name2.trim(), g);
        System.out.println(g1.getName());
    }

}

class Graph4 {
    private Map<String, Graph4List> map;

    public Graph4() {
        map = new HashMap<>();
    }

    public Graph4List lca(String name1, String name2, Map<String, Graph4List> gl) {
        Graph4List g = null;
        Map<String, String> s = new HashMap<String, String>();
        Map<String, Boolean> s1 = new HashMap<String, Boolean>();
        for (Map.Entry<String, Graph4List> m : gl.entrySet()) {
            String root = m.getKey();//System.out.println(root);
            if (root.equals(name1)) {
                s.put(name1, root);
            } else if (root.equals(name2)) {
                s.put(name2, root);
            }
            Graph4List g1 = m.getValue();
            while (g1 != null) {
                String r = g1.getName();
                if (!s.containsKey(r)) {
                    //System.out.println(r+" : "+name1+" : "+r.equals(name1));
                    if (r.equals(name1)) {
                        //System.out.println(root);
                        s.put(name1, root);
                    } else if (r.equals(name2)) {
                        //System.out.println(root);
                        s.put(name2, root);
                    }
                }
                g1 = g1.getNext();
            }
        }
        g = new Graph4List(s.get(name2));
        return g;
    }

    public void addEadge(String src, String dest) {
        Graph4List gn = null;
        if (!map.containsKey(src)) {
            gn = createList(dest, gn);
            map.put(src, gn);
        } else {
            gn = map.get(src);
            gn = createList(dest, gn);
        }
    }

    public Graph4List createList(String name, Graph4List node) {
        Graph4List g = new Graph4List(name);
        if (node == null) {
            node = g;
            return node;
        }
        node.setNext(createList(name, node.getNext()));
        return node;
    }

    public Map<String, Graph4List> getMap() {
        return map;
    }

    public void setMap(Map<String, Graph4List> map) {
        this.map = map;
    }


}

class Graph4List {
    private Graph4List next;
    private String name;

    public Graph4List(String name) {
        this.name = name;
    }

    public Graph4List getNext() {
        return next;
    }

    public void setNext(Graph4List next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}