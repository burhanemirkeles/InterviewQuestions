import java.util.Arrays;

public class Matrix_002_CreateASpiralMatrixFromAGivenArray {
    /*
    Given an M X N matrix, print the matrix in spiral order

    For example:

    Input:
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

    Output:
    [  1   2   3   4  5 ]
    [ 16  17  18  19  6 ]
    [ 15  24  25  20  7 ]
    [ 14  23  22  21  8 ]
    [ 13  12  11  10  9 ]
     */
    private static final int M = 5;
    private static final int N = 5;

    // Create a spiral matrix from the given array
    private static void printSpiralOrder(int[] arr, int[][] mat)
    {
        int top = 0, bottom = M - 1;
        int left = 0, right = N - 1;

        int index = 0;

        while (true)
        {
            if (left > right) {
                break;
            }

            // print top row
            for (int i = left; i <= right; i++) {
                mat[top][i] = arr[index++];
            }
            top++;

            if (top > bottom) {
                break;
            }

            // print right column
            for (int i = top; i <= bottom; i++) {
                mat[i][right] = arr[index++];
            }
            right--;

            if (left > right) {
                break;
            }

            // print bottom row
            for (int i = right; i >= left; i--) {
                mat[bottom][i] = arr[index++];
            }
            bottom--;

            if (top > bottom) {
                break;
            }

            // print left column
            for (int i = bottom; i >= top; i--) {
                mat[i][left] = arr[index++];
            }
            left++;
        }
    }

    public static void main(String[] args)
    {
        // an array of size `M×N`
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };

        int[][] mat = new int[M][N];
        printSpiralOrder(arr, mat);

        for (var r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }

}
