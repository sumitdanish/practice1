package graph;

import java.util.*;

public class TopologicalSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}

class GraphNodeList3 {

    Map<Character, GraphNode3> map;
    Set<Character> isVisited;
    Stack<Character> st;

    public GraphNodeList3() {
        map = new HashMap<>();
        isVisited = new HashSet<>();
        st = new Stack<>();
    }

    public void addEadge(Character src, Character dest) {
        GraphNode3 g = null;
        if (!map.containsKey(src)) {
            g = createNode(g, dest);
            map.put(src, g);
        } else {
            g = map.get(src);
            g = createNode(g, dest);
        }
    }

    public void topological(Map<Character, GraphNode3> map, char ch) {
        isVisited.add(ch);
        GraphNode3 g1 = map.get(ch);
        while (g1 != null) {
            if (!isVisited.contains(g1.getCh())) {
                topological(map, g1.getCh());
            }
        }
        st.push(ch);
    }

    public void printOrder() {
        while (!st.isEmpty()) {
            System.out.print(st.pop() + ",");
        }
    }

    public GraphNode3 createNode(GraphNode3 gn, char ch) {
        GraphNode3 g = new GraphNode3(ch);
        if (gn == null) {
            gn = g;
            return gn;
        }
        gn.setNext(createNode(gn.getNext(), ch));
        return gn;
    }

}

class GraphNode3 {
    private GraphNode3 next;
    private char ch;

    public GraphNode3(char ch) {
        super();
        this.ch = ch;
    }

    public GraphNode3 getNext() {
        return next;
    }

    public void setNext(GraphNode3 next) {
        this.next = next;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

}