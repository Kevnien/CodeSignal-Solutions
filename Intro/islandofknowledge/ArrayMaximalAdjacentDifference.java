// Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
import java.util.Arrays;

class ArrayMaximalAdjacentDifference{
    public static int arrayMaximalAdjacentDifference(int[] inputArray) {
        int max = 0;
        for(int i=1; i<inputArray.length; i++){
            int difference = Math.abs(inputArray[i]-inputArray[i-1]);
            if(difference > max){
                max = difference;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[][] tests = {
            {2, 4, 1, 0},
            {1, 1, 1, 1},
            {-1, 4, 10, 3, -2},
            {10, 11, 13},
            {-2, -2, -2, -2, -2},
            {-1, 1, -3, -4}
        };
        int[] expectedOutputs = {
            3,
            0,
            7,
            2,
            0,
            4
        };
        for(int i=0; i<expectedOutputs.length; i++){
            System.out.println("arrayMaximalAdjacentDifference("
                +Arrays.toString(tests[i])
                +"): "
                +arrayMaximalAdjacentDifference(tests[i])
                +"\nExpected: "
                +expectedOutputs[i]
            );
        }
    }    
}