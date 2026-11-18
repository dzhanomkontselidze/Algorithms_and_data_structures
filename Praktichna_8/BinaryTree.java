public class BinaryTree {


    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root; 

    public BinaryTree() {
        this.root = null;
    }


    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value); 
        }
        if (value < current.data) {
            current.left = addRecursive(current.left, value);
        } else {
  
            current.right = addRecursive(current.right, value);
        }
        return current;
    }

 
    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data
                ? containsRecursive(current.left, value)
                : containsRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null; 
        }

        if (value < current.data) {
            current.left = deleteRecursive(current.left, value);
        } else if (value > current.data) {
            current.right = deleteRecursive(current.right, value);
        } else {
           
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }

            int smallestValue = findMinValue(current.right);
            current.data = smallestValue;
        
            current.right = deleteRecursive(current.right, smallestValue);
        }
        return current;
    }

    public void printAll() {
        if (root == null) {
            System.out.println("Дерево порожнє.");
            return;
        }
        System.out.print("Елементи дерева (за зростанням): ");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.print(current.data + " ");
            printInOrder(current.right);
        }
    }

    // 5. Вивести найменший елемент
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Помилка: Дерево порожнє!");
        }
        return findMinValue(root);
    }

    private int findMinValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Помилка: Дерево порожнє!");
        }
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public int count() {
        return countRecursive(root);
    }

    private int countRecursive(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + countRecursive(current.left) + countRecursive(current.right);
    }
}
