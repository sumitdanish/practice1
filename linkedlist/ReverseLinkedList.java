package linkedlist;

import java.io.FileNotFoundException;

public class ReverseLinkedList {

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("reverse.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = new ReverseLinkedList().reverseInGroup(head, 2);
        cl.printList(n);
    }


    public Node reverseInGroup(Node head, int k) {
        Node temp = null;
        Node pre = null;
        Node n = head;
        int x = 0;
        Node ptemp = null;
        Node temp1 = null;
        Node t2 = null;
        while (n != null) {
            x = 0;
            pre = null;
            ptemp = n;
            while (x < k && n != null) {
                temp1 = n.getNext();
                n.setNext(pre);
                pre = n;
                n = temp1;
                x++;
            }
            if (t2 != null) {
                t2.setNext(pre);
            }
            if (temp == null) {
                temp = pre;
            }
            if (ptemp != null) {
                ptemp.setNext(n);
                //ptemp = n;
            }
            pre = ptemp;
            x = 0;
            while (x < k && n != null) {
                n = n.getNext();
                pre = pre.getNext();
                x++;
            }
            t2 = pre;
        }
        return temp;
    }


    public Node reverse(Node head) {
        Node pre = null;
        Node curr = head;
        Node temp = null;
        while (curr != null) {
            temp = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = temp;
        }
        return pre;
    }


}
