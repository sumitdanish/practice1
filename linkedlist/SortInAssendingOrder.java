package linkedlist;

import java.io.FileNotFoundException;

public class SortInAssendingOrder {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("as.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = new SortInAssendingOrder().sort(head);
        cl.printList(n);
    }


    public Node sort(Node head) {
        Node list = head;
        Node root = list;
        Node p1 = root;
        Node p2 = root.getNext();
        Node re = p1;
        Node t1 = null;
        Node y = null;
        while (root != null && root.getNext() != null) {
            Node te = root.getNext().getNext();
            p1.setNext(te);
            p1 = te;
            if (te != null && te.getNext() != null) {
                y = te.getNext();
            } else {
                y = te;
            }
            p2.setNext(t1);
            t1 = p2;
            p2 = y;
            root = te;
        }


        return merge(re, t1);
    }

    public Node merge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node result = null;
        if (head1.getData() < head2.getData()) {
            result = head1;
            result.setNext(merge(head1.getNext(), head2));
        }
        if (head1.getData() > head2.getData()) {
            result = head2;
            result.setNext(merge(head1, head2.getNext()));
        }
        return result;
    }

}
