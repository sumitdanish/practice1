package linkedlist;

import java.io.FileNotFoundException;

public class DetectLoopAndRemove {

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("loopnode.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        DetectLoopAndRemove d = new DetectLoopAndRemove();
        Node h = d.createLoop(head);
        Node h1 = d.detectLoopAndRemove(h);
        cl.printList(h1);
    }


    public Node createLoop(Node head) {
        Node loop = head;
        Node temp = null;
        int i = 0;
        while (i < 1) {
            i++;
            loop = loop.getNext();
        }
        temp = loop;
        while (loop.getNext() != null) {
            loop = loop.getNext();
        }
        loop.setNext(temp);
        return head;
    }

    public Node detectLoopAndRemove(Node head) {
        Node tempHead = head;
        Node slow = tempHead;
        Node fast = tempHead.getNext();
        while (slow != null && fast != null) {
            if (slow == fast) {
                System.out.println("jk : " + fast.getData());
                break;
            }
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast.getNext() != null) {
                fast = fast.getNext();
            }

        }
        if (fast == slow) {
            slow = tempHead;
            while (fast.getNext() != slow) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
            fast.setNext(null);
        }
        return tempHead;
    }


}
