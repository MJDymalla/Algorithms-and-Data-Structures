public class SearchAlgorithms {
    /**
     * Algorithm: Binary Search
     * Since array is sorted algorithm can split array in half using index and search halves
     */
    public static int binarySearch(int arr[], int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (key == (arr[m])) {
                return m;
            } else if (key < arr[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
