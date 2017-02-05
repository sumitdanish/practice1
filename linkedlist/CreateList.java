package linkedlist;

public class CreateList {


    public Node createList(Node ll, int data) {
        Node n = new Node();
        n.setData(data);
        if (ll == null) {
            ll = n;
            return ll;
        }
        ll.setNext(createList(ll.getNext(), data));
        return ll;
    }

    public Node createHorizontalList(Node ll, int x, int y) {
        Node n = new Node(x, y);
        if (ll == null) {
            ll = n;
            return ll;
        }
        ll.setNext(createHorizontalList(ll.getNext(), x, y));
        return ll;
    }

    public void printHorizontalList(Node ll) {
        if (ll == null) {
            return;
        }
        System.out.print("(" + ll.getX() + "," + ll.getY() + ")" + "->");
        printHorizontalList(ll.getNext());
    }

    public void printList(Node ll) {
        if (ll == null) {
            return;
        }
        System.out.print(ll.getData() + "->");
        printList(ll.getNext());
    }


}
