package linkedlist;

import java.io.FileNotFoundException;

public class NextGreaterArbitPointer {

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException {
        // TODO Auto-generated method stub
        CreateList cl = new CreateList();
        NextGreaterArbitPointer zi = new NextGreaterArbitPointer();
        Node n = null;
        for (String s : FIleUtil.getValue("arbitpointer.txt")) {
            n = cl.createList(n, Integer.parseInt(s));
        }
        zi.reverse(n, null);
        //cl.printList();
        System.out.println(n.getNext().getArbitNext().getData());
    }

    public void reverse(Node node, Node maxNode) {
        if (node == null) {
            return;
        }
        if (node != null && node.getNext() == null) {
            maxNode = node;
            return;
        }
        reverse(node.getNext(), maxNode);
        node.setArbitNext(maxNode);
        if (maxNode.getData() < node.getData()) {
            maxNode = node;
        }

        return;
    }
}
