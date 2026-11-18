public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);


        queue.enqueue(6);
        queue.enqueue(4);
        queue.enqueue(2);
        queue.enqueue(7);

        System.out.println("Поточна черга: " + queue);
        System.out.println("Кiлькiсть елементiв: " + queue.size());
        System.out.println("Перший на вихiд (peek): " + queue.peek());

        System.out.println("\nВилучено: " + queue.dequeue());
        System.out.println("Вилучено: " + queue.dequeue());
        System.out.println("Пiсля видалення: " + queue);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Пiсля додавання по колу: " + queue);
        System.out.println("Новий розмiр: " + queue.size());
    }
}
