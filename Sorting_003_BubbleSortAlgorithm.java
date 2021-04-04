import java.util.Arrays;

public class Sorting_003_BubbleSortAlgorithm {
    /*
    ------Bubble Sort Overview-----
     Bubble sort is a stable, in-place sorting algorithm named for smaller or larger elements "bubble" to the top of
     the list. Although the algorithm is simple, it is too slow and impractical for most problems even compared to
     insertion sort, and is not recommended for large input.

     The only significant advantage that bubble sort has over most other implementations, even Quicksort, but not
     insertion sort, is the ability to detect if the list is already sorted. When the list is already sorted (best-case)
     bubble sort runs in linear time.

     How It Works?

     Each pass of bubble sort steps through the list to be sorted compares each pair of adjacent items and swaps them if
     they are in the wrong order. At the end of each pass, the next largest element will "Bubble" up to its correct
     position. These passes through the list are repeated until no swaps are needed, which indicates that the list is
     sorted. In worst-case, we might end up making an n-1 pass, where n is the input size.

     Example:

        First Pass:
            ( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
            ( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
            ( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
            ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5),
                                            algorithm does not swap them.

        Second Pass:
            ( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
            ( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
            ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
            ( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
            Now, the array is already sorted, but our algorithm does not know if it is completed.
            The algorithm needs one whole pass without any swap to know it is sorted.

        Third Pass:
            ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
            ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
            ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
            ( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )

       Implementation
       Bubble Sorting Algorithm can implemented in two ways which iterative and recursive ways.
     */
    // Utility function to swap values at two indices in the array
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to perform bubble sort on a given array `arr[]`
    public static void bubbleSortIterative(int[] arr)
    {
        // `n-1` passes where `n` is the array's length
        for (int k = 0; k < arr.length - 1; k++)
        {
            // last `k` items are already sorted, so the inner loop can
            // avoid looking at the last `k` items
            for (int i = 0; i < arr.length - 1 - k; i++)
            {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }

            // the algorithm can be terminated if the inner loop
            // didn't do any swap
        }
    }
    // Recursive function to perform bubble sort on subarray `arr[i…n]`
    public static void bubbleSortRecursive(int[] arr, int n)
    {
        for (int i = 0; i < n - 1; i++)
        {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }

        if (n - 1 > 1) {
            bubbleSortRecursive(arr, n - 1);
        }
    }



    public static void main(String[] args)
    {
        int[] arr = { 3, 5, 8, 4, 1, 9, -2 };

        bubbleSortIterative(arr);
        //bubbleSortRecursive(arr, arr.length);

        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }
}
