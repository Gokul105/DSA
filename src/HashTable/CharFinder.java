package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    char firstNonRepeatedCharacter(String input) {
        char[] inputArray = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : inputArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : inputArray) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }

    char FirstRepeatedCharacter(String input){
        Set<Character> set = new HashSet<>();
        char[] inputArray = input.toCharArray();
        for (char ch : inputArray) {
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
