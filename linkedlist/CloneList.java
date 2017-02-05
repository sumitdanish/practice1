package linkedlist;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CloneList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node n = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("clone.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }
        n.setRandom(n.getNext().getNext());
        n.getNext().setRandom(n);
        n.getNext().getNext().setRandom(n.getNext().getNext().getNext().getNext());
        n.getNext().getNext().getNext().getNext().setRandom(n.getNext().getNext());
        n.getNext().getNext().getNext().setRandom(n.getNext().getNext());
        cl.printList(n);
        System.out.println();
        CloneList clo = new CloneList();
        Node clone = clo.cloneLinkedListMap(n);
        System.out.println(clone.getRandom().getData());
        cl.printList(clone);


    }

    public Node copyLinkedList(Node head) {
        Node curr = head;
        Node nCurr = curr;
        while (nCurr != null) {
            Node temp = new Node(nCurr.getData());
            Node t = nCurr.getNext();
            nCurr.setNext(temp);
            temp.setNext(t);
            nCurr = nCurr.getNext().getNext();
        }

        nCurr = curr;
        while (nCurr != null) {
            nCurr.getNext().setRandom(nCurr.getRandom().getNext());
            nCurr = nCurr.getNext().getNext();
        }

        Node nCopy = curr.getNext();
        nCurr = curr;
        while (nCurr != null && nCurr.getNext() != null) {
            nCurr.setNext(nCurr.getNext().getNext());
            nCurr = nCurr.getNext();
        }
        return nCopy;
    }

    public Node cloneLinkedListMap(Node head) {
        Node list = head;
        Node l = list;
        Node clone = null;
        Map<Node, Node> map = new HashMap<Node, Node>();
        while (l != null) {
            clone = new Node(l.getData());
            map.put(l, clone);
            l = l.getNext();
        }
        l = list;
        while (l != null) {
            clone = map.get(l);
            clone.setNext(map.get(l.getNext()));
            clone.setRandom(map.get(l.getRandom()));
            l = l.getNext();
        }
        return map.get(head);
    }
}
