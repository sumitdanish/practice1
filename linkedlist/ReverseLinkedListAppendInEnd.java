package linkedlist;

import java.io.FileNotFoundException;

public class ReverseLinkedListAppendInEnd {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("app.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = new ReverseLinkedListAppendInEnd().remove(head);
        cl.printList(n);
    }

    public Node remove(Node head) {
        Node list = head;
        Node l1 = list;
        Node l2 = list;
        Node temp1 = null;
        while (l2 != null && l2.getNext() != null) {
            l2 = l2.getNext();
        }
        while (l1 != null && l1.getNext() != l2 && l1 != l2) {
            Node temp = l1.getNext();
            l1.setNext(temp.getNext());
            temp.setNext(temp1);
            l2.setNext(temp);
            temp1 = temp;
            l1 = l1.getNext();
        }
        return list;
    }
}
