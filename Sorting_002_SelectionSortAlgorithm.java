import java.util.Arrays;

public class Sorting_002_SelectionSortAlgorithm {
    /*
    ------Selection Sort Overview-----
    Selection sort is an unstable, in-place sorting algorithm known for its simplicity. It has performance advantages
    over more complicated algorithms in certain situations, particularly where the auxiliary memory is limited. It can
    be implemented as a stable sort and requires O(n^2) time to sort n items, making it inefficient to use on large
    lists. Among simple average-case O(n^2) algorithms, selection sort almost always outperforms bubble sort and
    generally preforms worse than the insertion sort.

    The biggest advantage of using a selection sort is that it does a maximum of n swaps(memory write). The insertion
    sort, on the other hand, does O(n^2) number of writes. This can be critical if memory-write operation,such as flash
    memory, where every write lessens the memory's lifespan.

    How It Works?

    The idea is to divide the array into two subsets- sorted subset and unsorted subset. Initially, the sorted subset is
    empty, and the unsorted subset is the entire input list. The algorithm proceeds by finding the smallest(or largest,
    depending on sorting order) element in the unsorted subset, swapping it with the leftmost unsorted element (putting
    in sorted order), and moving the subset boundaries one element to the right.

    For example:
        arr[] = 64 25 12 22 11
            // Find the minimum element in arr[0...4] and place it at beginning
            11 25 12 22 64

            // Find the minimum element in arr[1...4] and place it at beginning of arr[1...4]
            11 12 25 22 64

            // Find the minimum element in arr[2...4] and place it at beginning of arr[2...4]
            11 12 22 25 64

            // Find the minimum element in arr[3...4] and place it at beginning of arr[3...4]
            11 12 22 25 64


    Implementation
    Selection Sorting Algorithm can implemented in two ways which iterative and recursive ways.

    Selection Sort Performance


     */
    // Utility function to swap values at two indices in the array
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to perform selection sort on `arr[]`
    public static void selectionSortIterative(int[] arr)
    {
        // run `n-1` times, where `n` is array length
        for (int i = 0; i < arr.length - 1; i++)
        {
            // find the minimum element in the unsorted subarray `[i…n-1]`
            // and swap it with `arr[i]`
            int min = i;

            for (int j = i + 1; j < arr.length; j++)
            {
                // if `arr[j]` is less, then it is the new minimum
                if (arr[j] < arr[min]) {
                    min = j;    // update the index of minimum element
                }
            }

            // swap the minimum element in subarray `arr[i…n-1]` with `arr[i]`
            swap(arr, min, i);
        }
    }
    // Recursive function to perform selection sort on subarray `arr[i…n-1]`
    public static void selectionSortRecursively(int[] arr, int i, int n)
    {
        // find the minimum element in the unsorted subarray `[i…n-1]`
        // and swap it with `arr[i]`
        int min = i;
        for (int j = i + 1; j < n; j++)
        {
            // if `arr[j]` is less, then it is the new minimum
            if (arr[j] < arr[min]) {
                min = j;    // update the index of minimum element
            }
        }

        // swap the minimum element in subarray `arr[i…n-1]` with `arr[i]`
        swap(arr, min, i);

        if (i + 1 < n) {
            selectionSortRecursively(arr, i + 1, n);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 5, 8, 4, 1, 9, -2 };

        selectionSortIterative(arr);
        //selectionSortRecursively(arr, 0 , arr.length);

        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }
}

