package linkedlist;

import java.io.FileNotFoundException;

public class MximumSumLinkedList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head1 = null;
        Node head2 = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("max1.txt")) {
            head1 = cl.createList(head1, Integer.parseInt(s));
        }
        for (String s : FIleUtil.getValue("max2.txt")) {
            head2 = cl.createList(head2, Integer.parseInt(s));
        }
        cl.printList(head1);
        System.out.println();
        cl.printList(head2);
        System.out.println();
        Node n = new MximumSumLinkedList().createMaxSumLinkedList(head1, head2);
        cl.printList(n);
    }


    public Node createMaxSumLinkedList(Node head1, Node head2) {
        Node result = null;
        Node pre1 = head1;
        Node pre2 = head2;
        Node curr1 = head1;
        Node curr2 = head2;
        int sum1 = 0;
        int sum2 = 0;

        while (curr1 != null || curr2 != null) {
            sum1 = 0;
            sum2 = 0;
            while (curr1 != null && curr2 != null && curr1.getData() != curr2.getData()) {
                if (curr1.getData() < curr2.getData()) {
                    sum1 += curr1.getData();
                    curr1 = curr1.getNext();
                }
                if (curr1.getData() > curr2.getData()) {
                    sum2 += curr2.getData();
                    curr2 = curr2.getNext();
                }
            }
            if (curr1 == null) {
                while (curr2 != null) {
                    sum2 += curr2.getData();
                    curr2 = curr2.getNext();
                }
            }
            if (curr2 == null) {
                while (curr1 != null) {
                    sum1 += curr1.getData();
                    curr1 = curr1.getNext();
                }
            }
            if (pre1 == head1 && pre2 == head2) {
                result = (sum1 > sum2) ? pre1 : pre2;
            } else {
                if (sum1 > sum2) {
                    pre2.setNext(pre1.getNext());
                } else {
                    pre1.setNext(pre2.getNext());
                }
            }
            pre1 = curr1;
            pre2 = curr2;
            if (curr1 != null) {
                curr1 = curr1.getNext();
            }
            if (curr2 != null) {
                curr2 = curr2.getNext();
            }
        }

        return result;
    }

}
