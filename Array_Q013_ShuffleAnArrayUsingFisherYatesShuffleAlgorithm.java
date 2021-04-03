import java.util.Arrays;
import java.util.Random;

public class Array_Q13_ShuffleAnArrayUsingFisherYatesShuffleAlgorithm {
    /*
    Fisher-Yates shuffle is an algorithm to generate random permutations.
    It takes time proportional the total number of items being shuffled and shuffles them in place.
    The algorithm swaps the element at each iteration at random among all remaining unvisited indices,
    including the element itself.

    Here's the complete algorithm:

    -To shuffle an array 'a' of 'n' elements:
        for i from n-1 down to 1 do
            j = random integer such that 0 <= j <= i
            exchange a[j] and a[i]
     */
    // Utility function to swap elements `A[i]` and `A[j]` in the array
    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Function to shuffle an array `A[]`
    public static void shuffle(int[] A)
    {
        // read array from the highest index to lowest
        for (int i = A.length - 1; i >= 1; i--)
        {
            Random rand = new Random();

            // generate a random number `j` such that `0 <= j <= i`
            int j = rand.nextInt(i + 1);

            // swap the current element with the randomly generated index
            swap(A, i, j);
        }
    }

    public static void main (String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6 };

        shuffle(A);

        // print the shuffled array
        System.out.println(Arrays.toString(A));
    }
}
