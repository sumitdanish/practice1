package linkedlist;

import java.io.FileNotFoundException;

public class RemoveDuplicatSortedList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        Node n = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("list3.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }
        cl.printList(n);
        System.out.println();
        Node l = new RemoveDuplicate().removeDuplicate(n);
        cl.printList(l);
    }


    public Node remove(Node node) {
        Node l = node;
        Node cur = l;
        while (cur.getNext() != null) {
            if (cur.getData() == cur.getNext().getData()) {
                cur.setNext(cur.getNext().getNext());
            } else {
                cur = cur.getNext();
            }
        }
        return l;
    }


}
