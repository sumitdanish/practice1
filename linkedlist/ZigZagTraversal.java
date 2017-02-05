package linkedlist;

import java.io.FileNotFoundException;

public class ZigZagTraversal {
    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        CreateList cl = new CreateList();
        ZigZagTraversal zi = new ZigZagTraversal();
        Node n = null;
        for (String s : FIleUtil.getValue("zigzaglist.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }
        Node n2 = zi.zigZagList(n);
        cl.printList(n2);
    }

    public Node zigZagList(Node n) {
        boolean flag = false;
        Node n1 = n;
        while (n1 != null && n1.getNext() != null) {
            if (flag == false) {
                if (n1.getData() > n1.getNext().getData()) {
                    int temp = n1.getData();
                    n1.setData(n1.getNext().getData());
                    n1.getNext().setData(temp);
                }
            } else if (flag == true) {
                if (n1.getData() < n1.getNext().getData()) {
                    int temp = n1.getData();
                    n1.setData(n1.getNext().getData());
                    n1.getNext().setData(temp);
                }
            }
            flag = !flag;
            n1 = n1.getNext();
        }
        return n;
    }
}
