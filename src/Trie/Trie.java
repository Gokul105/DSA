package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private final Node root = new Node(' ');

    private static class Node {
        //public static int ALPHABET_SIZE = 26;
        char value;
        HashMap<Character, Node> children = new HashMap<>();
        //Node[] children = new Node[ALPHABET_SIZE];
        boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }
        public Node[] getChildern()
        {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void removeChild(char ch){
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "value = " + value;
        }
    }

    void insert(String word) {
        var current = root;
        var inputArray = word.toCharArray();
        for (var ch : inputArray) {
            //var index = ch - 'a';
            if (!current.hasChild(ch))
                current.addChild(ch);
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    boolean contains(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }

    private void traverse(Node root){
        //pre-order traversal
//        System.out.println(root.value);
//        for(var child : root.getChildern())
//            traverse(child);

//        //post-order traversal
        for(var child : root.getChildern())
            traverse(child);
        //System.out.println(root.value);
    }

    public void remove(String word){
        remove(word,root,0);
    }

    private void remove(String word, Node root , int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child==null){
            return;
        }
        remove(word , child , index+1);
        if(!child.hasChildren() && !child.isEndOfWord){
            root.removeChild(ch);
        }
    }

    public List<String> findWords(String prefix){
        List<String> words = new ArrayList<>();
        var lastNode = lastNodeOf(prefix);
        findWords(lastNode , prefix , words);
        return words;
    }

    private void findWords(Node root, String prefix , List<String> words){
       if(root.isEndOfWord)
           words.add(prefix);
       for(var child : root.getChildern())
           findWords(child , prefix + child.value , words);
    }

    public Node lastNodeOf(String prefix){
        var current = root;
        for(var ch : prefix.toCharArray()){
            var child = current.getChild(ch);
            if(child == null)
                return null;
            current = child;
        }
       return current;
    }
}
