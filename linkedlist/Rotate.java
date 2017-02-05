package linkedlist;

import java.io.FileNotFoundException;

public class Rotate {

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        // TODO Auto-generated method stub
        CreateList cl = new CreateList();
        Node n = null;
        Rotate r = new Rotate();
        for (String s : FIleUtil.getValue("ll.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }
        Node ll = r.rotate(n, 4);
        cl.printList(ll);
    }

    public Node rotate(Node ll, int k) {
        Node head = ll;
        Node result = head;
        int i = 0;
        while (head != null && i < k) {
            head = head.getNext();
            i++;
        }
        Node head2 = head.getNext();
        head.setNext(null);
        Node r = head2;
        while (head2.getNext() != null) {
            head2 = head2.getNext();
        }
        head2.setNext(result);
        result = r;
        return result;
    }

}
