package linkedlist;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node n = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("list2.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }
        cl.printList(n);
        System.out.println();
        RemoveDuplicate d = new RemoveDuplicate();
        Node n1 = d.mapRemove(n);
        cl.printList(n1);
    }

    public Node removeDuplicate(Node node) {
        Node list = node;
        Node l = list;
        Node pre = null;
        while (l != null) {
            pre = l;
            while (pre.getNext() != null) {
                if (pre.getNext().getData() == l.getData()) {
                    if (pre.getNext().getNext() != null) {
                        pre.setNext(pre.getNext().getNext());
                    } else {
                        pre.setNext(null);
                    }
                } else {
                    pre = pre.getNext();
                }
            }
            l = l.getNext();
        }
        return list;
    }

    public Node mapRemove(Node n) {
        Node list = n;
        Node front = list.getNext();
        Node back = list;
        Set<Integer> s = new HashSet<Integer>();
        s.add(list.getData());
        while (front != null) {
            if (s.contains(front.getData())) {
                back.setNext(front.getNext());
                front = back.getNext();
            } else {
                s.add(front.getData());
                front = front.getNext();
                back = back.getNext();
            }

        }
        return list;
    }

}
