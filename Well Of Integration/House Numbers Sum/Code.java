/*
 Kevin Nguyen - KevinN858@gmail.com
 
 Problem taken from CodeFights.com - Well of Integration - House Numbers Sum
 https://codefights.com/arcade/code-arcade/well-of-integration/3QMXNwGfvLMoQwed7
 A boy is walking a long way from school to his home. To make the walk more fun he decides to add up all the numbers of the houses that he passes by during his walk. Unfortunately, not all of the houses have numbers written on them, and on top of that the boy is regularly taking turns to change streets, so the numbers don't appear to him in any particular order.
 At some point during the walk the boy encounters a house with number 0 written on it, which surprises him so much that he stops adding numbers to his total right after seeing that house.
 For the given sequence of houses determine the sum that the boy will get. It is guaranteed that there will always be at least one 0 house on the path.
 Example:
    For inputArray = [5, 1, 2, 3, 0, 1, 5, 0, 2], the output should be
    houseNumbersSum(inputArray) = 11.
    The answer was obtained as 5 + 1 + 2 + 3 = 11.
 Input/Output:
    [time limit] 3000ms (java)
    [input] array.integer inputArray
 Guaranteed constraints:
    5 ≤ inputArray.length ≤ 10, 0 ≤ inputArray[i] ≤ 10.
*/

public class Code
{
    //Starting from the first element of inputArray, returns the sum of each element until an element of
    //0 is encountered.
	static int houseNumbersSum(int[] inputArray)
	{
        int total = 0;
        //Go through each element until a 0(which is guaranteed) is encountered.
        //Add each encountered element to total.
        for(int index=0; inputArray[index]!=0; index++)
        {
            total += inputArray[index];
        }
        return total;
	}

    //function that returns contents of an int array as a String
    //that also appends a newline at the end.
    static String printArray(int[] inputArray)
    {
        String array = "";
        for(int index=0; index<inputArray.length; index++)
        {
            array += " " + inputArray[index];
        }
        array += "\n";
        return array;
    }
    
	public static void main(String[] args)
	{
        int[] inputArray = {5, 1, 2, 3, 0, 1, 5, 0, 2};
        System.out.println("inputArray:"+printArray(inputArray)+"houseNumbersSum: "+houseNumbersSum(inputArray));
	}
}
