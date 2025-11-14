package Trees;

public class Main {
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);
        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(4);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);

        System.out.print("PreOrder: ");
        tree1.traversePreOrder();
        System.out.println();
        System.out.print("InOrder: ");
        tree1.traverseInOrder();
        System.out.println();
        System.out.print("PostOrder: ");
        tree1.traversePostOrder();
        System.out.println();
        System.out.println("Tree height: " + tree1.height());
        System.out.println("Min value in tree: " + tree1.min());
        System.out.println(tree1.equals(tree2));
        System.out.println(tree1.isBinearySearchTree());
        var list = tree1.getNodesAtDistance(2);
        for(var value: list){
            System.out.print(value + " ");
        }
        System.out.println();
        tree1.traverseLevelOrder();
    }
}
