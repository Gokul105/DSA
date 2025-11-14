package Heaps;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap();
//        heap.insert(10);
//        heap.insert(5);
//        heap.insert(17);
//        heap.insert(4);
//        heap.insert(22);
//        heap.remove();

        int[] numbers = {5,3,10,1,4,2};
        for(var num : numbers){
            heap.insert(num);
        }
//        for(int i = 0; i < numbers.length;i++)
//        {
//            numbers[i] = heap.remove();
//        }
        for(int i = numbers.length - 1 ; i >= 0 ;i--)
        {
            numbers[i] = heap.remove();
        }
        System.out.println(Arrays.toString(numbers));
        int[] heapifyNumbers = {5,3,8,4,1,2};
        MaxHeap.heapify(heapifyNumbers);
        System.out.println(Arrays.toString(heapifyNumbers));
        int[] kthLargeArray = {5,3,8,4,1,2};
        System.out.println(MaxHeap.getKthLargest(heapifyNumbers, 3));;



    }


}
