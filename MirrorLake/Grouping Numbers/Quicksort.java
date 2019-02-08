import java.util.Arrays;
import java.util.Random;

public class Quicksort
{
    public static void quicksort(int[] array)
    {
        fixPivot(array);
        int lastElementIndex = array.length-1;
        //System.out.println("lastElementIndex:"+lastElementIndex);
        int pivotPoint = partition(array, 0, lastElementIndex);//[3]:3
        //System.out.println("pivotPoint:"+pivotPoint);
        quicksort(array, 0, (pivotPoint-1));//[6]
        quicksort(array, (pivotPoint+1), lastElementIndex);//[6]
    }
    
    public static void quicksort(int[] array, int first, int last)
    {
        int pivotPoint = partition(array, first, last);//[7]:2
        if(pivotPoint==0)
        {
            return;
        }
        quicksort(array, first, (pivotPoint-1));//[8]:0-1,0;
        quicksort(array, (pivotPoint+1), last);//[8]:3-2
    }
    
    public static int partition(int[] array, int first, int last)
    {
        //System.out.println("Before partition:"+Arrays.toString(array));
        int length = ((last-first)+1);
        if(length<2)
        {
            return 0;
        }
        int left = first+1;
        int right = first+1;
        /*int step = 0;
        System.out.println("\tPartition step "+step+".");
        showArrayWithPLR(array, left, right);*/
        //boolean swapped = false;
        do
        {
            if(array[right]<array[first])
            {
                //System.out.println("\tGoing to Swap "+left+" & "+right+".");
                swap(array, left, right);
                left++;
                right++;
                /*step++;
                System.out.println("\tPartition step "+step+". L:"+left+". R:"+right+". Found less than->swap.");
                showArrayWithPLR(array, left, right);*/
                //swapped = true;
            }
            else
            {
                right++;
                /*step++;
                System.out.println("\tPartition step "+step+". L:"+left+". R:"+right+". Found greater or equal->R++");
                showArrayWithPLR(array, left, right);*/
                //swapped = false;
            }
        }while(right<=last);
        int pivotPoint = left-1;
        swap(array, first, pivotPoint);
        //System.out.println("After  partition:"+Arrays.toString(array));
        return pivotPoint;
    }
    
    public static void fixPivot(int[] array)
    {
        swap(array, 0, (array.length/2));
        Random random = new Random();
        swap(array, 0, random.nextInt(array.length));
    }
    
    public static void showArrayWithPLR(int[] array, int left, int right)
    {
        String top = " P  ";
        for(int i=1; i<left; i++)
        {
            top += "   ";
        }
        if(left==right)
        {
            top +="B";
            System.out.println("\t"+top+"\n\t"+Arrays.toString(array));
        }
        else
        {
            top += "L  ";
            for(int i=left+1; i<right; i++)
            {
                top += "   ";
            }
            top += "R";
            System.out.println("\t"+top+"\n\t"+Arrays.toString(array));
        }
        
    }
    
    public static void swap(int[] array, int left, int right)
    {
        Integer leftValue = array[left];
        Integer rightValue = array[right];
        //System.out.println("swapping array["+left+"]:"+array[left]+" with array["+right+"]:"+array[right]+".");
        array[left] = rightValue;
        array[right] = leftValue;
        //System.out.println("array is now "+Arrays.toString(array));
    }
}
