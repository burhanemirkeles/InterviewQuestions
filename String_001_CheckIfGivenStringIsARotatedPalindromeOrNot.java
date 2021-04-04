public class String_001_CheckIfGivenStringIsARotatedPalindromeOrNot {
    /*
    Given a string, check if it is a rotated palindrome or not.

    For example,

    CBAABCD is a rotated palindrome as it is a rotation of palindrome ABCDDCBA
    BAABCC is a rotated palindrome as it is a rotation of palindrome ABCCBA
     */
// Recursive function to check if `str[low…high]` is a palindrome or not
    public static boolean isPalindrome(String str, int low, int high)
    {
        return (low >= high) || (str.charAt(low) == str.charAt(high) &&
                isPalindrome(str, low + 1, high - 1));
    }

    // Function to check if a given string is a rotated palindrome or not
    public static boolean isRotatedPalindrome(String str)
    {
        // length of the given string
        int n = str.length();

        // check for all rotations of the given string if it
        // is palindrome or not
        for (int i = 0; i < n; i++)
        {
            // in-place rotate the string by 1 unit
            str = str.substring(1) + str.charAt(0);

            // return true if the rotation is a palindrome
            if (isPalindrome(str, 0, n - 1)) {
                return true;
            }
        }

        // return false if no rotation is a palindrome
        return false;
    }

    public static void main(String[] args)
    {
        // palindromic string
        String str = "ABCDCBA";

        // rotate it by 2 units
        str = str.substring(2) + str.substring(0, 2);

        if (isRotatedPalindrome(str)) {
            System.out.println("The string is a rotated palindrome");
        }
        else {
            System.out.println("The string is not a rotated palindrome");
        }
    }
}
