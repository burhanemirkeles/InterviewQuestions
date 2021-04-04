import java.util.Arrays;

public class Matrix_003_ShiftAllMatrixElementsBy1InSpiralOrder {
    /*
    Given an M X N matrix, print the matrix in spiral order

    For example:
    Input:

    [ 1 2 3 4 5 ]
    [ 16 17 18 19 6 ]
    [ 15 24 25 20 7 ]
    [ 14 23 22 21 8 ]
    [ 13 12 11 10 9 ]

    Output:

    [ 25 1 2 3 4 ]
    [ 15 16 17 18 5 ]
    [ 14 23 24 19 6 ]
    [ 13 22 21 20 7 ]
    [ 12 11 10 9 8 ]
    */
    // Shift all matrix elements by 1 in spiral order
    public static void shiftMatrix(int[][] mat)
    {
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;
        int prev = mat[0][0];

        while (true)
        {
            if (left > right) {
                break;
            }

            // change top row
            for (int i = left; i <= right; i++)
            {
                int temp = mat[top][i];
                mat[top][i] = prev;
                prev = temp;
            }

            top++;

            if (top > bottom) {
                break;
            }

            // change right column
            for (int i = top; i <= bottom; i++)
            {
                int temp = mat[i][right];
                mat[i][right] = prev;
                prev = temp;
            }

            right--;

            if (left > right) {
                break;
            }

            // change bottom row
            for (int i = right; i >= left; i--)
            {
                int temp = mat[bottom][i];
                mat[bottom][i] = prev;
                prev = temp;
            }

            bottom--;

            if (top > bottom) {
                break;
            }

            // change left column
            for (int i = bottom; i >= top; i--)
            {
                int temp = mat[i][left];
                mat[i][left] = prev;
                prev = temp;
            }

            left++;
        }

        // the first element of the matrix will be the last element replaced
        mat[0][0] = prev;
    }

    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 1, 2,    3, 4, 5},
                        {16, 17, 18, 19, 6},
                        {15, 24, 25, 20, 7},
                        {14, 23, 22, 21, 8},
                        {13, 12, 11, 10, 9}
                };

        shiftMatrix(mat);

        for (var r: mat) {
            System.out.println(Arrays.toString(r));
        }
    }

}
