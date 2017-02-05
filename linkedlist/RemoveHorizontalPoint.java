package linkedlist;

import java.io.FileNotFoundException;

public class RemoveHorizontalPoint {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("horizontal.txt")) {

            String[] s1 = s.split("_");
            //System.out.println(Integer.parseInt(s1[0])+","+Integer.parseInt(s1[1]));
            head = cl.createHorizontalList(head, Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
        }
        RemoveHorizontalPoint r = new RemoveHorizontalPoint();
        cl.printHorizontalList(head);
        System.out.println();
        Node n = r.remove(head);
        cl.printHorizontalList(n);
    }

    public Node remove(Node head) {
        Node list = head;
        Node l1 = list;
        Node l2 = list.getNext();
        Node l3 = list.getNext().getNext();
        while (l1.getNext() != null && l1.getNext() != null && l1.getNext().getNext() != null) {
            if (l1.getY() == l2.getY() && l2.getY() == l3.getY() && l1.getY() == l3.getY()) {
                l1.setNext(l3);
                l2 = l3;
                if (l3.getNext() != null) {
                    l3 = l3.getNext();
                } else {
                    l3 = null;
                }
            } else {
                l1 = l1.getNext();
                l2 = l2.getNext();
                l3 = l3.getNext();
            }
        }
        return list;
    }


}
