// You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.
import java.util.Arrays;
class ArrayChange{
    public static int arrayChange(int[] inputArray) {
        int moves = 0;
        int last = inputArray[0];
        //go through array and compare it to the previous element
        for(int i=1; i<inputArray.length; i++){
            //if the current element is not greater than the last
            //then it needs to be increased
            if(inputArray[i] <= last){
                int difference = (last - inputArray[i]) + 1;
                moves += difference;
                inputArray[i] += difference;
            }
            last = inputArray[i];
        }
        return moves;
    }
    
    public static void main(String[] args){
        int[] inputArray = {1, 1, 1};
        System.out.println("moves to make array "+Arrays.toString(inputArray)+" increasing: "+ArrayChange.arrayChange(inputArray));
        System.out.println("Expected: 3");
        int[] inputArray2 = {-1000, 0, -2, 0};
        System.out.println("moves to make array "+Arrays.toString(inputArray2)+" increasing: "+ArrayChange.arrayChange(inputArray2));
        System.out.println("Expected: 5");
        int[] inputArray3 = {2, 1, 10, 1};
        System.out.println("moves to make array "+Arrays.toString(inputArray3)+" increasing: "+ArrayChange.arrayChange(inputArray3));
        System.out.println("Expected: 12");
        int[] inputArray4 = {2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15};
        System.out.println("moves to make array "+Arrays.toString(inputArray4)+" increasing: "+ArrayChange.arrayChange(inputArray4));
        System.out.println("Expected: 13");
    }
}