import java.util.ArrayList;
import java.util.List;

public class Array_Q15_FindEquilibriumIndexOfAnArray {
    /*
    For an array A consisting n elements, index i is an equilibrium index if the sum of elements of subarray A[0..i-1]
    is equal to the sum of elements of subarray A[i+1...n-1]. i.e.,

    (A[0] + A[1] + … + A[i-1]) = (A[i+1] + A[i+2] + … + A[n-1]) where 0 < i < n-1

    Similarly, 0 is an equilibrium index if A[1] + A[2] + … + A[n-1] sums to 0 and n-1 is an equilibrium index if
    A[0] + A[1] + … + A[n-2] sums to 0

    To illustrate, consider the array {0, -3, 5, -4, -2, 3, 1, 0}. The equilibrium index is found at index 0,3 and 7.

    !!!!Definition: Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to
    the sum of elements at higher indexes.


     */
    // Function to find the equilibrium index of an array
    public static void equilibriumIndex(int A[])
    {
        // `left[i]` stores the sum of elements of subarray `A[0…i-1]`
        int left[] = new int[A.length];

        left[0] = 0;

        // traverse the array from left to right
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] + A[i - 1];
        }

        // `right` stores the sum of elements of subarray `A[i+1…n)`
        int right = 0;

        // maintain a list of indices
        List<Integer> indices = new ArrayList<>();

        // traverse the array from right to left
        for (int i = A.length - 1; i >= 0; i--)
        {
            /* If the sum of elements of subarray `A[0…i-1]` is equal to
               the sum of elements of the subarray `A[i+1…n)` i.e.
               (A[0] + … + A[i-1]) = (A[i+1] + A[i+2] + … + A[n-1]) */

            if (left[i] == right) {
                indices.add(i);
            }

            // new right is `A[i] + (A[i+1] + A[i+2] + … + A[n-1])`
            right += A[i];
        }

        System.out.println("Equilibrium Index found at " + indices);
    }

    public static void main (String[] args)
    {
        int[] A = { 0, -3, 5, -4, -2, 3, 1, 0 };

        equilibriumIndex(A);
    }
}
