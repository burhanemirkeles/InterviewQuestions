import java.util.Arrays;

public class Arrays_Q19_ReplaceEachElementOfArrayWithProductOfEveryOtherElementWithoutUsingDivisionOperator {
    /*
    For example,
    Input:  { 1, 2, 3, 4, 5 }
    Output: { 120, 60, 40, 30, 24 }

    Input:  { 5, 3, 4, 2, 6, 8 }
    Output: { 1152, 1920, 1440, 2880, 960, 720 }
    */
// Function to replace each array element with every other
    // element's product without using the division operator
    public static void findProduct(int[] A)
    {
        int n = A.length;

        // use two auxiliary arrays
        int[] left = new int[n];
        int[] right = new int[n];

        // `left[i]` stores the product of all elements in subarray[0…i-1]
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = A[i - 1] * left[i - 1];
        }

        // `right[i]` stores the product of all elements in subarray[i+1…n-1]
        right[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            right[j] = A[j + 1] * right[j + 1];
        }

        // replace each element with the product of its left and right subarray
        for (int i = 0; i < n; i++) {
            A[i] = left[i] * right[i];
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 5, 3, 4, 2, 6, 8 };

        findProduct(A);

        // print the modified array
        System.out.println(Arrays.toString(A));
    }
}
