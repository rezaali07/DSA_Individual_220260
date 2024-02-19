package Q3;

import java.util.ArrayList;

public class MinHeap {
    // Min heap is such that binary tree where Parent node<=child node
    ArrayList<Integer> heapList;

    MinHeap() {
        heapList = new ArrayList<>();
    }

    void swapheapListitems(int index1, int index2) {
        heapList.add(index1, heapList.get(index2));
        // add pushes existing element to right so we remove the next index
        heapList.add(index2, heapList.get(index1 + 1));
        heapList.remove(index2 + 1);
        heapList.remove(index1 + 1);
    }

    void insertHeap(int data) {
        heapList.add(data);
        int childIndex = heapList.size() - 1;
        while (childIndex > 0) {
            // Continue swapping until the inserted data is at top or is in correct
            // position.
            int parentIndex = (childIndex - 1) / 2;

            if (heapList.get(childIndex) < heapList.get(parentIndex)) {
                swapheapListitems(childIndex, parentIndex);

                childIndex = parentIndex; // After swapping the indexes get swapped as well.
            } else {
                return;
            }
        }
    }

    int deleteHeap(int n) {
        int temp = heapList.remove(0);
        heapList.add(0, heapList.get(n));
        int index = heapList.size();

        while (index <= heapList.size()) {
            int largestIndex = index;
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;

            if (leftChild <= heapList.size() && heapList.get(leftChild) > heapList.get(largestIndex)) {
                largestIndex = leftChild;
            }
            if (rightChild <= heapList.size() && heapList.get(rightChild) > heapList.get(largestIndex)) {
                largestIndex = rightChild;
            }

            if (largestIndex != index) {
                swapheapListitems(largestIndex, index);
                index = largestIndex; // Top
            } else
                return temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        MinHeap hp = new MinHeap();
        hp.insertHeap(12);
        hp.insertHeap(22);
        hp.insertHeap(76);
        hp.insertHeap(2);
        hp.insertHeap(931);
        hp.insertHeap(24);
        System.out.println(hp.heapList);
    }

}
