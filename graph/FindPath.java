package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FindPath {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(new File("path.txt"));
        GraphNodeList4 gl = new GraphNodeList4();
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            gl.addEadge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        Map<Integer, GraphNode> g = gl.getMapList();
        boolean b = gl.isPath(g, 3, 0);
        System.out.println(b);
    }

}

class GraphNodeList4 {

    Map<Integer, GraphNode> mapList;
    Set<Integer> isVisited;

    public GraphNodeList4() {
        mapList = new HashMap<>();
        isVisited = new HashSet<>();
    }

    public void addEadge(int src, int dest) {
        GraphNode g = null;
        if (!mapList.containsKey(src)) {
            g = createList(g, dest);
            mapList.put(src, g);
        } else {
            g = mapList.get(src);
            g = createList(g, dest);
        }
    }

    public GraphNode createList(GraphNode head, int data) {
        GraphNode gn = new GraphNode(data);
        if (head == null) {
            //	System.out.println("klskdl");
            head = gn;
            return head;
        } else {
            GraphNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(gn);
        }
        return head;
    }


    public Map<Integer, GraphNode> getMapList() {
        return mapList;
    }

    public boolean isPath(Map<Integer, GraphNode> map, int src, int dest) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);
        isVisited.add(src);
        while (!q.isEmpty()) {
            GraphNode gn = map.get(q.poll());
            while (gn != null) {
                if (!isVisited.contains(gn.getData())) {
                    if (gn.getData() == dest) {
                        return true;
                    }
                    q.add(gn.getData());
                    isVisited.add(gn.getData());
                }
                gn = gn.getNext();
            }
        }
        return false;
    }

}
