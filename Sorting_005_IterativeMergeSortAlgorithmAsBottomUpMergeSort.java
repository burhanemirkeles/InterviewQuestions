import java.util.Arrays;

public class Sorting_005_IterativeMergeSortAlgorithmAsBottomUpMergeSort {
    /*
    In a recursive approach, the problem is broken down into smaller, simple subproblems in a top down manner until the
    solution becomes trivial. We can also implement merge sort iteratively in a bottom-up manner. We start by sorting
    all subarrays of 1 element; then merge results into subarrays of 2 elements, then merge results into subarrays of
    4 elements. Likewise, preform successive merges until the array is completely sorted.

    The worst-case time complexity of iterative merge sort remains the same as the recursive implementation, i.e.,
    O(n.log(n)) for an input containing n items. However, it saves the auxiliary space required by the call stack.
     */

    // Merge two sorted subarrays `A[from…mid]` and `A[mid+1…to]`
    public static void merge(int[] A, int[] temp, int from, int mid, int to)
    {
        int k = from, i = from, j = mid + 1;

        // loop till no elements are left in the left and right runs
        while (i <= mid && j <= to)
        {
            if (A[i] < A[j]) {
                temp[k++] = A[i++];
            }
            else {
                temp[k++] = A[j++];
            }
        }

        // copy remaining elements
        while (i <= mid) {
            temp[k++] = A[i++];
        }

        /* no need to copy the second half (since the remaining items
           are already in their correct position in the temporary array) */

        // copy back to the original array to reflect sorted order
        for (i = from; i <= to; i++) {
            A[i] = temp[i];
        }
    }

    // Iteratively sort subarray `A[low…high]` using a temporary array
    public static void mergesort(int[] A)
    {
        int low = 0;
        int high = A.length - 1;

        // sort array `A[]` using a temporary array `temp`
        int[] temp = Arrays.copyOf(A, A.length);

        // divide the array into blocks of size `m`
        // m = [1, 2, 4, 8, 16…]
        for (int m = 1; m <= high - low; m = 2*m)
        {
            // for m = 1, i = 0, 2, 4, 6, 8 …
            // for m = 2, i = 0, 4, 8, 12 …
            // for m = 4, i = 0, 8, 16 …
            // …
            for (int i = low; i < high; i += 2*m)
            {
                int from = i;
                int mid = i + m - 1;
                int to = Integer.min(i + 2*m - 1, high);

                merge(A, temp, from, mid, to);
            }
        }
    }

    // Iterative implementation of merge sort
    public static void main(String[] args)
    {
        int[] A = { 5, 7, -9, 3, -4, 2, 8 };

        System.out.println("Original array: " + Arrays.toString(A));
        mergesort(A);
        System.out.println("Modified array: " + Arrays.toString(A));
    }
}
