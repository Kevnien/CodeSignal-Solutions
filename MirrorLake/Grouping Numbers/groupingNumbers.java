import java.util.Arrays;
import java.util.HashMap;

public class groupingNumbers
{
    int[] array;
    int currentGroup, currentCap;
    
    public groupingNumbers(int[] inputArray)
    {
        array = inputArray;
        currentGroup = 0;
        currentCap = 0;
    }
    
    public int numbersGrouping(int[] a)
    {
        increment();
        Quicksort.quicksort(a);
        //System.out.println("array: "+Arrays.toString(a));
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int number: a)
        {
            if(number<=currentCap)
            {
                //System.out.println("Putting pair ("+currentGroup+", "+number+").");
                map.put(currentGroup,number);
            }
            else
            {
                increment(number);
                map.put(currentGroup,number);
            }
        }
        //System.out.println(Arrays.toString(map.keySet().toArray()));
        return calculateLines(map,a);
    }
    
    public int calculateLines(HashMap<Integer,Integer> map, int[] a)
    {
        int total = map.size();
        total += array.length;
        return total;
    }
    
    public void increment()
    {
        currentGroup++;
        currentCap = currentGroup*10000;
    }
    
    public void increment(int number)
    {
        do
        {
        currentGroup++;
        currentCap = currentGroup*10000;
        }while(number>currentCap);
        //System.out.println("Performed increment(). currentCap:"+currentCap);
    }
    
    public void perform()
    {
        System.out.println("There are "+numbersGrouping(array)+" lines.");
    }
    
    public static void main(String[] args)
    {
        int[] array = {20000,239,10001,999999,10000,20566,29999};
        groupingNumbers object = new groupingNumbers(array);
        object.perform();
    }
}
