package linkedlist;

import java.io.FileNotFoundException;

public class SwapNodeInGivenKey {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("swap.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        SwapNodeInGivenKey s = new SwapNodeInGivenKey();
        Node n = s.getSwap(head, 12, 13);
        cl.printList(n);

    }

    public Node getSwap(Node head, int x, int y) {
        Node temp1 = head;
        Node temp2 = head;
        Node temp1_pre = null;
        Node temp2_pre = null;
        while (temp1 != null && temp1.getData() != x) {
            temp1_pre = temp1;
            temp1 = temp1.getNext();
        }
        while (temp2 != null && temp2.getData() != y) {
            temp2_pre = temp2;
            temp2 = temp2.getNext();
        }

        if (temp1_pre == null && temp2_pre == null) {
            return head;
        }
        if (temp1_pre != null) {
            temp1_pre.setNext(temp2);
        } else {
            head = temp2;
        }
        if (temp2_pre != null) {
            temp2_pre.setNext(temp1);
        } else {
            head = temp1;
        }

        Node t = temp2.getNext();
        temp2.setNext(temp1.getNext());
        temp1.setNext(t);
        return head;
    }
}
