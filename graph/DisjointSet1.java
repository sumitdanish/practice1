package graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        DisNode d = new DisNode();
        d.makeSet("c");
        d.makeSet("a");
        d.makeSet("b");
        d.makeSet("d");
        d.union("d", "b");
        d.union("c", "a");
        d.union("a", "b");
        Map<String, DisNode> map = d.getMap();
        System.out.println(d.findNode("a").getRank());
    }


}

class DisNode {
    private String ch;
    private DisNode parent;
    private int rank;
    private Map<String, DisNode> map = new HashMap<String, DisNode>();

    public DisNode() {
        // TODO Auto-generated constructor stub

    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public DisNode getParent() {
        return parent;
    }

    public void setParent(DisNode parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void makeSet(String c) {
        DisNode d = new DisNode();
        d.setCh(c);
        d.setParent(d);
        map.put(c, d);
    }

    public boolean union(String s1, String s2) {
        DisNode d1 = map.get(s1);
        DisNode d2 = map.get(s2);
        if (d1.getRank() > d2.getRank()) {
            d2.setParent(d1);
        } else if (d1.getRank() < d2.getRank()) {
            d1.setParent(d2);
        } else {
            d1.setParent(d2);
            d2.setRank(d2.getRank() + 1);
        }
        map.put(s1, map.get(s2));
        return false;

    }

    public DisNode findNode(String s1) {
        DisNode d = map.get(s1).getParent();
        if (d.getCh() == map.get(s1).getCh()) {
            return d;
        }
        return findNode(map.get(s1).getParent().getCh());
    }

    public Map<String, DisNode> getMap() {
        return map;
    }

    public void setMap(Map<String, DisNode> map) {
        this.map = map;
    }


}