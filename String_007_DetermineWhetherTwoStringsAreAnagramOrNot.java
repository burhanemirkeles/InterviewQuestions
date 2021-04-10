import java.util.HashMap;
import java.util.Map;

public class String_007_DetermineWhetherTwoStringsAreAnagramOrNot {
    /*
    Any word that exactly reproduces the letters in another order is an anagram. In other words, X an Y are anagrams
    if by rearranging the letters of X, we can get Y using all original letters of X exactly once.

     */
    // Function to check if `X` and `Y` are anagrams or not
    public static boolean isAnagram(String X, String Y)
    {
        // if X's length is not the same as Y's, they can't be an anagram
        if (X.length() != Y.length()) {
            return false;
        }

        // create an empty map
        Map<Character, Integer> freq = new HashMap<>();

        // maintain a count of each character of `X` on the map
        for (char c: X.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // do for each character `y` of `Y`
        for (char c: Y.toCharArray())
        {
            // if `y` is not found in the map, i.e., either `y` is not present
            // in string `X` or has more occurrences in string `Y`
            if (!freq.containsKey(c)) {
                return false;
            }

            // decrease the frequency of `y` on the map
            freq.put(c, freq.get(c) - 1);

            // if its frequency becomes 0, erase it from the map
            if (freq.get(c) == 0) {
                freq.remove(c);
            }
        }

        // return true if the map becomes empty
        return freq.isEmpty();
    }

    public static void main(String[] args)
    {
        String X = "tommarvoloriddle";        // Tom Marvolo Riddle
        String Y = "iamlordvoldemort";        // I am Lord Voldemort

        if (isAnagram(X, Y)) {
            System.out.print("Anagram");
        }
        else {
            System.out.print("Not an Anagram");
        }
    }
}
