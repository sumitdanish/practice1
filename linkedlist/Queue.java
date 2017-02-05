package linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Queue {

    QueueImpl rear = null;
    QueueImpl front = null;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("queue.txt"));
        String[] s = sc.nextLine().split(",");
        Queue q = new Queue();
        for (String s1 : s) {
            int data = Integer.parseInt(s1);
            q.insertIntoFront(data);
        }
        QueueImpl q1 = q.dequeueFront();
        System.out.println(q1.getData());
    }

    public void insertIntoFront(int data) {
        QueueImpl queue = new QueueImpl(data);
        if (front == null && rear == null) {
            front = rear = queue;
        } else {
            QueueImpl temp = front;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(queue);
            front = temp;
        }
    }

    public void insertIntoRear(int data) {
        QueueImpl queue = new QueueImpl(data);
        if (front == null && rear == null) {
            front = rear = queue;
        } else {
            queue.setNext(rear);
            rear = queue;
        }
    }

    public QueueImpl dequeueFront() {
        if (rear == null && front == null) {
            return null;
        }
        if (rear == front) {
            QueueImpl q = front;
            front = null;
            rear = null;
            return q;
        }
        QueueImpl q1 = rear;
        rear = rear.getNext();
        return q1;
    }
}

class QueueImpl {
    private QueueImpl next;
    private int data;

    public QueueImpl(int data) {
        this.data = data;
    }

    public QueueImpl getNext() {
        return next;
    }

    public void setNext(QueueImpl next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}