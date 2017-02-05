package linkedlist;

import java.io.FileNotFoundException;

public class ConnectNextGreaterElement {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("nextGreater.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        Node n = nextElement(head);
        while (n != null) {
            if (n.getNextGreater() != null) {
                System.out.print(n.getNextGreater().getData() + ",");
            } else {
                System.out.print(0 + ",");
            }
            n = n.getNext();
        }
    }

    private static Node nextElement(Node head) {
        Node list = head;
        Node t = head;

        Node temp = list;
        while (list != null) {
            Node list1 = head;
            int min_of_max = Integer.MAX_VALUE;
            Node tempNext = null;
            while (list1 != null) {
                if (list1.getData() > list.getData() && min_of_max > list1.getData()) {
                    min_of_max = list1.getData();
                    tempNext = list1;
                }
                list1 = list1.getNext();
            }
            list.setNextGreater(tempNext);
            list = list.getNext();
        }
        return temp;
    }
}
