package linkedlist;

import java.io.FileNotFoundException;

public class MoveLastToFront {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Node n = null;
        CreateList cl = new CreateList();
        MoveLastToFront m = new MoveLastToFront();
        for (String s : FIleUtil.getValue("list2.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }
        cl.printList(n);
        System.out.println();
        Node n1 = m.moveLastFron(n);

        cl.printList(n1);
    }

    public Node moveLastFron(Node n) {
        Node list = n;
        Node l = list;
        Node pre = null;
        while (list.getNext().getNext() != null) {
            list = list.getNext();
        }
        pre = list.getNext();
        list.setNext(null);
        pre.setNext(l);
        return pre;
    }


}
