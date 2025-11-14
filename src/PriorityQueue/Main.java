package PriorityQueue;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);
        pq.insert(1);
        pq.insert(3);
        pq.insert(5);
        pq.insert(7);
        pq.insert(2);
        System.out.println(Arrays.toString(pq.items));
    }
}
