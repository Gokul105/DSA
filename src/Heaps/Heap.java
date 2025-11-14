package Heaps;

public class Heap {
    public Heap(int n) {
        heap = new int[n];
    }

    int[] heap;
    int size;

    void insert(int value) {
        if (size == heap.length)
            throw new IllegalStateException();
        heap[size++] = value;
        var index = size - 1;
        while (index > 0 && heap[index] > heap[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    public void remove() {
        if (size == 0)
            throw new IllegalStateException();

        heap[0] = heap[--size];
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largerIndex = largerIndex(index);
            swap(index, largerIndex);
            index = largerIndex;
        }

    }

    private int largerIndex(int index) {
        if(!hasLeftChild(index)){
            return index;
        }
        if(!hasRightChild(index))
            return leftChildIndex(index);

        return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;
        var isValid = heap[index] >= leftChild(index);
        if(hasRightChild(index)){
            isValid &= heap[index] >= rightChild(index);
        }
        return isValid;
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) < size;
    }

    private int leftChild(int index) {
        return heap[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return heap[rightChildIndex(index)];
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

}
