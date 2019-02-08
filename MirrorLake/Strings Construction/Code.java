/*Written by Kevin Nguyen (KevinN858@gmail.com) on April 21st, 2017.
This code (focused on the method StringsConstruction) will take in 2 strings.
It will see how many times the first string can be created from the letters in the second string.
 rules: letters cannot be used twice
 */
import java.util.HashMap;
import java.util.Collections;

public class Code
{
    //Returns the number (int) of how many times the first parameter (String) could be created from
    //the second parameter (String) as explained above.
    //Referred to as "focused-on method"
    public static int StringsConstruction(String A, String B)
    {
        //This hashmap is to hold the letters (Character) of the second parameter (String)
        //which is thought of as the inventory of letters that are available to use to
        //construct the first parameter (String).
        //The HashMap will hold the letters as the Key and the Values (Integer) will be the number
        //of times the letter is in the second parameter.
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        //Takes the second parameter and fills the HashMap
        fillMap(map, B);
        //int count represents how many times A can be made from B
        int count = 0;
        //See if there is enough inventory to make a letter
        //Accordingly increase count and adjust values in map
        //Continue to do so until there isn't enough inventory
        while(checkIfEnoughInventory(A,map))
        {
            count++;
        }
        return count;
    }
    
    //Takes the Characters of String A and checks if a HashMap<Character,Integer> has a key of that Character
    //and a paired Value to the key that is above 0.
    //The intention is to have a HashMap that has an inventory of Character keys and the paired value represents
    //the amount of that Character is available to use.
    //Therefore the value is decreased if used.
    //Returns true if A can be created from inventory.
    //note: will still decrease values (too minimum of 0) if entire A cannot be created from the inventory that is map
    public static boolean checkIfEnoughInventory(String A, HashMap<Character,Integer> map)
    {
        for(int index=0; index<A.length(); index++)
        {
            Character currentKey = A.charAt(index);
            Integer currentValue = map.get(currentKey);
            if(currentValue==null || currentValue==0)
            {
                return false;
            }
            currentValue--;
            map.put(currentKey,currentValue);
        }
        return true;
    }
    
    //Takes a String (B) and fills a HashMap<Character,Integer> (map) of the letters in String B
    public static void fillMap(HashMap<Character,Integer> map, String B)
    {
        //goes through each letter in B and puts it in map
        //increments the value for the key so that the value represents how many of that
        //letter is in B
        for(int index=0; index<B.length(); index++)
        {
            Character currentKey = B.charAt(index);
            Integer currentValue = map.get(currentKey);
            if(currentValue!=null)
            {
                map.put(currentKey,currentValue+1);
            }
            else
            {
                map.put(currentKey,1);
            }
        }
        //tested to see if all pairs were properly added
        //System.out.println("map:\n"+Collections.singletonList(map));
    }
    
    //Takes in a String array of multiple pairs of Strings to run StringsConstruction(String A, String B)
    //on.
    public static void runTests(String[] array)
    {
        if(array.length%2==0)
        {
            String[] pair = new String[2];
            for(int index=0; index<array.length; index++)
            {
                pair[0] = array[index];
                index++;
                pair[1] = array[index];
                System.out.println(array[index-1]+": "+StringsConstruction(pair));
            }
        }
    }
    
    //This method will overload the focused-on method of this program.
    //Will handle arrays of length 2 that is a pair of a string A and string B.
    //Will return the length of the input array if the inputArray isn't properly handled.
    public static int StringsConstruction(String[] inputArray)
    {
        if(inputArray.length==2)
        {
            return StringsConstruction(inputArray[0],inputArray[1]);
        }
        System.out.println("Unhandle-able inputArray length.");
        return inputArray.length;
    }
    
    public static void main(String[] args)
    {
        String[] test1 = {"abc","abccba"};
        System.out.println(test1[0]+": "+StringsConstruction(test1));
        String[] restOfTheTests = {"hnccv","hncvohcjhdfnhonxddcocjncchnvohchnjohcvnhjdhihsn","abc","def","zzz","zzzzzzzzzzz"};
        runTests(restOfTheTests);
    }
}
