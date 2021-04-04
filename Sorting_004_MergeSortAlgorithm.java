import java.util.Arrays;

public class Sorting_004_MergeSortAlgorithm {
    /*
    ------Merge Sort Overview-----
    Merge sort is an efficient sorting algorithm that produces a stable sort, which means that if two elements have the
    same value, they hold the same relative position in the sorted sequence as they did in the input. In other words,
    the relative order of elements with equal values is preserved in the sorted sequence. Merge sort is a comparison
    sort, which means that it can sort any input for which a less-than relation is defined.

    How It Works?

    Merge sort is a Divide and Conquer algorithm. Like all divide-and-conquer algorithms, merge sort divides a large
    array into two smaller subarrays and then recursively sort the subarrays. Basically, two steps are involved in the
    whole process:

        1.Divide the unsorted array into n subarrays, each of size 1
        2.Repeatedly merge subarrays to produce new sorted subarrays until only 1 subarray is left, which would be our
        sorted array.

        pseudocode:
            MergeSort(arr[], l,  r)
            If r > l
                 1. Find the middle point to divide the array into two halves:
                         middle m = l+ (r-l)/2
                 2. Call mergeSort for first half:
                         Call mergeSort(arr, l, m)
                 3. Call mergeSort for second half:
                         Call mergeSort(arr, m+1, r)
                 4. Merge the two halves sorted in step 2 and 3:
                         Call merge(arr, l, m, r)
     */
    // Merge two sorted subarrays `arr[low … mid]` and `arr[mid+1 … high]`
    public static void merge(int[] arr, int[] aux, int low, int mid, int high)
    {
        int k = low, i = low, j = mid + 1;

        // While there are elements in the left and right runs
        while (i <= mid && j <= high)
        {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
            }
        }

        // Copy remaining elements
        while (i <= mid) {
            aux[k++] = arr[i++];
        }

        // No need to copy the second half (since the remaining items
        // are already in their correct position in the auxiliary array)

        // copy back to the original array to reflect sorted order
        for (i = low; i <= high; i++) {
            arr[i] = aux[i];
        }
    }

    // Sort array `arr[low…high]` using auxiliary array `aux`
    public static void mergesort(int[] arr, int[] aux, int low, int high)
    {
        // Base case
        if (high == low) {        // if run size == 1
            return;
        }

        // find midpoint
        int mid = (low + ((high - low) >> 1));

        // recursively split runs into two halves until run size == 1,
        // then merge them and return up the call chain

        mergesort(arr, aux, low, mid);          // split/merge left half
        mergesort(arr, aux, mid + 1, high);     // split/merge right half

        merge(arr, aux, low, mid, high);        // merge the two half runs
    }

    // Function to check if arr is sorted in ascending order or not
    public static boolean isSorted(int[] arr)
    {
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (prev > arr[i])
            {
                System.out.println("MergeSort Fails!!");
                return false;
            }
            prev = arr[i];
        }

        return true;
    }

    // Implementation of merge sort algorithm in Java
    public static void main(String[] args)
    {
        int[] arr = { 12, 3, 18, 24, 0, 5, -2 };
        int[] aux = Arrays.copyOf(arr, arr.length);

        // sort array `arr` using auxiliary array `aux`
        mergesort(arr, aux, 0, arr.length - 1);

        if (isSorted(arr)) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
