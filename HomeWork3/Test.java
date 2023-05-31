package HomeWork3;

public class Test {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.add(100);
        tree.add(80);
        tree.add(130);
        tree.add(40);
        tree.add(90);
        tree.add(110);
        tree.add(170);
        tree.add(20);
        tree.add(60);
        tree.add(165);
        tree.add(50);
        tree.add(70);
        tree.add(55);
        tree.printTree();
        tree.remove(100);
        tree.remove(110);
        tree.printTree();
        System.out.println(tree.lenght());
    }
}
