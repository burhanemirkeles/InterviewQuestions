import java.util.Random;

public class String_006_ConvertGivenNumberIntoCorrespondingExcelColumnName {
    /*
    MS Excel columns have a pattern like A, B, C, …, Z, AA, AB, AC, …., AZ, BA, BB, … ZZ, AAA, AAB ….. etc.
    In other words, column 1 is named as “A”, column 2 as “B”, column 27 as “AA”. Given a column number,
    find its corresponding Excel column name.

        Input          Output
         26             Z
         51             AY
         52             AZ
         80             CB
         676            YZ
         702            ZZ
         705            AAC

     */
    // Function to convert a given number to an Excel column
    public static String getColumnName(int n)
    {
        // initialize output string as empty
        StringBuilder result = new StringBuilder();

        while (n > 0)
        {
            // find the index of the next letter and concatenate the letter
            // to the solution

            // here index 0 corresponds to `A`, and 25 corresponds to `Z`
            int index = (n - 1) % 26;
            result.append((char)(index + 'A'));
            n = (n - 1) / 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args)
    {
        // generate column names for 10 random numbers between 1–1000
        for (int i = 1; i <= 10; i++)
        {
            int r = new Random().nextInt(1000) + 1;
            System.out.println(r + " — " + getColumnName(r));
        }
    }
}
