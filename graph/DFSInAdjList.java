package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class DFSInAdjList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(new File("dfs.txt"));
        int size = Integer.parseInt(sc.nextLine());
        GraphNodeList gl = new GraphNodeList(size);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            gl.addGraphNode(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        GraphNode[] glist = gl.graphList();
        gl.dfs1(0, glist);
    }

}

class GraphNodeList {
    GraphNode[] graphList;
    boolean[] isRoot;
    boolean[] isVis;

    public GraphNodeList(int size) {
        // TODO Auto-generated constructor stub
        graphList = new GraphNode[size];
        for (int i = 0; i < size; i++) {
            graphList[i] = null;
        }
        isRoot = new boolean[size];
        isVis = new boolean[size];
    }

    public void addGraphNode(int src, int dest) {
        if (!isRoot[src]) {
            graphList[src] = createNodeList(graphList[src], src);
            isRoot[src] = true;
        }
        graphList[src] = createNodeList(graphList[src], dest);
    }

    public void dfs(int v, GraphNode[] glist) {
        GraphNode gn = glist[v];
        System.out.print(v + ",");
        isVis[v] = true;
        while (gn != null && isRoot[v]) {
            if (!isVis[gn.getData()]) {
                dfs(gn.getData(), glist);
            }
            gn = gn.getNext();
        }
    }

    public void dfs1(int v, GraphNode[] gl) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(v);
        isVis[v] = true;
        while (!s.isEmpty()) {
            int i = s.peek();
            System.out.print(i + ",");
            s.pop();
            GraphNode gn1 = gl[i];
            while (gn1 != null) {
                if (!isVis[gn1.getData()]) {
                    s.push(gn1.getData());
                    isVis[gn1.getData()] = true;
                }
                gn1 = gn1.getNext();
            }

        }
    }

    public GraphNode createNodeList(GraphNode head, int data) {
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

    public GraphNode[] graphList() {
        return graphList;
    }
}

class GraphNode {
    private int data;
    private GraphNode next;
    private boolean isVisited;

    public GraphNode() {

    }

    public GraphNode(int data) {
        // TODO Auto-generated constructor stub
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public GraphNode getNext() {
        return next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

}
