import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>(List.of(1,4,5));
        LinkedList<Integer> list2 = new LinkedList<>(List.of(1,3,4));
        LinkedList<Integer> list3 = new LinkedList<>(List.of(2,6));
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " +list1);
        System.out.println("List 3: " +list1);

    }
}
