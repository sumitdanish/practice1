package linkedlist;

import java.io.FileNotFoundException;

public class PairwiseSwaping {

    static Node head;

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node n = new Node();
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("list2.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        n = head;
        cl.printList(n);
        System.out.println();
        PairwiseSwaping pa = new PairwiseSwaping();
        Node n1 = pa.swap(n);
        cl.printList(n1);
    }

    public Node pairSwap(Node node) {
        Node list = node;
        Node l = node.getNext();
        Node temp = null;
        boolean flag = false;
        while (list.getNext() != null) {
            temp = l.getNext();
            l.setNext(list);
            if (temp != null && temp.getNext() != null) {
                list.setNext(temp.getNext());
            } else {
                list.setNext(temp);
            }
            if (temp == null) {
                break;
            }
            if (!flag) {
                node = l;
                flag = true;
            }
            list = temp;
            l = list.getNext();
        }
        return node;
    }


    public Node swap(Node head) {
        Node list = head;
        Node curr = list;
        Node p = null;
        while (curr.getNext() != null) {
            Node temp = curr.getNext();
            if (curr == head) {
                curr.setNext(temp.getNext());
                temp.setNext(curr);
                temp = curr;
                head = temp;
            } else {
                p.setNext(temp);
                curr.setNext(temp.getNext());
                temp.setNext(curr);

            }
            p = curr;
            curr = curr.getNext();
        }
        return list;
    }

}
