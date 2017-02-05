package linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DLLQueue {

    DLL front = null;
    DLL rear = null;
    DLL dllQueue = null;

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(new File("queue.txt"));
        String[] s = sc.nextLine().split(",");
        DLLQueue dq = new DLLQueue();
        for (String s1 : s) {
            int data = Integer.parseInt(s1);
            dq.enqueu(data);
        }
        //DLL d = dq.deQueueFront();
        System.out.println(dq.deQueueRear().getData());
        System.out.println(dq.deQueueFront().getData());

    }

    public void enqueu(int data) {
        DLL d = new DLL(data);
        if (front == null && rear == null) {
            front = rear = d;

        } else {
            DLL d1 = front;
            while (d1.getNext() != null) {
                d1 = d1.getNext();
            }
            d1.setNext(d);
            d.setPre(d1);
            front = d;
        }
    }

    public DLL deQueueFront() {
        if (front == null && rear == null) {
            return null;
        }
        if (front == rear) {
            DLL d = rear;
            rear = null;
            front = null;
            return d;
        }
        DLL d = front;
        front = front.getPre();
        front.setNext(null);
        return d;
    }

    public DLL deQueueRear() {
        if (front == null && rear == null) {
            return null;
        }
        if (front == rear) {
            DLL d = rear;
            rear = null;
            front = null;
            return d;
        }
        DLL d = rear;
        rear = rear.getNext();
        rear.setPre(null);
        return d;
    }

}

class DLL {
    private int data;
    private DLL next;
    private DLL pre;

    public DLL(int data) {
        this.data = data;
    }

    public DLL getNext() {
        return next;
    }

    public void setNext(DLL next) {
        this.next = next;
    }

    public DLL getPre() {
        return pre;
    }

    public void setPre(DLL pre) {
        this.pre = pre;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}
