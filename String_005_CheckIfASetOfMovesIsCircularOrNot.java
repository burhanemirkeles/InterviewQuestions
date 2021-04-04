public class String_005_CheckIfASetOfMovesIsCircularOrNot {
    /*
    Check if a given set of moves is circular or not. A move is circular if its starting and ending coordinates are the
    same. The moves can contain instructions to move one unit in the same direction (M), to change direction
    to the left of current direction (L), and to change direction to the right of current direction (R).

    For example,
        Set of moves MRMRMRM is circular
        Set of moves MRMLMRMRMMRMM is circular

    The idea is simple- start with (0,0) as the starting coordinates and North as the starting direction and linearly
    read each instruction from the input string. For every instruction, update the coordinates of the current location
    (x,y) if the instruction is MOVE or update the current direction if the instruction is GO LEFT or GO RIGHT. The move
    is circular if we are back to the starting coordinates (0,9) in the end.
     */
    // Function to check if the given set of moves is circular or not
    public static boolean checkCircularMove(String str)
    {
        // start from coordinates `(0, 0)`
        int x = 0, y = 0;

        // assume that the initial direction is `North`
        char dir = 'N';

        // read each instruction from the input string
        for (char ch: str.toCharArray())
        {
            switch (ch)
            {
                // move one unit in the same direction
                case 'M':
                    if (dir == 'N') {
                        y++;
                    } else if (dir == 'S') {
                        y--;
                    } else if (dir == 'E') {
                        x++;
                    } else if (dir == 'W') {
                        x--;
                    } break;

                // change direction to the left of the current direction
                case 'L':
                    if (dir == 'N') {
                        dir = 'W';
                    } else if (dir == 'W') {
                        dir = 'S';
                    } else if (dir == 'S') {
                        dir = 'E';
                    } else if (dir == 'E') {
                        dir = 'N';
                    } break;

                // change direction to the right of the current direction
                case 'R':
                    if (dir == 'N') {
                        dir = 'E';
                    } else if (dir == 'E') {
                        dir = 'S';
                    } else if (dir == 'S') {
                        dir = 'W';
                    } else if (dir == 'W') {
                        dir = 'N';
                    }
            }
        }

        // if we are back to starting coordinates `(0, 0)`,
        // the move is circular
        return (x == 0 && y == 0);
    }

    public static void main(String[] args)
    {
        String str = "MMRMMRMMRMM";

        if (checkCircularMove(str)) {
            System.out.println("Circular move");
        }
        else {
            System.out.println("Non-circular move");
        }
    }
}
