package linkedlist;

import java.io.FileNotFoundException;

public class RotateLinedList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("ll.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = new RotateLinedList().rotate(head, 4);
        cl.printList(n);
    }


    public Node rotate(Node head, int k) {
        Node result = head;
        Node list = result;
        while (k > 1 && list != null) {
            list = list.getNext();
            k--;
        }
        Node h1 = list.getNext();
        Node r = h1;
        list.setNext(null);
        while (h1.getNext() != null) {
            h1 = h1.getNext();
        }
        h1.setNext(result);
        return r;
    }


}
