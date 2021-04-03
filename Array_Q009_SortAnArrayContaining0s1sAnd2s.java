import java.util.Arrays;

public class Array_Q9_SortAnArrayContaining0s1sAnd2s {
    /*
    This question is known as Dutch National Flag Problem.

    Input: { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 }
    Output:{ 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2 }
     */
    public static void threeWayPartition(int[] A, int end)
    {
        int start = 0, mid = 0;
        int pivot = 1;

        while (mid <= end)
        {
            if (A[mid] < pivot)         // current element is 0
            {
                swap(A, start, mid);
                ++start;
                ++mid;
            }
            else if (A[mid] > pivot)    // current element is 2
            {
                swap(A, mid, end);
                --end;
            }
            else {                      // current element is 1
                ++mid;
            }
        }
    }

    // Utility function to swap elements `A[i]` and `A[j]` in the array
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main (String[] args)
    {
        int[] A = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };

        threeWayPartition(A, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

}
