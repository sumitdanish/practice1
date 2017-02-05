package array;

public class Heap {
    protected int[] data;

    public Heap(int size) {
        data = new int[2 * size + 1];
        this.data[0] = 0;
    }

    public static void main(String[] args) {
        Heap h = new Heap(10);
        /*h.insert(2);
	    h.insert(4);
	    h.insert(1);
	    h.insert(-10);*/
        h.insert(1);
        h.insert(5);
        h.insert(10);
        h.insert(11);
        h.insert(12);
        h.insert(13);
        h.insert(14);
        h.insert(15);
        h.insert(16);
        h.insert(19);
        for (int i = 1; i <= 10; i++) {
            System.out.println(h.remove());
        }
        //h.printHeapList();
	    /*int x = h.remove();
	    System.out.println(x);
	    int x1 = h.remove();
	    System.out.println(x1);
	    int x2 = h.remove();
	    System.out.println(x2);*/
        //h.printHeapList();
        //System.out.printf("%d\n", h.minValue());
    }

    public Heap insert(int value) {

        ++this.data[0];
        this.data[this.data[0]] = value;
        this.bubbleUp(this.data[0]);
        return this;
    }

    protected void bubbleUp(int index) {
        int parentIndex = index / 2;
        if (index == 1 || this.data[parentIndex] < this.data[index]) {
            return;
        }
        int parentValue = this.data[parentIndex];
        this.data[parentIndex] = this.data[index];
        this.data[index] = parentValue;
        bubbleUp(parentIndex);
    }

    public int remove() {
        int minValue = this.data[1];
        int lastValue = this.data[this.data[0]--];
        this.data[1] = lastValue;
        this.sinkDown(1);
        return minValue;
    }

    protected boolean isLeaf(int index) {
        return (index * 2) > this.data[0];
    }

    protected void sinkDown(int index) {
        if (this.isLeaf(index)) {
            return;
        }
        int leftChildIndex = index * 2;
        int rightChildIndex = (index * 2) + 1;
        int minChildIndex;
        if (rightChildIndex > this.length()) {
            minChildIndex = leftChildIndex;
        } else {

            minChildIndex = (this.data[leftChildIndex] <
                    this.data[rightChildIndex]) ? leftChildIndex : rightChildIndex;
        }
        if (this.data[index] < this.data[minChildIndex]) return;

        int childValue = this.data[minChildIndex];
        this.data[minChildIndex] = this.data[index];
        this.data[index] = childValue;

        sinkDown(minChildIndex);
    }

    public int minValue() {
        return this.data[1];
    }

    public int length() {
        return this.data[0];
    }
}
