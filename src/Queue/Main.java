package Queue;

public class Main {
    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(10);
//        queue.add(20);
//        queue.add(30);
//        //queue.offer(40);
//        //queue.remove();
//        reverse(queue);
//        System.out.println(queue);
//        ArrayQueue queue = new ArrayQueue(4);
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.enqueue(30);
//        queue.enqueue(40);
//        queue.dequeue();
//        queue.dequeue();
//        queue.enqueue(50);
//        queue.enqueue(60);
//        //queue.enqueue(70);
//        System.out.println(queue);
//        System.out.println(queue.peek());
//        System.out.println(queue.isEmpty());
//        System.out.println(queue.isFull());

        QueueWithStack queue = new QueueWithStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        //queue.dequeue();
        System.out.println(queue.peek());
    }

//    public static void reverse(Queue<Integer> queue){
//        Stack<Integer> stack = new Stack<>();
//        while(!queue.isEmpty()){
//             stack.add(queue.remove());
//        }
//       while(!stack.isEmpty()){
//           queue.add(stack.pop());
//       }
//    }

}
