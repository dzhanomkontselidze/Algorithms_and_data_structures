
public class Main {

    public static void main(String[] args) {

        // Bubble sort 
        System.out.println("===== BUBBLE SORT =====");

        int[] bubbleArray = ArraySorter.generateArray(10, 1, 100);

        System.out.println("Початковий масив:");
        ArraySorter.printArray(bubbleArray);

        int[] bubbleAsc = ArraySorter.copyArray(bubbleArray);
        ArraySorter.bubbleSort(bubbleAsc, true);
        System.out.println("За зростанням:");
        ArraySorter.printArray(bubbleAsc);

        int[] bubbleDesc = ArraySorter.copyArray(bubbleArray);
        ArraySorter.bubbleSort(bubbleDesc, false);
        System.out.println("За спаданням:");
        ArraySorter.printArray(bubbleDesc);

        System.out.println();

        //Insertion sort 
        System.out.println("===== INSERTION SORT =====");

        int[] insertionArray = ArraySorter.generateArray(10, 1, 100);

        System.out.println("Початковий масив:");
        ArraySorter.printArray(insertionArray);

        int[] insertionAsc = ArraySorter.copyArray(insertionArray);
        ArraySorter.insertionSort(insertionAsc, true);
        System.out.println("За зростанням:");
        ArraySorter.printArray(insertionAsc);

        int[] insertionDesc = ArraySorter.copyArray(insertionArray);
        ArraySorter.insertionSort(insertionDesc, false);
        System.out.println("За спаданням:");
        ArraySorter.printArray(insertionDesc);

        System.out.println();

        //Selection sort
        System.out.println("===== SELECTION SORT =====");

        int[] selectionArray = ArraySorter.generateArray(10, 1, 100);

        System.out.println("Початковий масив:");
        ArraySorter.printArray(selectionArray);

        int[] selectionAsc = ArraySorter.copyArray(selectionArray);
        ArraySorter.selectionSort(selectionAsc, true);
        System.out.println("За зростанням:");
        ArraySorter.printArray(selectionAsc);

        int[] selectionDesc = ArraySorter.copyArray(selectionArray);
        ArraySorter.selectionSort(selectionDesc, false);
        System.out.println("За спаданням:");
        ArraySorter.printArray(selectionDesc);
    }
}
