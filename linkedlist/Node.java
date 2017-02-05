package linkedlist;

public class Node {


    private int data;
    private Node next;
    private Node random;
    private Node nextGreater;
    private Node down;
    private Node child;
    private Node arbitNext;
    private int x;
    private int y;

    public Node() {

    }

    public Node(int x, int y) {
        // TODO Auto-generated method stub
        this.x = x;
        this.y = y;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }

    public Node getNextGreater() {
        return nextGreater;
    }

    public void setNextGreater(Node nextGreater) {
        this.nextGreater = nextGreater;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }

    public Node getArbitNext() {
        return arbitNext;
    }

    public void setArbitNext(Node arbitNext) {
        this.arbitNext = arbitNext;
    }


}
