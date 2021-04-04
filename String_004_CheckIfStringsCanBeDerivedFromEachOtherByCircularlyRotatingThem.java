public class String_004_CheckIfStringsCanBeDerivedFromEachOtherByCircularlyRotatingThem {
    /*
    Check if a given string can be derived from another string by circularly rotating it. The rotation can be in a
    clockwise or anti-clockwise rotation.

    For example,

    Input:
    X = ABCD
    Y = DABC

    Output: Yes
    Y can be derived from X by right-rotating string X by 1 unit

    For two given strings X and Y, a simple solution would be to check if the string Y is a substring of the string XX
    or not. If yes, they can be derived from each other. For example, consider string X = ABCD and Y = DABC.

    XX = ABCD + ABCD = ABCDABCD

    The string Y is clearly a substring of the string ABCDABCD.

    The implementation can be seen here. This solution seems efficient, but uses O(n) extra space.
     */
    // Function to check if `X` can be derived from `Y` by rotating it
    public static boolean check(String X, String Y)
    {
        int m;

        // if string lengths are different, they can't be derived from each other
        if ((m = X.length()) != Y.length()) {
            return false;
        }

        // Invariant: At the i'th iteration of this loop, the string `X` will be rotated by `i` units
        for (int i = 0; i < m; i++)
        {
            // left rotate string `X` by 1 unit
            X = X.substring(1) + X.charAt(0);

            // return true if `X` becomes equal to `Y`
            if (X.compareTo(Y) == 0) {
                return true;
            }
        }

        // return false if no rotation is matched
        return false;
    }

    public static void main(String[] args)
    {
        String X = "ABCD";
        String Y = "DABC";

        if (check(X, Y)) {
            System.out.println("Given strings can be derived from each other");
        }
        else {
            System.out.println("Given strings cannot be derived from each other");
        }
    }
}
