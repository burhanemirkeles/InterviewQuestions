import java.util.Arrays;

public class Backtracking_001_PrintAllPossibleSolutionsToNQueensProblem {
    /*
    The N-queens puzzle is the problem of placing N chess queens on an N X N chessboard so that no two queens threaten
    each other. Thus, the solution requires that no two queens share same row, column, or diagonal.

    For example,for a standard 8 x 8 chessboard, below is one such configuration:
      Q  –  –  –  –  –  –  –
      –  –  –  –  Q  –  –  –
      –  –  –  –  –  –  –  Q
      –  –  –  –  –  Q  –  –
      –  –  Q  –  –  –  –  –
      –  –  –  –  –  –  Q  –
      –  Q  –  –  –  –  –  –
      –  –  –  Q  –  –  –  –

      Note that the solution exists for all natural numbers, except for n = 2 and n = 3

      We can solve this problem with the help of backtracking. The idea is to start from the first row and place Queen
      in each square of the first row and recursively explore the remaining rows to check if they lead to
      the solution or not. If the current configuration doesn't result in a solution, backtrack. Before exploring any
      square, ignore the square if two queens threaten each other.

      The time complexity of the backtracking solution is exponential.
     */
    // `N × N` chessboard
    public static final int N = 8;

    // Function to check if two queens threaten each other or not
    private static boolean isSafe(char mat[][], int r, int c)
    {
        // return false if two queens share the same column
        for (int i = 0; i < r; i++)
        {
            if (mat[i][c] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `` diagonal
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `/` diagonal
        for (int i = r, j = c; i >= 0 && j < N; i--, j++)
        {
            if (mat[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static void printSolution(char mat[][])
    {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(mat[i]).replaceAll(",", ""));
        }
        System.out.println();
    }

    private static void nQueen(char mat[][], int r)
    {
        // if `N` queens are placed successfully, print the solution
        if (r == N)
        {
            printSolution(mat);
            return;
        }

        // place queen at every square in the current row `r`
        // and recur for each valid movement
        for (int i = 0; i < N; i++)
        {
            // if no two queens threaten each other
            if (isSafe(mat, r, i))
            {
                // place queen on the current square
                mat[r][i] = 'Q';

                // recur for the next row
                nQueen(mat, r + 1);

                // backtrack and remove the queen from the current square
                mat[r][i] = '–';
            }
        }
    }

    public static void main(String[] args)
    {
        // `mat[][]` keeps track of the position of queens in
        // the current configuration
        char[][] mat = new char[N][N];

        // initialize `mat[][]` by `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(mat[i], '–');
        }

        nQueen(mat, 0);
    }
}
