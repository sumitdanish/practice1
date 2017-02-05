package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        GraphNodeList1 gl = null;
        Scanner sc = new Scanner(new File("dfs.txt"));
        int size = Integer.parseInt(sc.nextLine());
        gl = new GraphNodeList1(size);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            gl.addEadge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        GraphNode1[] g = gl.getGraphList();
        gl.bfs(1, g);
    }
}

class GraphNodeList1 {
    GraphNode1[] graphList;
    boolean[] isRoot;
    boolean[] isVisited;

    public GraphNodeList1(int size) {
        // TODO Auto-generated constructor stub
        graphList = new GraphNode1[size];
        for (int i = 0; i < size; i++) {
            graphList[i] = null;
        }
        isRoot = new boolean[size];
        isVisited = new boolean[size];
    }


    public void addEadge(int src, int dest) {
        if (!isRoot[src]) {
            graphList[src] = createList(graphList[src], src);
            isRoot[src] = true;
        }
        graphList[src] = createList(graphList[src], dest);
    }

    public void bfs(int v, GraphNode1[] gn) {
        Queue<Integer> q = new LinkedList<>();
        isVisited[v] = true;
        q.add(v);
        while (!q.isEmpty()) {
            int i = q.poll();
            System.out.print(i + ",");
            GraphNode1 g1 = gn[i];
            while (g1 != null) {
                if (!isVisited[g1.getData()]) {
                    q.add(g1.getData());
                    isVisited[g1.getData()] = true;
                }
                g1 = g1.getNext();
            }
        }
    }


    public GraphNode1 createList(GraphNode1 head, int data) {
        GraphNode1 gn = new GraphNode1(data);
        if (head == null) {
            head = gn;
            return head;
        }
        head.setNext(createList(head.getNext(), data));
        return head;
    }

    public GraphNode1[] getGraphList() {
        return graphList;
    }

    public void setGraphList(GraphNode1[] graphList) {
        this.graphList = graphList;
    }

}

class GraphNode1 {
    private int data;
    private GraphNode1 next;

    public GraphNode1(int data) {
        // TODO Auto-generated constructor stub
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public GraphNode1 getNext() {
        return next;
    }

    public void setNext(GraphNode1 next) {
        this.next = next;
    }


}
