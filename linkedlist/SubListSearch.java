package linkedlist;

import java.io.FileNotFoundException;

public class SubListSearch {

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        // TODO Auto-generated method stub
        CreateList cl = new CreateList();
        Node head1 = null;
        for (String s : FIleUtil.getValue("sub1.txt")) {
            head1 = cl.createList(head1, Integer.parseInt(s));
        }
        Node head2 = null;
        for (String s : FIleUtil.getValue("sub2.txt")) {
            head2 = cl.createList(head2, Integer.parseInt(s));
        }
        boolean flag = new SubListSearch().isListSearch(head1, head2);
        System.out.println(flag);

    }


    public boolean isListSearch(Node head1, Node head2) {
        Node n1 = head1;
        Node n2 = head2;
        Node prev2 = null;
        Node prev3 = null;
        boolean flag = false;
        while (n2 != null) {
            if (n1.getData() == n2.getData()) {
                n1 = n1.getNext();
                prev2 = n2;
                flag = true;
            } else {

                prev3 = n2;
                n1 = head1;
                flag = false;
            }

            if (n1 == null) {
                return true;
            }
            if (flag == true) {
                n2 = n2.getNext();
            } else if (prev2 != null) {
                n2 = prev2.getNext();
            } else {
                n2 = prev3.getNext();
            }

        }
        return false;
    }

}
