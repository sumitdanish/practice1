package linkedlist;

import java.io.FileNotFoundException;

public class MergeLinkedList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head1 = null;
        Node head2 = null;
        CreateList cl1 = new CreateList();
        for (String s : FIleUtil.getValue("mer1.txt")) {
            head1 = cl1.createList(head1, Integer.parseInt(s));
        }
        for (String s : FIleUtil.getValue("mer2.txt")) {
            head2 = cl1.createList(head2, Integer.parseInt(s));
        }
        cl1.printList(head1);
        System.out.println();
        cl1.printList(head2);
        System.out.println();
        Node n = new MergeLinkedList().merge(head1, head2);
        cl1.printList(n);

    }


    public Node merge(Node head1, Node head2) {
        Node temp = head1;
        Node temp11 = head2;
        Node temp1 = temp;
        Node temp2 = temp11;
        while (temp1 != null && temp2 != null) {
            Node t = temp1.getNext();
            Node t2 = temp2.getNext();
            temp1.setNext(temp2);
            temp2.setNext(t);
            temp1 = t;
            temp2 = t2;
        }
        return temp;

    }

}
