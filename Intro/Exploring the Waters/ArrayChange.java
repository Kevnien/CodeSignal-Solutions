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
    }
}