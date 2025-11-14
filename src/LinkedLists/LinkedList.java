package LinkedLists;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    void addLast(int item) {
        var node = new Node(item);
        if(first == null)
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
      size++;
    }

    void addFirst(int item) {
        var node = new Node(item);
        if(first == null)
            first = last = node;
        else{
           node.next = first;
           first = node;
        }
      size ++;
    }
    int indexOf(int item){
        int index = 0;
        var current  = first;
        while(current != null){
            if(current.value == item){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    int size(){
        return size;
    }
    void deleteFirst(){
        if(first == null)
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size --;
    }

    int[] toArray(){
        var array = new int[size];
        var current = first;
        var index = 0;
        while(current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    void deleteLast(){
        if(first == null)
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
        }
        else {
            var current = first;
            while (current != null) {
                var previous = current;
                if (current.next == last) {
                    last = previous;
                    last.next = null;
                }
                current = current.next;

            }
        }
        size--;
    }

    void reverse(){

        // [10->20->30]
        // prev curr next
        // [10<-20<-30]
       var previous = first;
        var current = first.next;
       while(current != null){
           var next  = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }
       last = first;
       last.next = null;
       first = previous;
    }

    int getKthFromTheEnd(int k){
        var start = first;
        var end = first;
        if(k > size){
            throw new IllegalArgumentException("k larger than size of linked list");
        }
        for (int i = 0; i < k-1; i++){
            end = end.next;
        }
        while(end != last){
            start = start.next;
            end = end.next;
        }
        return start.value;
    }


}
