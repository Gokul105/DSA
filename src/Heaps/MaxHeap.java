package Heaps;

public class MaxHeap {
    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public static void heapify(int[] array, int index) {
        var largerIndex = index;
        var leftIndex = index * 2 + 1;
        var rightIndex = index * 2 + 2;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (largerIndex == index)
            return;
        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    public static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[]array , int k){
        Heap heap = new Heap();
        for (int item : array) {
            heap.insert(item);
        }
        for(int i = 0; i< k-1 ; i++)
            heap.remove();
        return heap.max();
    }

}
