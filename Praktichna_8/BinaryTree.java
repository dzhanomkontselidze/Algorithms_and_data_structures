public class BinaryTree {

    private static class Node {
        int data;   
        Node left;  //посилання на меншьший зліва (якщо немає — тут null)
        Node right; //посилання на більшого або рівного елемента справа

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
        Node newNode = new Node(value); 

        if (root == null) {
            root = newNode;
            return;
        }

        // Стаєм на верхівку 
        Node current = root;
        while (true) {
            if (value < current.data) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    //більше-менше
    public boolean contains(int value) {
        Node current = root; 
        // Йдемо вниз, поки не впремося 
        while (current != null) {
            // Знайшли точний збіг
            if (value == current.data) {
                return true;
            }
            current = (value < current.data) ? current.left : current.right;
        }
    
        return false;
    }

    public void delete(int value) {
        Node parent = null;  //Помнім батька, щоб потім переключити його руку на іншу дитину
        Node current = root; // Цим вказівником шукаємо сам вузол, який треба прибрати

        //жертву
        while (current != null && current.data != value) {
            parent = current;
            current = (value < current.data) ? current.left : current.right;
        }

        if (current == null) {
            return;
        }

        //(і зліва, і справа)
        if (current.left != null && current.right != null) {
            Node successorParent = current;
            Node successor = current.right; //крок направо

            //і йдемо до упору наліво
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            // Просто перезаписуємо число на знайденого "спадкоємця"
            current.data = successor.data;


            current = successor;
            parent = successorParent;
        }

        // 0 або 1 дитина)
        Node child = (current.left != null) ? current.left : current.right;

        if (parent == null) {
            // Якщо видаляли сам корінь  його дитина стає новим коренем
            root = child;
        } else if (parent.left == current) {
            // Якщо видалений вузол був лівою рукою батька — чіпляємо онука на ліву руку
            parent.left = child;
        } else {
            // Якщо був правою рукою — чіпляємо онука на праву руку
            parent.right = child;
        }
    }

    //строго за зростанням
    public void printAll() {
        if (root == null) {
            System.out.println("Дерево порожнє.");
            return;
        }
        System.out.print("Елементи дерева (In-Order): ");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node current) {
        if (current != null) {
            printInOrder(current.left);       // що менше (зліва)
            System.out.print(current.data + " "); // Пчисло по центру
            printInOrder(current.right);      // більше (справа)
        }
    }


    public void printTree() {
        if (root == null) {
            System.out.println("(порожнє дерево)");
            return;
        }
        printTreeRecursive(root, "", true);
    }

    private void printTreeRecursive(Node node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }
        
        if (node.right != null) {
       
            printTreeRecursive(node.right, prefix + (isTail ? "    " : "│   "), false);
        }

        System.out.println(prefix + (isTail ? "└── " : "┌── ") + node.data);

       
        if (node.left != null) {
            printTreeRecursive(node.left, prefix + (isTail ? "    " : "│   "), true);
        }
    }

    // лежить у самому лівому кутку
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Дерево порожнє!");
        }
        Node current = root;
        // ліворуч, поки попереду є хоч один вузол
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    // самому правому кутку
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Дерево порожнє!");
        }
        Node current = root;
        
        //праворуч до самого упору
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    //кожен вузол рахує себе
    public int count() {
        return countNodes(root);
    }

    private int countNodes(Node current) {
        //до порожнечі (null) — там 0 вузлів
        if (current == null) {
            return 0;
        }
        // Повертаємо 1 і додаємо кількість з обох гілок
        return 1 + countNodes(current.left) + countNodes(current.right);
    }
}
