package linkedlist;

import java.io.FileNotFoundException;

public class RearrangeInPlace {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("re.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();
        Node n = new RearrangeInPlace().rearrnage(head);
        cl.printList(n);
    }

    public Node rearrnage(Node head) {
        Node slow = head;
        Node fast = head.getNext();
        Node s = slow;
        Node f = fast;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        f = slow.getNext();
        slow.setNext(null);

        return alternate(s, f);
    }

    public Node alternate(Node n1, Node n2) {
        Node list = n1;
        Node s = n1;
        Node f = n2;
        while (s != null && f != null) {
            Node t1 = s.getNext();
            Node t2 = f.getNext();
            s.setNext(f);
            f.setNext(t1);
            s = t1;
            f = t2;
        }
        return list;
    }

    public Node reverse(Node head) {
        Node pre = null;
        Node te = null;
        while (head != null) {
            te = head.getNext();
            head.setNext(pre);
            pre = head;
            head = te;
        }
        return pre;
    }

}
