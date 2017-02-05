package graph;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DNode dn = new DNode();
        dn.makeSet(1);
        dn.makeSet(2);
        dn.makeSet(3);
        dn.makeSet(4);
        dn.makeSet(5);
        dn.makeSet(6);
        dn.makeSet(7);
        dn.union(1, 2);
        dn.union(2, 3);
        dn.union(4, 5);
        dn.union(6, 7);
        dn.union(5, 6);
        dn.union(3, 7);
        Map<Integer, DNode> map = dn.getMap();
        System.out.println(dn.findNode(map.get(3)).getRank());
    }
}

class DNode {
    private int data;
    private DNode parent;
    private int rank;
    private Map<Integer, DNode> map;

    public DNode() {
        // TODO Auto-generated constructor stub
        map = new HashMap<Integer, DNode>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DNode getParent() {
        return parent;
    }

    public void setParent(DNode parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


    public Map<Integer, DNode> getMap() {
        return map;
    }

    public void setMap(Map<Integer, DNode> map) {
        this.map = map;
    }

    public void makeSet(int data) {
        DNode n = new DNode();
        n.setData(data);
        n.setParent(n);
        n.setRank(0);
        map.put(data, n);
    }

    public DNode findNode(DNode node) {
        DNode parent = node.getParent();
        if (parent == node) {
            return parent;
        }
        return findNode(node.getParent());
    }

    public boolean union(int d1, int d2) {
        DNode n1 = map.get(d1);
        DNode n2 = map.get(d2);
        DNode dn1 = findNode(n1);
        DNode dn2 = findNode(n2);
        if (dn1.getData() == dn2.getData()) {
            return false;
        }
        if (dn1.getRank() > dn2.getRank()) {
            dn1.setRank(dn1.getRank());
            dn2.setParent(dn1);
        } else if (dn1.getParent() == dn2.getParent()) {
            dn1.setParent(dn2);
            dn2.setRank(dn2.getRank() + 1);
        } else {
            dn1.setParent(dn2);
            dn2.setRank(dn2.getRank() + 1);
        }
        return true;

    }

}
