public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

    
        int[] values = {3, 1, 9, 1, 7, 10, 6, 8};
        for (int v : values) {
            tree.add(v);
        }

        System.out.println("=== Початкове дерево ===");
        tree.printTree();
        tree.printAll();
        System.out.println("Кiлькiсть: " + tree.count() + " | Min: " + tree.findMin() + " | Max: " + tree.findMax());

        System.out.println("\n=== Видаляємо 3 (корiнь з двома дiтьми -> замiна на 6) ===");
        tree.delete(3);
        tree.printTree();

        System.out.println("\n=== Видаляємо 6 (замiна на 7, пiдтягується 8) ===");
        tree.delete(6);
        tree.printTree();
    }
}
