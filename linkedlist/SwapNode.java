package linkedlist;

import java.io.FileNotFoundException;

public class SwapNode {

    static Node head;

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        // TODO Auto-generated method stub
        Node n = new Node();
        CreateList cl = new CreateList();
        SwapNode s = new SwapNode();
        for (String s1 : FIleUtil.getValue("list2.txt")) {
            head = cl.createList(head, Integer.parseInt(s1));
        }
        n = head;
        cl.printList(head);
        System.out.println();
        s.getSwapNode(5);
        cl.printList(head);
    }

    public void getSwapNode(int val) {
        int len = length(head);
        int k = 0;
        if (len % 2 == 0) {
            if (val > len / 2) {
                k = len - val + 1;
            }
        }
        if (len % 2 != 0) {
            if (val > len / 2 + 1) {
                k = len - val + 1;
            } else if (val == ((len / 2) + 1)) {
                return;
            } else {
                k = val;
            }
        }
        Node ll = head;
        Node lp = null;
        int i = 1;
        while (ll != null && i < k) {
            lp = ll;
            ll = ll.getNext();
            i++;
        }

        Node ll1 = head;
        Node lp1 = null;
        i = 1;
        while (i < len - k + 1 && ll1 != null) {
            lp1 = ll1;
            ll1 = ll1.getNext();
            i++;
        }
        if (lp != null) {
            lp.setNext(ll1);
        }
        if (lp1 != null) {
            lp1.setNext(ll);
        }

        Node temp = ll.getNext();
        ll.setNext(ll1.getNext());
        ll1.setNext(temp);
        //System.out.println(temp.getData());
    }

    public int length(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + length(head.getNext());
    }

}
