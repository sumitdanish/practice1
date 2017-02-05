package linkedlist;

import java.io.FileNotFoundException;

public class SumOfTwoLinkeList2 {

    int carry = 0;

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        CreateList cl = new CreateList();
        Node n = new Node();
        SumOfTwoLinkeList2 s = new SumOfTwoLinkeList2();
        for (String s1 : FIleUtil.getValue("ll.txt")) {
            n = cl.createList(n, Integer.parseInt(s1));
        }
        CreateList cl1 = new CreateList();
        Node n2 = new Node();
        for (String s3 : FIleUtil.getValue("list2.txt")) {
            n2 = cl1.createList(n2, Integer.parseInt(s3));
        }
        Node n3 = s.addTwoLinkList(n, n2);
        cl1.printList(n3);

    }


    public int len(Node nn) {
        if (nn == null) {
            return 0;
        }
        return 1 + len(nn.getNext());
    }

    public Node addTwoLinkList(Node ll1, Node ll2) {
        Node result = null;
        Node result1 = null;
        int len1 = len(ll1);
        int len2 = len(ll2);
        Node head1 = ll1;
        Node head2 = ll2;
        Node fhead1 = head1;
        Node rem = null;
        Node fhead2 = head2;
        int k = 0;
        if (len1 > len2) {
            k = len1 - len2;
            int i = 0;
            fhead1 = head1;
            rem = fhead1;
            fhead2 = head2;
            while (fhead1 != null && i < k) {
                fhead1 = fhead1.getNext();
                i++;
            }
        }
        if (len2 > len1) {
            int j = 0;
            k = len2 - len1;
            fhead1 = head2;
            rem = fhead1;
            fhead2 = head1;
            while (fhead1 != null && j < k) {
                fhead1 = fhead1.getNext();
                j++;
            }
        }
        result = addTwoEqualList(fhead1, fhead2);
        result1 = addCarryToRemaining(rem, fhead1);
        Node n = result1;
        while (n.getNext() != null) {
            n = n.getNext();
        }
        //System.out.println(n.getData());
        n.setNext(result);
        result = result1;
        return result;
    }

    public Node addTwoEqualList(Node ll, Node ll1) {
        if (ll1 == null && ll1 == null) {
            return null;
        }
        Node result = new Node();
        int sum = 0;
        result.setNext(addTwoEqualList(ll.getNext(), ll1.getNext()));
        sum = ll.getData() + ll1.getData() + carry;
        carry = sum / 10;
        result.setData((sum % 10));
        return result;
    }

    public Node addCarryToRemaining(Node ll, Node ll1) {
        if (ll == ll1) {
            return null;
        }
        Node result = new Node();
        int sum = 0;
        result.setNext(addCarryToRemaining(ll.getNext(), ll1));
        sum = ll.getData() + carry;
        carry = sum / 10;
        result.setData(sum % 10);
        return result;
    }

}
