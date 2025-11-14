package LinkedLists;


import java.sql.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
//        list.deleteFirst();
//        list.deleteLast();
//        list.addFirst(5);
        System.out.println("Kth element from end: " + list.getKthFromTheEnd(1));
        var array = list.toArray();
        System.out.println("Array: "+ Arrays.toString(array));
        System.out.println("Size: " + list.size());
        list.reverse();
        var reversedArray = list.toArray();
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));

        //System.out.println(list.indexOf(20));
    }
}
