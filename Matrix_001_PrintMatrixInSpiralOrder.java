public class Matrix_001_PrintMatrixInSpiralOrder {
    /*
    Given an M X N matrix, print the matrix in spiral order

    For example:

    Input:
    [  1   2   3   4  5 ]
    [ 16  17  18  19  6 ]
    [ 15  24  25  20  7 ]
    [ 14  23  22  21  8 ]
    [ 13  12  11  10  9 ]

    Output:
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

    The idea is to read elements from the given matrix and print the matrix in spiral order. Four loops are used to
    maintain the spiral order, each for the top, right, bottom, left corner of the matrix.

    There is two ways to implement which are iterative and recursive.

    The time complexity of the proposed solution is O(M X N) for an M x N matrix. The auxiliary space required by the
    program is O(M X N) for recursion (call stack).
     */
    private static void printSpiralOrderIterative(int[][] mat)
    {
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;

        while (true)
        {
            if (left > right) {
                break;
            }

            // print top row
            for (int i = left; i <= right; i++) {
                System.out.print(mat[top][i] + " ");
            }
            top++;

            if (top > bottom) {
                break;
            }

            // print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(mat[i][right] + " ");
            }
            right--;

            if (left > right) {
                break;
            }

            // print bottom row
            for (int i = right; i >= left; i--) {
                System.out.print(mat[bottom][i] + " ");
            }
            bottom--;

            if (top > bottom) {
                break;
            }

            // print left column
            for (int i = bottom; i >= top; i--) {
                System.out.print(mat[i][left] + " ");
            }
            left++;
        }
    }
    private static void printSpiralRecursive(int mat[][], int top, int bottom,
                                    int left, int right)
    {
        if (left > right) {
            return;
        }
        // print top row
        for (int i = left; i <= right; i++) {
            System.out.print(mat[top][i] + " ");
        }
        top++;

        if (top > bottom) {
            return;
        }
        // print right column
        for (int i = top; i <= bottom; i++) {
            System.out.print(mat[i][right] + " ");
        }
        right--;

        if (left > right) {
            return;
        }
        // print bottom row
        for (int i = right; i >= left; i--) {
            System.out.print(mat[bottom][i] + " ");
        }
        bottom--;

        if (top > bottom) {
            return;
        }
        // print left column
        for (int i = bottom; i >= top; i--) {
            System.out.print(mat[i][left] + " ");
        }
        left++;

        printSpiralRecursive(mat, top, bottom, left, right);
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 1, 2, 3, 4, 5},
                        {16, 17, 18, 19, 6},
                        {15, 24, 25, 20, 7},
                        {14, 23, 22, 21, 8},
                        {13, 12, 11, 10, 9}
                };

        printSpiralOrderIterative(mat);
        //printSpiralRecursive(mat);
    }
}


