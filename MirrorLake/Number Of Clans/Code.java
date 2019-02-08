/*
 Kevin Nguyen: KevinN858@gmail.com
 April 29th, 2017
 
 Problem taken from https://codefights.com/arcade/code-arcade/mirror-lake/BLbGNY3kEcvKjBCFC/description
 Let's call two integers A and B friends if each integer from the array divisors is either a divisor of both A and B or neither A nor B. If two integers are friends, they are said to be in the same clan. How many clans are the integers from 1 to k, inclusive, broken into?
 Guaranteed constraints: 2 ≤ divisors.length < 10, 1 ≤ divisors[i] ≤ 10.
 [input] integer k: A positive integer.
 Guaranteed constraints: 5 ≤ k ≤ 10.
 
 Notes: I could use the fact that I'm using numbers from 1 to k to create an algorithm
 that's more efficient than brute-forcing through all numbers 1 to k
 and having it test for all ints inside divisors.
 Therefore complexity is always n*m.
 However, with the constraints, it seems it's not worth it to create a more intelligent algorithm.
 Max complexity: 10*10=100
 Such as the fact that runtime could be shortened by computing ahead of time that starting from k
 going down, there are multiple numbers lower than the current number that are divisors itself of
 the current number and therefore can be sorted into a clan.
 Or running through the divisors and see the max combination of divisors(a clan) that k or anything else
 could possibly fit into.
 
 Clan size isn't needed so I didn't bother incrementing the value of the key,value pair.
*/
import java.util.HashMap;

public class Code
{
    public static int numberOfClans(int[] divisors, int k)
    {
        //Will take each number from 1 to k.
        //With each number see what clan it belongs to and puts that in the HashMap.
        //Will not actually keep record of which number belongs to which clan nor
        //keep record of the clan size.
        HashMap<String,Integer> clans = new HashMap<String,Integer>();
        
        //cycle through all integers from 1 to k
        for(int currentNumber=1; currentNumber<=k; currentNumber++)
        {
            //find out which clan currentNumber belongs to
            //cycle through all divisors and see if currentNumber is divisible by the divisor
            //if the integer from divisors is a divisor then add it to the String
            String clanName = "";
            for(int index=0; index<divisors.length; index++)
            {
                int currentDivisor = divisors[index];
                if(currentNumber%currentDivisor==0)
                {
                    clanName += Integer.toString(currentDivisor);
                }
            }
            //adds clan if doesn't exist or replaces the clan with what it would already be
            clans.put(clanName,0);
        }
        return clans.size();
    }
    
    public static void perform(int[] divisors, int k)
    {
        System.out.print("[divisors]:");
        for(int index=0; index<divisors.length-1; index++)
        {
            System.out.print(divisors[index]+", ");
        }
        System.out.println(divisors[divisors.length-1]);
        System.out.println("k:"+k+"\nNumber of clans:"+numberOfClans(divisors,6));
    }
    
    public static void main(String[] args)
    {
        int[] divisors = {2,3};
        perform(divisors,6);
    }
}
