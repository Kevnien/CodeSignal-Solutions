import java.util.*;

public class Test
{
    static void perform(int[] array)
    {
        System.out.println(Arrays.toString(array));
        Quicksort.quicksort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void main(String[] args)
    {
        int[] array = {3,1,4,1,5,9,2,6,5,3};
        perform(array);
        
        int[] array2 = {20000,239,10001,999999,10000,20566,29999};
        perform(array2);
         /*System.out.println(Arrays.toString(array));
         Quicksort.swap(array, 0, 1);
         System.out.println(Arrays.toString(array));*/
    }
}
