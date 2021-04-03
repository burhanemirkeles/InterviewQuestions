import java.util.HashMap;
import java.util.Map;

public class Array_Q17_FindMajorityElementAsBoyerMooreMajorityVoteAlgorithm {
    /*
    Given an integer array containing duplicates, return the majority element if present.A majority element appears more
    than n/2 times, where n is the array size.

    For example, the majority element is 2 in array {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}

    There are 3 ways to solve this problem.
        1.Brute-Force Solution
            A naive solution is to count each element's frequency in the first half of the array to check if it is the
            majority element. The time complexity of this solution O(n^2), where n is size of array.
        2.Linear-time Solution
            We can use hashing to solve this problem in linear time. The idea is to store each element's frequency in a
            map and return if its frequency becomes more than n/2. If no such element is present, then the majority
            element doesn't exist in the array, and return -1.
            The time complexity of this solution O(n) and requires O(n) extra space.
        3.Boyer-Moore Majority Vote Algorithm
            pseudocode:
                 Initialize an element m and a counter i = 0
                 for each element x of the input sequence:
                     if i = 0, then
                         assign m = x and i = 1
                       else
                         if m = x, then assign i = i + 1
                       else
                         assign i = i – 1
                     return m

             The algorithm processes each element of the sequence, one at a time. When processing an element x,
                1.If the counter is 0, set the current candidate to x, and set the counter to 1.
                2.If the counter is non-zero, increment or decrement it according to whether x is a current candidate.

             At the end of this process, if the sequence has majority, it will be the element stored by the algorithm.
             If there is no majority element the algorithm will not detect that that fact
             and may output the wrong element. In other words, the Boyer-Moore majority vote algorithm produces correct
             results only when the majority element is present in the input.
     */

    int findMajorityElementNaiveBruteForce(int A[], int n)
    {
        // check whether `A[i]` is a majority element or not
        for (int i = 0; i <= n/2; i++)
        {
            int count = 1;
            for (int j = i + 1; j < n; j++)
            {
                if (A[j] == A[i]) {
                    count++;
                }
            }

            if (count > n/2) {
                return A[i];
            }
        }

        return -1;
    }
    // Function to find the majority element present in a given array
    public static int findMajorityElementHashing(int[] A)
    {
        // create an empty `HashMap`
        Map<Integer, Integer> map = new HashMap<>();

        // store each element's frequency in a map
        for (int i: A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // return the element if its count is more than `n/2`
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if (entry.getValue() > A.length/2) {
                return entry.getKey();
            }
        }

        // no majority element is present
        return -1;
    }

    public static int findMajorityElementBoyerMooreAlgorithm(int[] A)
    {
        // `m` stores the majority element (if present)
        int m = -1;

        // initialize counter `i` with 0
        int i = 0;

        // do for each element `A[j]` in the array
        for (int j = 0; j < A.length; j++)
        {
            // if counter `i` becomes 0
            if (i == 0)
            {
                // set the current candidate to `A[j]`
                m = A[j];

                // reset the counter to 1
                i = 1;
            }

            // otherwise, increment the counter if `A[j]` is a current candidate
            else if (m == A[j]) {
                i++;
            }
            // otherwise, decrement the counter if `A[j]` is a current candidate
            else {
                i--;
            }
        }

        return m;
    }

    public static void main(String[] args) {
        // assumption: valid input (majority element is present)
        int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

        System.out.println("The majority element is " + findMajorityElementBoyerMooreAlgorithm(arr));

    }

}
