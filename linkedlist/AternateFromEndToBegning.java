package linkedlist;

import java.io.FileNotFoundException;

public class AternateFromEndToBegning {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Node head = null;
        CreateList cl = new CreateList();
        for (String s : FIleUtil.getValue("al.txt")) {
            head = cl.createList(head, Integer.parseInt(s));
        }
        cl.printList(head);
        System.out.println();

    }


}
