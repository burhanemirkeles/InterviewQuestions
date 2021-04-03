import java.util.Arrays;

public class Sorting_001_InsertionSortAlgorithm {
    /*
    -----Insertion Sort Overview-----
    Insertion sort is a stable, in-place sorting algorithm that builds the final sorted array one item at a time.
    It is not the very best in terms of performance but more efficient traditionally than most other simple O(n^2)
    algorithms such as selection sort or bubble sort. Insertion sort is also used in Hybrid sort,
    which combines different sorting algorithms to improve performance.

    It is also a well known online algorithm since it can sor a list as it receives it. In all other algorithms, we
    need all elements to be provided to the sorting algorithm before applying it. But an insertion sort allows us
    to start with a partial set of elements, sorts it(called a partially sorted set). If we want, we can insert
    more elements(these are the new set of elements that were not in memory when the sorting started) and sorts them.
    In the real world, data to be sorted is usually not static, rather dynamic. If even one additional elements is
    inserted during the sorting process, other algorithms don't respond easily. But only insertion sort algorithm
    is not interrupted and can respond well with the additional element.

    How It Works?

    The idea is to divide array into two subsets- sorted subset and unsorted subset. Initially, a sorted subset consists
    of only one first element at index 0. Then for each iteration, insertion sort removes the next element from the
    unsorted subset, finds the location it belongs within the sorted subset and inserts it there. It repeats until no
    input elements remain.

    For example:
        12, 11, 13, 5, 6
        Let us loop for i = 1 (second element of the array) to 4 (last element of the array)
            i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
            11, 12, 13, 5, 6
            i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
            11, 12, 13, 5, 6
            i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
            5, 11, 12, 13, 6
            i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
            5, 6, 11, 12, 13



    Implementation
    Insertion Sorting Algorithm can implemented in two ways which iterative and recursive ways.

    Insertion Sort Performance
    The worst-case time complexity of insertion sort is O(n^2), where n is the size of the input. The worst case happens
    when the array is reverse sorted. The best-case time complexity of insertion sort is O(n) when happens the array
    is already sorted.
    The auxilary space used by the iterative version is O(1) and O(n) by the recursive versions for the call stack.

     */

    // Function to perform insertion sort on `arr[]`
    public static void insertionSortIterative(int[] arr)
    {
        // Start from the second element
        // (the element at index 0 is already sorted)
        for (int i = 1; i < arr.length; i++)
        {
            int value = arr[i];
            int j = i;

            // find index `j` within the sorted subset `arr[0…i-1]`
            // where element `arr[i]` belongs
            while (j > 0 && arr[j - 1] > value)
            {
                arr[j] = arr[j - 1];
                j--;
            }

            // note that the subarray `arr[j…i-1]` is shifted to
            // the right by one position, i.e., `arr[j+1…i]`

            arr[j] = value;
        }
    }
    // Recursive function to perform insertion sort on subarray `arr[i…n]`
    public static void insertionSortRecursively(int[] arr, int i, int n)
    {
        int value = arr[i];
        int j = i;

        // find index `j` within the sorted subset `arr[0…i-1]`
        // where element `arr[i]` belongs
        while (j > 0 && arr[j - 1] > value)
        {
            arr[j] = arr[j - 1];
            j--;
        }

        arr[j] = value;

        // note that the subarray `arr[j…i-1]` is shifted to
        // the right by one position, i.e., `arr[j+1…i]`

        if (i + 1 <= n) {
            insertionSortRecursively(arr, i + 1, n);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 8, 5, 4, 1, 9, -2 };

        insertionSortIterative(arr);
        // insertionSortRecursively(arr, 1, arr.length -1);
        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }

}
