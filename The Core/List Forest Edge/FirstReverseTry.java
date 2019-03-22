public class FirstReverseTry
{
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5};
        firstReverseTry(arr);
        System.out.println(arr[0]);
    }

    public static int[] firstReverseTry(int[] arr)
    {
        int aux = arr[0];
        arr[0] = arr[arr.length-1];
        arr[arr.length-1] = aux;
        return arr;
    }
}
