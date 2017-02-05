package linkedlist;

import java.io.FileNotFoundException;

public class IntersectionOfSortedList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head1 = null;
        Node head2 = null;
        IntersectionOfSortedList i = new IntersectionOfSortedList();
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("sortedList2.txt")) {
            head1 = cl.createList(head1, Integer.parseInt(s));
        }
        for (String s : FIleUtil.getValue("sortList1.txt")) {
            head2 = cl.createList(head2, Integer.parseInt(s));
        }

        cl.printList(head1);
        System.out.println();
        cl.printList(head2);
        System.out.println();
        Node n = i.intersection(head1, head2);
        cl.printList(n);

    }


    public Node intersection(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        CreateList cl = new CreateList();
        Node result = null;
        Node a = head1;
        Node b = head2;
        while (a != null && b != null) {
            if (a.getData() < b.getData()) {
                a = a.getNext();
            } else if (a.getData() > b.getData()) {
                b = b.getNext();
            } else {
                result = cl.createList(result, a.getData());
                a = a.getNext();
                b = b.getNext();
            }
        }
        return result;
    }

}
