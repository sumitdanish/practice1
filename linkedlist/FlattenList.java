package linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlattenList {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        Scanner sc = new Scanner(new File("d.txt"));
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("f.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        Node n = head;
        while (head != null && sc.hasNext()) {
            String[] s = sc.nextLine().split(",");
            Node k = null;
            for (String j : s) {
                int data = Integer.parseInt(j);
                Node d = new Node(data);
                if (k == null) {
                    k = d;
                } else {
                    Node temp = k;
                    while (temp.getDown() != null) {
                        temp = temp.getDown();
                    }
                    temp.setDown(d);
                }
            }
            head.setDown(k);
            head = head.getNext();
        }
        sc.close();
//		while(n != null){
//			Node n1 = n;
//			while(n1 != null){
//				System.out.print(n1.getData()+",");
//				n1 = n1.getDown();
//			}
//			System.out.println();
//			n = n.getNext();
//		}
//		
        Node j = new FlattenList().flatte(n);
        while (j != null) {
            System.out.print(j.getData() + ",");
            j = j.getDown();
        }
    }

    public Node merge(Node a, Node b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        Node re = null;
        if (a.getData() < b.getData()) {
            re = a;
            re.setDown(merge(a.getDown(), b));
        }
        if (a.getData() > b.getData()) {
            re = b;
            re.setDown(merge(a, b.getDown()));
        }
        return re;
    }

    public Node flatte(Node head) {
        if (head == null) {
            return null;
        }
        return merge(head, flatte(head.getNext()));
    }

}
