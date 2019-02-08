import java.util.*;

public class ConstructSquare
{
    HashMap<Integer,HashMap<Character,Integer>> squares;

    public ConstructSquare()
    {
        squares = new HashMap<Integer,HashMap<Character,Integer>>();
    }

    public int constructSquare(String s)
    {
        computeSquares(s);
        HashMap<Character,Integer> uniqueDigitsAmount = furtherAnalyzeString(s);
        int largest = -1;
        for(Map.Entry<Integer,HashMap<Character,Integer>> squaresEntry : squares.entrySet())
        {
            //System.out.println("Trying "+squaresEntry.getKey()+".");
            int matches = 0;
            for(Map.Entry<Character,Integer> uniqueDigitsAmountEntry : uniqueDigitsAmount.entrySet())
            {
                for(Map.Entry<Character,Integer> squaresEntryEntry : squaresEntry.getValue().entrySet())
                {
                    if(squaresEntryEntry.getValue()==uniqueDigitsAmountEntry.getValue())
                    {
                        //System.out.println("\t"+squaresEntryEntry.getValue()+" equals "+uniqueDigitsAmountEntry.getValue());
                        squaresEntry.getValue().remove(squaresEntryEntry.getKey());
                        matches++;
                        break;
                    }
                }
                //System.out.println("amount of entries in uniqueDigitsAmount:"+uniqueDigitsAmount.size());
                //System.out.println("matches:"+matches);
                if(matches==uniqueDigitsAmount.size())
                {
                    int currentKey = (Integer)squaresEntry.getKey();
                    if(currentKey>largest)
                    {
                        largest = currentKey;
                    }
                    break;
                }
            }
        }
        return largest;
    }

    /*public HashMap<Character,Integer> analyzeString(String s)
    {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i<s.length(); i++)
        {
            
        }
    }*/
    
    public HashMap<Character,Integer> furtherAnalyzeString(String s)
    {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0; i<s.length(); i++)
        {
            char current = s.charAt(i);
            if(map.get(current)==null)
            {
                map.put(current,1);
            }
            else
            {
                int newValue = ((Integer)map.get(current))+1;
                map.put(current,newValue);
            }
        }
        return map;
    }

    public void computeSquares(String s)
    {
        int cap = (int) Math.pow(10,s.length());
        int current = 1;
        int lower = cap/10;
        int i = 1;
        while(current<lower)
        {
            current = i*i;
            i++;
        }
        for(int j=i; current<cap; j++)
        {
            current = j*j;
            HashMap<Character,Integer> uniqueDigits = furtherAnalyzeString(Integer.toString(current));
            squares.put(current,uniqueDigits);
        }
        squares.remove(current);
    }
    
    /*public class SquareBlock
    {
        public int uniqueDigitsAmount;
        public ArrayList<Integer> amountPerDigit;
        public SquareBlock()
        {
            uniqueDigitsAmount = -1;
            amountPerDigit = new ArrayList<Integer>();
        }
    }*/

    public void perform(String s)
    {
        System.out.println(s+":"+constructSquare(s));
    }

    public static void main(String[] args)
    {
        ConstructSquare object = new ConstructSquare();
        object.perform("ab");
        object.perform("zzz");
        object.perform("aba");
        object.perform("abcbbb");
        object.perform("abc");
        object.perform("aaaabbcde");
    }
}
