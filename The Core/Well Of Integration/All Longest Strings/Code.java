/*
 Kevin Nguyen - KevinN858@gmail.com
 April 30th, 2017
 
 Problem taken from CodeFights.com - Well of Integration - All Longest Strings
 Given an array of strings, return another array containing all of its longest strings.
 Example:
 For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be
 allLongestStrings(inputArray) = ["aba", "vcd", "aba"].
 Input/Output:
 [time limit] 3000ms (java) [input] array.string inputArray
 /A non-empty array.
 Guaranteed constraints:
 1 ≤ inputArray.length ≤ 10,    1 ≤ inputArray[i].length ≤ 10.
 [output] array.string: Array of the longest strings, stored in the same order as in the inputArray.
*/

public class Code
{
    //Go through String array, update longest length when necesary.
    //When a new longest is encountered, reset the return array.
    //Truncate array to only elements of longest length.
    static String[] allLongestStrings(String[] inputArray)
    {
        //create a new String array with length inputArray.length(max length possible)
        
        
    }
    
    //function that returns contents of an String array as a String
    //that also appends a newline at the end.
    static String arrayToString(String[] inputArray)
    {
        String array = " "+inputArray[0];
        for(int index=1; index<inputArray.length; index++)
        {
            array += ", " + inputArray[index];
        }
        array += "\n";
        return array;
    }
    
	public static void main(String[] args)
	{
        String[] inputArray = {"aba", "aa", "ad", "vcd", "aba"};
        System.out.println("inputArray:"+arrayToString(inputArray)+"allLongestStrings:"+arrayToString(allLongestStrings(inputArray)));
	}
}
