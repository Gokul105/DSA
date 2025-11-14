package Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
//        trie.insert("cat");
//        trie.insert("can");
        //trie.insert("canada");
        //System.out.println(trie.contains("can"));
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("egg");
        var words = trie.findWords("car");
        System.out.println(words);
//        trie.traverse();
//        trie.remove("care");
//        System.out.println(trie.contains("car"));

    }
}
