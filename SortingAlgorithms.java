public class SortingAlgorithms {
    /**
     * Algorithm: Insertion Sort
     * divides list into two sections - sorted section and unsorted
     * removes item from unsorted section and inserts into correct position
     * in sorted section
     */
    public static void insertionSort(int [] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i]; // current iteration value (starts at position 1)
            int j = i - 1; // value before v (starts at position 0)
            while (j >= 0 && arr[j] > v) { // if value before is greater than one in front - enter loop (j > v)
                arr[j + 1] = arr[j]; // value in-front copied to value before (temporarily deletes value at i)
                j = j - 1; // keep moving back in sorted section until while loop breaks
            }
            arr[j + 1] = v; // re-add value into correct place
        }
    }

    /**
     * Algorithm: Selection Sort
     * Find minimum item each iteration and add to current iteration index
     */
    public static void selectionSort(int [] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            int minIndex = i; // index where un-sorted section begins
            for (int j = i + 1; j < arr.length; j++) { // j begins one position in-front of min index
                if (arr[j] < arr[minIndex]) { // if value in-front is smaller than value behind
                    minIndex = j; // store position of smaller value
                }
            }
            int temp = arr[minIndex]; // store smaller value
            arr[minIndex] = arr[i]; // set value in front to bigger
            arr[i] = temp; // set prev value to smaller
        }
    }

    /**
     * Algorithm: Bubble Sort
     * Systematically exchanges pairs of items in array until none remain
     */
    public static void bubbleSort(int [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) { // if item in front of bubble is smaller than one at start
                    int temp = arr[j]; // store smaller value
                    arr[j] = arr[j + 1]; // swap values in bubble
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Algorithm: Merge Sort
     * sort recursively breaks down array into two sorted halves
     * merge then merges split halves
     */
    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1; // temp array sizes
        int n2 = r - m;

        int L[] = new int [n1]; //initialize temp arrays
        int R[] = new int [n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i]; // copy left side contents into temp
        for (int j=0; j < n2; ++j)
            R[j] = arr[m + 1 + j]; // copy right side contents into temp

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) { // while counters are less than temp array sizes
            if (L[i] <= R[j]) { // if left variable is less than right variable
                arr[k] = L[i]; // copy variable into array
                i++;
            }
            else {
                arr[k] = R[j]; // if left variable is not smaller copy right variable
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            sort(arr, l, m); // recursively break down left half of array
            sort(arr , m+1, r); // recursively break down right
            merge(arr, l, m, r); // merge split halves
            // sort will fully break down and merge left side before beginning on right
        }
    }

    /**
     * Algorithm: Quick Sort
     * first calls partition to split array using a pivot and places all elements
     * smaller behind pivot and all elements larger in-front
     * then quickSort is called to recursively sort behind and in-front of partition
     */
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // find pivot (example uses last value in array)
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high); // find a partition - place smaller elements to left and larger to right
            quickSort(arr, low, partition-1); // recursively partition and place values around it on low side
            quickSort(arr, partition+1, high); // recursively partition and place values around it on high side
        }
    }

    /**
     * Algorithm: Heap Sort
     */
    public static void heapSort(int arr[]) {
        int length = arr.length;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heap(arr, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heap on the reduced heap
            heap(arr, i, 0);
        }
    }

    public static void heap(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2 * i + 1
        int r = 2 * i + 2; // right = 2 * i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heap the affected sub-tree
            heap(arr, n, largest);
        }
    }
}
