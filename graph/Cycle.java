package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Cycle {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(new File("dfs.txt"));
        GraphNodeList2 gl = new GraphNodeList2();
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            gl.addEadge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Map<Integer, GraphNode2> m = gl.getMap();
        GraphNode2 g = m.get(0);
        while (g != null) {
            System.out.print(g.getData() + ",");
            g = g.getNext();
        }
//		for (int i = 1; i <= 6; i++) {
//			if (gl.isCycle(i, m)) {
//				System.out.println("Exist");
//				break;
//			}
//		}

    }

}

class GraphNodeList2 {
    Map<Integer, GraphNode2> map;
    Map<Integer, Boolean> isRootMap;
    Set<Integer> isVisited;
    Set<Integer> isRecur;

    public GraphNodeList2() {
        // TODO Auto-generated constructor stub
        map = new HashMap<>();
        isRootMap = new HashMap<>();
        isVisited = new HashSet<>();
        isRecur = new HashSet<>();
    }

    public boolean isCycle(int v, Map<Integer, GraphNode2> map) {

        isVisited.add(v);
        isRecur.add(v);
        GraphNode2 g = map.get(v);
        while (g != null) {
            if (!isVisited.contains(g.getData()) && isCycle(g.getData(), map)) {
                return true;
            } else if (isRecur.contains(g.getData())) {
                return true;
            }
            g = g.getNext();
        }
        isRecur.remove(v);
        return false;
    }

    public void addEadge(int src, int dest) {
        GraphNode2 g = null;
        if (!map.containsKey(src)) {
            g = createNode(dest, g);
            map.put(src, g);
        } else {
            g = map.get(src);
            g = createNode(dest, g);
        }
    }

    public GraphNode2 createNode(int data, GraphNode2 g) {
        GraphNode2 g1 = new GraphNode2(data);
        if (g == null) {
            g = g1;
            return g;
        }
        g.setNext(createNode(data, g.getNext()));
        return g;
    }

    public void bfs(int v, Map<Integer, GraphNode2> map) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        isVisited.add(v);
        while (!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i + ",");
            GraphNode2 g = map.get(i);
            while (g != null) {
                if (!isVisited.contains(g.getData())) {
                    isVisited.add(g.getData());
                    q.add(g.getData());
                }
                g = g.getNext();
            }
        }
    }

    public Map<Integer, GraphNode2> getMap() {
        return map;
    }

}

class GraphNode2 {
    private GraphNode2 next;
    private int data;

    public GraphNode2() {
        // TODO Auto-generated constructor stub
    }

    public GraphNode2(int data) {
        // TODO Auto-generated constructor stub
        this.data = data;
    }

    public GraphNode2 getNext() {
        return next;
    }

    public void setNext(GraphNode2 next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}