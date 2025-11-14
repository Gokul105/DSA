package Queue;

import java.util.Arrays;

public class ArrayQueue {
    int[] queue ;
    int front ;
    int rear ;
    int count ;
    public ArrayQueue(int n){
        queue = new int[n];
    }
    void enqueue(int n){
        int length = queue.length;
        if(count == length)
            throw new IllegalStateException();
        queue[rear] = n;
        rear = (rear + 1)  % length;
        count++;
    }
    int dequeue(){
        int item = queue[front];
        queue[front] = 0;
        front = (front + 1)  % queue.length;
        count--;
        return item;
    }
    int peek(){
        return queue[front];
    }
    boolean isEmpty(){
        return count == 0;
    }
    boolean isFull(){
        return count == queue.length;
    }
    @Override
    public String toString(){
        //var content = Arrays.copyOfRange(queue,front,rear);
        return Arrays.toString(queue);
    }
}
