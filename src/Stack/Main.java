package Stack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StackOperations s = new StackOperations(5);
        //String reversedString = s.reverse("lukog");
        //System.out.println(reversedString);
        //System.out.println(s.isBalancedString("(1+2)"));
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.pop();
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s.isEmpty());



//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.pop();
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack.isEmpty());
    }
}
