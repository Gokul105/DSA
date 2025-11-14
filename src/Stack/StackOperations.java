package Stack;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;
import java.util.Arrays;
import java.util.Stack;

public class StackOperations {
    public static final List<Character> RIGHT_BRACKETS = Arrays.asList(')', '}', ']', '>');
    private static final List<Character> LEFT_BRACKETS = Arrays.asList('(', '{', '[', '<');
    int[] stack;
    int size = 0;

    public StackOperations(int n) {
        stack = new int[n];
    }

    String reverse(String input) {
        Stack<Character> stack = new Stack<>();
        StringBuilder reversed = new StringBuilder();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    boolean isBalancedString(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);
            else if (isRighBracket(ch)) {
                if (stack.isEmpty())
                    return false;
                var top = stack.pop();
                if (!bracketsMatch(top, ch))
                    return false;
            }

        }
        return stack.isEmpty();
    }

    private boolean isLeftBracket(char ch) {
        return LEFT_BRACKETS.contains(ch);
    }

    private boolean isRighBracket(char ch) {
        return RIGHT_BRACKETS.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return LEFT_BRACKETS.indexOf(left) == RIGHT_BRACKETS.indexOf(right);
    }

    void push(int n) {
        if(size == stack.length){
            throw new StackOverflowError();
        }
        stack[size++] = n;
    }
    int pop() {
        if(size == 0)
            throw new IllegalArgumentException();
        return stack[--size];
    }
    int peek(){
        if(size == 0)
            throw new IllegalStateException();
        return stack[--size];
    }
    boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString(){
       var content = Arrays.copyOfRange(stack,0,size);
       return Arrays.toString(content);
    }
}
