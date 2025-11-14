package Trees;


import java.util.ArrayList;

public class Tree {
    Node root;

    private class Node {
        int value;
        Node leftChild, rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    public void insert(int value){
        root = insert(root,value);
    }
    private Node insert(Node root , int value) {
        if(root == null)
            return new Node(value);

        if(value < root.value){
            root.leftChild = insert(root.leftChild , value);
        }
        else
            root.rightChild = insert(root.rightChild, value);
        return root;
//        var node = new Node(value);
//        if (root == null) {
//            root = new Node(value);
//            return;
//        }
//
//        var current = root;
//        while (true) {
//            if (value < current.value) {
//                if (current.leftChild == null) {
//                    current.leftChild = node;
//                    break;
//                }
//                current = current.leftChild;
//            } else {
//                if (current.rightChild == null) {
//                    current.rightChild = node;
//                    break;
//                }
//                current = current.rightChild;
//            }
//
//        }

    }

    boolean find(int value) {
        if (root == null) {
            throw new IllegalStateException();
        }
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    void traversePreOrder() {
        traversePreOrder(root);
    }

    void traverseInOrder() {
        traverseInOrder(root);
    }

    void traversePostOrder() {
        traversePostOrder(root);
    }

    int height() {
        return height(root);
    }

    //o(logn)
    public int min() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.print(root.value + " ");
        traverseInOrder(root.rightChild);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    //o(n)
    private int min(Node root) {
        if (root==null){
            return Integer.MAX_VALUE;
        }
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    private int height(Node root) {
        if (root == null)
            return -1;
        if (isLeaf(root))
            return 0;
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equals(Tree other){
        if(other == null)
                return false;
        return equals(root , other.root);
    }

    private boolean equals(Node first , Node second){
        if(first == null && second == null)
            return true;
        if(first !=null && second !=null)
            return first.value == second.value && equals(first.leftChild , second.leftChild)
            && equals(first.rightChild , second.rightChild);

     return false;
    }

    public boolean isBinearySearchTree(){
      return isBinearySearchTree(root , Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinearySearchTree(Node root , int min , int max){
        if(root == null)
            return true;
        if(root.value < min || root.value > max)
            return false;
        return isBinearySearchTree(root.leftChild , min , root.value - 1) &&
                isBinearySearchTree(root.rightChild , root.value+1 , max);
    }
    public ArrayList<Integer> getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root , distance , list );
        return list;
    }
    private void getNodesAtDistance(Node root , int distance, ArrayList list){
        if(root==null)
            return;
        if(distance == 0){
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild ,distance - 1 , list);
    }

    void traverseLevelOrder(){
        for(var i = 0; i<= height();i++){
            for(var value: getNodesAtDistance(i)){
                System.out.print(value+" ");
            }
        }
    }

}
