
import java.util.*;

public class Main {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String [] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        SortingAlgorithms sort = new SortingAlgorithms();
        SearchAlgorithms search = new SearchAlgorithms();

        int[] testArray = new int[10];

        for (int i = 0; i < testArray.length; i++) {
            testArray[i]= random.nextInt(100);
        }

        System.out.println("Unsorted array: ");
        printArray(testArray);

        System.out.println();
        System.out.println("--- Sorting algorithms ---");
        System.out.println("1 - Insertion Sort");
        System.out.println("2 - Selection Sort");
        System.out.println("3 - Bubble Sort");
        System.out.println("4 - Merge Sort");
        System.out.println("5 - Quick Sort");
        System.out.println("6 - Heap Sort");
        System.out.print("Which algorithm would you like to use: ");
        int algorithm = input.nextInt();
        System.out.println();

        if (algorithm == 1) {
            sort.insertionSort(testArray);
            System.out.println("Array sorted using Insertion sort: ");
        } else if (algorithm == 2) {
            sort.selectionSort(testArray);
            System.out.println("Array sorted using Selection sort: ");
        } else if (algorithm == 3) {
            sort.bubbleSort(testArray);
            System.out.println("Array sorted using Bubble sort: ");
        } else if (algorithm == 4) {
            sort.sort(testArray, 0 , (testArray.length - 1));
            System.out.println("Array sorted using Merge sort: ");
        } else if (algorithm == 5) {
            sort.quickSort(testArray, 0 , (testArray.length - 1));
            System.out.println("Array sorted using Quick sort: ");
        } else if (algorithm == 6) {
            sort.heapSort(testArray);
            System.out.println("Array sorted using Heap sort: ");
        }
        printArray(testArray);
        System.out.println();

        System.out.print("Search for an element in array: ");
        int key = input.nextInt();
        int found = search.binarySearch(testArray, key);
        if (found >= 0) {
            System.out.println("Found key at index: " + found + " with value of " + testArray[found]);
        } else {
            System.out.println("Couldn't find that element");
        }

        input.nextLine();

    }
}
