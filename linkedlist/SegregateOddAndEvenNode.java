package linkedlist;

import java.io.FileNotFoundException;

public class SegregateOddAndEvenNode {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("segregate.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = new SegregateOddAndEvenNode().segregate(head);
        cl.printList(n);
    }


    public Node segregate(Node head) {
        Node tempHead = head;
        Node list1 = tempHead;
        Node even = null;
        Node eh = null;
        Node oh = null;
        Node odd = null;
        while (list1 != null) {
            Node t = list1.getNext();
            if (list1.getData() % 2 == 0) {
                if (even == null) {
                    even = list1;
                    eh = even;
                } else {
                    even.setNext(list1);
                    even = even.getNext();
                }
            } else {
                if (oh == null) {
                    odd = list1;
                    oh = list1;
                } else {
                    odd.setNext(list1);
                    odd = odd.getNext();
                }
            }
            list1 = t;
        }
        if (eh == null) {
            list1 = oh;
        }
        if (oh == null) {
            list1 = eh;
        } else if (oh != null && eh != null) {
            even.setNext(oh);
            odd.setNext(null);
        }

        //even = eh;
        return list1;
    }


}
