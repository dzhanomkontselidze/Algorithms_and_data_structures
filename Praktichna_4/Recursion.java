import java.util.Scanner;

public class Recursion {

    // 1
    public static void printUpTo(int n) {
        if (n == 0) return;          
        printUpTo(n - 1);            
        System.out.print(n);         
        System.out.print(' ');
    }

    // 2
    public static void printFromTo(int a, int b) {
        System.out.print(a);
        System.out.print(' ');
        if (a == b) return;         
        if (a < b) {
            printFromTo(a + 1, b);  
        } else {
            printFromTo(a - 1, b);  
        }
    }

    // 3
    public static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;         
        if (n % 2 != 0) return false;    
        return isPowerOfTwo(n / 2);      
    }

    // 4
    public static int digitSum(int n) {
        if (n == 0) return 0;
        return n % 10 + digitSum(n / 10);  
    }

    // 5
    public static void printReverse(int n) {
        if (n == 0) return;
        System.out.print(n % 10);        
        System.out.print(' ');
        printReverse(n / 10);            
    }

    // 6
    public static void printForward(int n) {
        if (n == 0) return;
        printForward(n / 10);           
        System.out.print(n % 10);       
        System.out.print(' ');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Номер задачі (1-6):");
        int task = sc.nextInt();

        switch (task) {
            case 1:
                printUpTo(sc.nextInt());
                break;
            case 2:
                int a = sc.nextInt();
                int b = sc.nextInt();
                printFromTo(a, b);
                break;
            case 3:
                if (isPowerOfTwo(sc.nextInt())) {
                    System.out.print("YES");
                } else {
                    System.out.print("NO");
                }
                break;
            case 4:
                System.out.print(digitSum(sc.nextInt()));
                break;
            case 5:
                printReverse(sc.nextInt());
                break;
            case 6:
                printForward(sc.nextInt());
                break;
            default:
                System.out.print("Немає такої задачі");
        }
        System.out.println();
    }
}
