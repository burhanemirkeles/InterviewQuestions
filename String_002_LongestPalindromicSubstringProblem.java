public class String_002_LongestPalindromicSubstringProblem {
    /*
    Given a string, find the maximum length contiguous substring of it that is also a palindrome. For example, the
    longest palindromic substring of "bananas" is "anana".

    The problem differs from the problem of finding the longest palindromic subsequence. Unlike subsequences, substrings
    in a string abracadabra with a length greater than three. Still, there are two palindromic substrings with length
    tree, namely aca and ada. If multiple longest palindromic substrings exists, return any one of them.

    The dynamic programming solution for this problem takes O(n^2) time and O(n^2) space. This post will discuss another
    approach to solve this problem that doesn't require any extra space.

    The idea is simple and effective - for each character in the given string, consider it the midpoint of a palindrome
    and expand in both directions to find the maximum length palindrome. For an even length palindrome, consider every
    adjacent pair of characters as the midpoint.
     */
    // Expand in both directions of `low` and `high` to find
    // maximum length palindrome
    public static String expand(String str, int low, int high)
    {
        int len = str.length();

        // expand in both directions
        while (low >= 0 && high < len &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
        }

        // return palindromic substring
        return str.substring(low + 1, high);
    }

    // Function to find the longest palindromic substring in `O(n²)` time
    // and `O(1)` space
    public static String findLongestPalindromicSubstring(String str, int len)
    {
        // `max_str` stores the maximum length palindromic substring found so far

        String max_str = "", curr_str;

        // `max_length` stores the maximum length of palindromic substring found so far

        int max_length = 0, curr_length;

        // consider every character of the given string as a midpoint and expand in both directions to find maximum length palindrome

        for (int i = 0; i < len; i++)
        {
            // find the longest odd length palindrome with `str[i]` as a midpoint

            curr_str = expand(str, i, i);
            curr_length = curr_str.length();


            // update maximum length palindromic substring if odd length palindrome has a greater length

            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }

            // Find the longest even length palindrome with str[i] and
            // str[i+1] as midpoints. Note that an even length palindrome
            // has two midpoints.

            curr_str = expand(str, i, i + 1);
            curr_length = curr_str.length();

            // update maximum length palindromic substring if even length palindrome has a greater length

            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }
        }

        return max_str;
    }

    public static void main(String[] args)
    {
        String str = "ABDCBCDBDCBBC";

        System.out.println("The longest palindromic substring of " + str + " is "
                + findLongestPalindromicSubstring(str, str.length() - 1));
    }

}
