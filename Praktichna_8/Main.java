public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int[] values = {3, 1, 9, 1, 7, 10, 6, 8};
        for (int val : values) {
            tree.add(val);
        }

        System.out.println("=== Початковий стан дерева ===");
        tree.printAll();
        System.out.println("Кількість елементів: " + tree.count());
        System.out.println("Найменший елемент: " + tree.findMin());
        System.out.println("Найбільший елемент: " + tree.findMax());

        System.out.println("\n=== Пошук елементів ===");
        System.out.println("Чи є число 7 у дереві? " + tree.contains(7));
        System.out.println("Чи є число 5 у дереві? " + tree.contains(5));

        System.out.println("\n=== Видалення елементів (як у прикладі з ПР) ===");
        tree.delete(3);
        System.out.println("Після видалення 3:");
        tree.printAll();

        tree.delete(6);
        System.out.println("Після видалення 6:");
        tree.printAll();

        tree.delete(10);
        System.out.println("Після видалення 10 (листок):");
        tree.printAll();
        System.out.println("Нова кількість елементів: " + tree.count());
    }
}
