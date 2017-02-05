package linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class FlatenMultiLevel {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        Scanner sc = new Scanner(new File("cl.txt"));
        String[] s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head = cl.createList(head, data);
        }
        Node head2 = null;
        s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head2 = cl.createList(head2, data);
        }
        Node head3 = null;
        s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head3 = cl.createList(head3, data);
        }
        Node head4 = null;
        s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head4 = cl.createList(head4, data);
        }
        Node head5 = null;
        s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head5 = cl.createList(head5, data);
        }
        Node head6 = null;
        s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head6 = cl.createList(head6, data);
        }
        Node head7 = null;
        s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head7 = cl.createList(head7, data);
        }
        Node head8 = null;
        s = sc.nextLine().split(",");
        for (String k : s) {
            int data = Integer.parseInt(k);
            head8 = cl.createList(head8, data);
        }
        head.setChild(head2);
        head.getNext().getNext().getNext().setChild(head3);
        head3.setChild(head4);
        head4.setChild(head5);
        head2.getNext().setChild(head6);
        head2.getNext().getNext().setChild(head7);
        head7.setChild(head8);
        Node n = new FlatenMultiLevel().flattenVertical(head);
        cl.printList(n);
    }

    public Node flateHori(Node head) {
        Queue<Node> q = new LinkedList<Node>();
        Node list = head;
        Node curr = list;
        while (curr != null) {
            if (curr.getChild() != null) {
                q.add(curr.getChild());
                curr.setChild(null);
            }
            if (curr.getNext() == null) {
                curr.setNext(q.poll());
            }
            curr = curr.getNext();
        }
        return list;
    }

    //DFS
    public Node flattenVertical(Node head) {
        Stack<Node> st = new Stack<Node>();
        Node list = head;
        while (list != null) {
            if (list.getChild() != null) {
                while (list.getChild() != null) {
                    if (list != null && list.getNext() != null) {
                        st.push(list.getNext());
                        list.setNext(null);
                    }
                    list.setNext(list.getChild());
                    list = list.getChild();
                }
            }
            if (!st.isEmpty() && list.getNext() == null) {
                list.setNext(st.pop());
            }
            list = list.getNext();
        }
        return head;
    }

}
