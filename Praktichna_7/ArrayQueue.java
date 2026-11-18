public class ArrayQueue<T> {

    private Object[] elements; 
    private int head;          
    private int tail;         
    private int currentSize;   

    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Місткість черги має бути більшою за 0!");
        }
        this.elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.currentSize = 0;
    }

    public ArrayQueue() {
        this(10); 
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Помилка: Черга переповнена!");
        }
        elements[tail] = item;
        tail = (tail + 1) % elements.length; 
        currentSize++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Помилка: Черга порожня!");
        }
        T item = (T) elements[head];
        elements[head] = null; 
        head = (head + 1) % elements.length; 
        currentSize--;
        return item;
    }


    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Помилка: Черга порожня!");
        }
        return (T) elements[head];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0; 
    }

    public boolean isFull() {
        return currentSize == elements.length;
    }

    public void clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
        head = 0;
        tail = 0;
        currentSize = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Queue [] (порожня)";
        }
        StringBuilder sb = new StringBuilder("Queue (Head -> Tail): [");
        for (int i = 0; i < currentSize; i++) {
            int index = (head + i) % elements.length;
            sb.append(elements[index]);
            if (i < currentSize - 1) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
