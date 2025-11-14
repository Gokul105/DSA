package Arrays;

public class Solution {
    public static void main(String[] args) {
       Array numbers = new Array(3);
       numbers.insert(10);
       numbers.insert(20);
       numbers.insert(30);
       numbers.insert(40);
       numbers.removeAt(1);
       numbers.print();
       //System.out.println(numbers.indexOf(10));
    }

}