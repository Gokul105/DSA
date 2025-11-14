package HashTable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        CharFinder finder = new CharFinder();
//        //var ch = finder.firstNonRepeatedCharacter("a green apple");
//        var ch = finder.FirstRepeatedCharacter("green apple");
//        System.out.println(ch);
        HashTable table = new HashTable();
        table.put(6,"A");
        table.put(8,"B");
        table.put(11,"C");
        table.put(6,"A+");
        table.remove(6);
        String result = table.get(11);
        System.out.println(result);
    }

}
