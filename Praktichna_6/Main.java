public class Main {
    public static void main(String[] args) {
        System.out.println("=== Створення та заповнення стеку ===");
        NodeStack<Integer> stack = new NodeStack<>();

        stack.push(11);
        stack.push(22);
        stack.push(33);

        System.out.println("Поточний стан стеку: " + stack.toString());
        System.out.println("Кількість елементів (size()): " + stack.size());
        System.out.println("Кількість елементів (count()): " + stack.count());

        System.out.println("\n=== Перегляд та вилучення ===");
        System.out.println("Елемент на вершині (peek()): " + stack.peek());
        System.out.println("Після peek() стек не змінився: " + stack.toString());

        System.out.println("Вилучений елемент (pop()): " + stack.pop());
        System.out.println("Стан стеку після pop(): " + stack.toString());
        System.out.println("Новий розмір: " + stack.size());

        System.out.println("\n=== Очищення стеку ===");
        stack.clear();
        System.out.println("Стан стеку після clear(): " + stack.toString());
        System.out.println("Чи порожній стек? " + stack.isEmpty());
    }
}
