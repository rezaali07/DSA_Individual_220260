package Q3;

public class PriorityQueueu_3B {

    MinHeap_3B heap; // Instance variable representing the MinHeap

    // Constructor to initialize the PriorityQueueu_3B with a MinHeap
    PriorityQueueu_3B() {
        heap = new MinHeap_3B(); // Initialize the MinHeap
    }

    // Method to dequeue (remove and return) the element with the minimum value from the priority queue
    int dequeue() {
        return heap.deleteHeap(0); // Call the deleteHeap method of MinHeap to remove the root element (minimum value)
    }

    // Method to enqueue (insert) an element into the priority queue
    void queue(int element) {
        heap.insertHeap(element); // Call the insertHeap method of MinHeap to insert the element
    }

    // Main method to test the functionality of the priority queue
    public static void main(String[] args) {
        PriorityQueueu_3B pq = new PriorityQueueu_3B(); // Create an instance of PriorityQueueu_3B
        pq.queue(12); // Enqueue some elements
        pq.queue(213);
        pq.queue(99);
        pq.queue(21);
        pq.queue(143);

        pq.dequeue(); // Dequeue an element
        System.out.println(pq); // Print the priority queue
    }

    // Method to override the toString method to print the priority queue
    @Override
    public String toString() {
        return heap.heapList.toString(); // Convert the MinHeap's heapList to string and return
    }

}
