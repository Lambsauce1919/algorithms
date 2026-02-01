package sorting;

import java.util.Arrays;

public class mergeSort {

    public static void main(String[] args) {
        int[] sm = {87, 23, 9, 54, 12, 39, 1, 4, 10, 2}; // Example array
        System.out.println("Original: " + Arrays.toString(sm));
        
        // The process starts here
        int[] sorted = amSort(sm);
        
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }

    // THE SPLITTER (Recursive Function)
    static int[] amSort(int[] ar) {
        // Base Case: If the array has 1 or 0 elements, it is already sorted
        if (ar.length <= 1) {
            return ar;
        }

        // 1. DIVIDE: Find the middle and split the array
        int mid = ar.length / 2;
        int[] left = Arrays.copyOfRange(ar, 0, mid);
        int[] right = Arrays.copyOfRange(ar, mid, ar.length);

        // 2. RECURSE: Call amSort on the halves
        // This keeps splitting until we hit the base case
        left = amSort(left);
        right = amSort(right);

        // 3. CONQUER: Merge the two sorted halves back together
        return merge(left, right);
    }

    // THE REFEREE (Merge Logic)
    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0; // Pointer for left array
        int j = 0; // Pointer for right array
        int k = 0; // Pointer for result array

        // Compare elements and zip them up in order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Clean up: Dump remaining elements from the left side
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Clean up: Dump remaining elements from the right side
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}
