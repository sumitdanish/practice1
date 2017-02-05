package linkedlist;

import java.io.FileNotFoundException;

public class UnionAndInterSection {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node n = new Node();
        CreateList cl = new CreateList();
        UnionAndInterSection u = new UnionAndInterSection();
        for (String s : FIleUtil.getValue("ll.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }

        CreateList cl1 = new CreateList();
        Node n2 = new Node();
        for (String s2 : FIleUtil.getValue("list2.txt")) {
            n2 = cl1.createList(n2, Integer.parseInt(s2));
        }
        //cl1.printList(n2);
        Node l = u.intersection(n, n2);
        cl.printList(l);
    }


    public Node union(Node ll1, Node ll2) {
        Node head1 = ll1;
        Node head2 = ll2;
        Node result = null;

        while (head1 != null) {
            Node n = new Node();
            n.setData(head1.getData());
            if (result == null) {
                result = n;
            } else {
                Node temp = result;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(n);
            }
            head1 = head1.getNext();
        }
        Node temp1 = result;
        while (head2 != null) {
            if (!isPresent(result, head2.getData())) {
                Node n1 = new Node();
                n1.setData(head2.getData());
                while (temp1.getNext() != null) {
                    temp1 = temp1.getNext();
                }
                temp1.setNext(n1);
            }
            head2 = head2.getNext();
        }
        return result;

    }

    public Node intersection(Node ll, Node ll2) {
        Node result = null;
        Node head1 = ll;
        Node head2 = ll2;
        while (head2 != null) {
            if (isPresent(head1, head2.getData())) {
                Node n = new Node();
                n.setData(head2.getData());
                if (result == null) {
                    result = n;
                } else {
                    Node temp = result;
                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                    temp.setNext(n);
                }
            }
            head2 = head2.getNext();
        }
        return result;
    }

    private boolean isPresent(Node ll, int data) {
        if (ll == null) {
            return false;
        }
        if (ll.getData() == data) {
            return true;
        }
        return isPresent(ll.getNext(), data);
    }


}
