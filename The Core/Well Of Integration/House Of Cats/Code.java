/*
 Kevin Nguyen - KevinN858@gmail.com
 April 30th, 2017
 
 Problem taken from CodeFights.com - Well of Integration - House of Cats
 There are some people and cats in a house. You are given the number of legs they have all together. Your task is to return an array containing every possible number of people that could be in the house sorted in ascending order. It's guaranteed that each person has 2 legs and each cat has 4 legs.
 Example:
 For legs = 6, the output should be
 houseOfCats(legs) = [1, 3].
 There could be either 1 cat and 1 person (4 + 2 = 6) or 3 people (2 * 3 = 6).
 For legs = 2, the output should be
 houseOfCats(legs) = [1].
 There can be only 1 person.
 Input/Output:
 [time limit] 3000ms (java) [input] integer legs
 The total number of legs in the house.
 Guaranteed constraints:    0 ≤ legs ≤ 45.
 [output] array.integer:    Every possible number of people that can be in the house.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Code
{
    //Note: Decided to first calculate the max possible cat legs first then go backwards
    //to get the ascending order that's required, instead of
    //computing the amount of people possible as ascending cat legs are considered.
    //The latter would result in reverse ordered amounts of people.
    //i.e. I think it's better to not have to reverse the order by just doing an initial quick calculation.
    static int[] houseOfCats(int legs)
    {
        ArrayList<Integer> amountsOfPossiblePeople = new ArrayList<Integer>();
        //find maximum possible amount of legs belonging to cats
        int maxCatLegsPossible = 0;
        while(maxCatLegsPossible<=legs)
        {
            maxCatLegsPossible += 4;
        }
        maxCatLegsPossible -= 4;
        //fill ArrayList with amounts of people possible
        while(maxCatLegsPossible>=0)
        {
            amountsOfPossiblePeople.add((legs-maxCatLegsPossible)/2);
            maxCatLegsPossible -= 4;
        }
        //create the int[] that's required
        int length = amountsOfPossiblePeople.size();
        int[] requiredReturnType = new int[length];
        for(int i=0; i<length; i++)
        {
            requiredReturnType[i] = amountsOfPossiblePeople.get(i);
        }
        return requiredReturnType;
    }
    
    public static void main(String[] args)
    {
        System.out.println("houseOfCats(6):"+Arrays.toString(houseOfCats(6)));
        System.out.println("houseOfCats(2):"+Arrays.toString(houseOfCats(2)));
        System.out.println("houseOfCats(8):"+Arrays.toString(houseOfCats(8)));
    }
}
