package PriorityQueue;

public class PriorityQueue {
    int[] items;
    int count;
    PriorityQueue(int length){
        items = new int[length];
    }
    void insert(int item){
         if(count == items.length)
            throw new IllegalStateException();
        int i;
        for(i = count - 1; i>0;i--){
            if(items[i] > item){
                items[i+1] = items[i];
            }
            else
                break;
        }
        items[i+1] = item;
        count++;
    }
}
