package linkedlist;

import java.io.FileNotFoundException;

public class DeleteAlternateNode {

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        DeleteAlternateNode d = new DeleteAlternateNode();
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("ll.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = d.list(head);
        cl.printList(n);
    }


    public Node result(Node head) {
        if (head == null) {
            return null;
        }
        Node list = head;
        Node l1 = list;
        Node pre = null;

        while (l1 != null) {
            pre = l1;
            l1 = l1.getNext();
            if (l1 != null && l1.getNext() != null) {
                l1 = l1.getNext();
                pre.setNext(l1);
            } else {
                pre.setNext(null);
            }
        }
        return list;
    }

    public Node list(Node head) {
        Node list = head;
        Node temp = list;
        while (list != null && list.getNext() != null) {
            Node list1 = list.getNext().getNext();
            list.setNext(list1);
            list = list1;
        }
        return temp;
    }


}
