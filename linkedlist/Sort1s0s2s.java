package linkedlist;

import java.io.FileNotFoundException;

public class Sort1s0s2s {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        CreateList cl = new CreateList();
        Sort1s0s2s so = new Sort1s0s2s();
        Node n = new Node();
        for (String s1 : FIleUtil.getValue("os1s.txt")) {
            n = cl.createList(n, Integer.parseInt(s1));
        }
        cl.printList(n);
        System.out.println();
        so.sort(n);
        cl.printList(n);
    }

    public void sort(Node ll) {
        int[] count = new int[3];
        Node n = ll;
        Node n1 = ll;
        while (n != null) {
            count[n.getData()]++;
            n = n.getNext();
        }
        int i = 0;
        while (n1 != null) {
            if (count[i] == 0) {
                i++;
            } else {
                n1.setData(i);
                count[i]--;
                n1 = n1.getNext();
            }
        }
    }


}
