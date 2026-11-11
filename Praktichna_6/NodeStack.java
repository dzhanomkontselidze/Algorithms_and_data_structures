public class NodeStack<T> {

   
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> top; 
    private int currentSize; 
    public NodeStack() {
        this.top = null;
        this.currentSize = 0;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element, top);
        top = newNode;
        currentSize++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Помилка: Стек порожній! Неможливо виконати pop().");
        }
        T element = top.data;
        top = top.next; 
        currentSize--;
        return element;
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Помилка: Стек порожній! Неможливо виконати peek().");
        }
        return top.data;
    }

    public void clear() {
        top = null; 
        currentSize = 0;
    }

    public int count() {
        return currentSize;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Stack [] (порожній)";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Stack (top -> bottom): [");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
