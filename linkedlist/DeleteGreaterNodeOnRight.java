package linkedlist;

import java.io.FileNotFoundException;

public class DeleteGreaterNodeOnRight {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("delete.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = new DeleteGreaterNodeOnRight().delete(head);
        cl.printList(n);
    }

    public Node delete(Node head) {
        Node tempHead = head;
        Node root = null;
        Node temp = tempHead;
        Node p = head;
        Node temp1 = tempHead.getNext();
        Node maxN = maxNode(temp1);
        // Node maxN1 = null;
        while (temp != null && temp1 != null) {
            if (temp.getData() < temp1.getData()) {
                temp = temp1;
                if (p == head || p.getData() < maxN.getData()) {
                    root = maxN;
                    p = maxN;

                } else {
                    if (root.getData() == maxN.getData()) {
                        root.setNext(null);
                    } else {
                        root.setNext(temp1);
                        root = root.getNext();
                    }
                }
            } else {
                //p = temp;
                temp = temp.getNext();
            }
            if (temp1.getNext() != null) {
                temp1 = temp1.getNext();
            }
            maxN = maxNode(temp1);
        }
        return p;
    }

    public Node maxNode(Node temp) {
        Node maxN = null;
        int maxVal = Integer.MIN_VALUE;
        Node t = temp;
        while (t != null) {
            if (maxVal < t.getData()) {
                maxVal = t.getData();
                maxN = t;
            }
            t = t.getNext();
        }
        return maxN;
    }
}
