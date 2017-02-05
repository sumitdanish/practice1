package array;

public class HeapImpl {
    static int[] heap;
    static int len = 0;
    static int front = 1;
    static int heap_size;

    public HeapImpl(int size) {
        try {
            heap_size = size;
            heap = new int[2 * size - 1];
            // System.out.println(len);
            // heap[0] = Integer.MIN_VALUE;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            HeapImpl minHeap = new HeapImpl(9);
            // minHeap.insert(Integer.MAX_VALUE);
            /*for (int i = 1; i <= 9; i++) {
				minHeap.insert(i);
			}*/
            minHeap.insert(5);
            minHeap.insert(3);
            minHeap.insert(17);
            minHeap.insert(10);
            minHeap.insert(84);
            minHeap.insert(19);
            minHeap.insert(6);
            minHeap.insert(22);
            minHeap.insert(9);
			/*
			 * minHeap.insert(6); minHeap.insert(22); minHeap.insert(-9);
			 */
            // minHeap.miHeap();
            // minHeap.print();
            for (int i = 1; i <= 9; i++) {
                System.out.print(minHeap.remove() + ",");
            }

            //System.out.println("Min Element > " + minHeap.remove() + "\n");

            // minHeap.print();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private int getLeftChild(int pos) {
        try {
            return (2 * pos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private int getRightChild(int pos) {
        try {
            return (2 * pos + 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private int getParent(int pos) {
        try {
            return pos / 2;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private void swapHeapNode(int pos, int leftOrRightNodeIndex) {
        try {
            int temp = heap[pos];
            heap[pos] = heap[leftOrRightNodeIndex];
            heap[leftOrRightNodeIndex] = temp;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void minHeapify(int pos) {
        try {
            int left = getLeftChild(pos);
            int right = getRightChild(pos);


            int s = pos;
            if (left <= heap_size
                    && heap[left] < heap[s]) {
                s = left;
            }
            if (right <= heap_size
                    && heap[right] < heap[s]) {
                s = right;
            }
            if (s != pos) {
                int temp = heap[pos];
                heap[pos] = heap[s];
                heap[s] = temp;
                minHeapify(s);
            }



			/*if (!isLeafNode(pos) && left < heap.length && right < heap.length) {
				if (heap[pos] > heap[getLeftChild(pos)] || heap[pos] > heap[getRightChild(pos)]) {
					if (heap[getLeftChild(pos)] < heap[getRightChild(pos)]) {
						swapHeapNode(pos, getLeftChild(pos));
						minHeapify(getLeftChild(pos));
					} else {
						swapHeapNode(pos, getRightChild(pos));
						minHeapify(getRightChild(pos));
					}
				}
			}*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void insert(int item) {
        try {
            heap[++len] = item;
            int current = len;
            while (heap[current] < heap[getParent(current)]) {
                swapHeapNode(current, getParent(current));
                current = getParent(current);
            }
            miHeap();
            System.out.println();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean isLeafNode(int pos) {
        try {
            return pos >= (len / 2) && pos <= len;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private int remove() {
        try {
            int min = heap[front];
            heap[front] = heap[len];
            minHeapify(front);
            //front++;
            return min;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private void miHeap() {
        int pos = 0;
        for (pos = (len - 1 / 2); pos >= 0; pos--) {
            System.out.println("POS : " + pos);
            minHeapify(pos);
        }
    }

}
