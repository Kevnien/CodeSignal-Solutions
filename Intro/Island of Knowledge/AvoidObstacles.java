// You are given an array of integers representing coordinates of obstacles situated on a straight line.

// Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of the same length represented by some integer.

// Find the minimal length of the jump enough to avoid all the obstacles.
import java.util.Arrays;

class AvoidObstacles{
    public static int avoidObstacles(int[] inputArray) {
        int[] sorted = sort(inputArray);
        boolean collides = true;
        int jumpLength = 1;
        while(collides){
            jumpLength++;
            int position = 0;
            boolean doesNotCollide = true;
            while(position<sorted[sorted.length-1]){
                position += jumpLength;
                for(int i=0; i<sorted.length; i++){
                    if(position == sorted[i]){
                        doesNotCollide = false;
                        break;
                    }
                }
                if(!doesNotCollide){
                    break;
                }
            }
            if(doesNotCollide){
                collides = false;
            }
        }
        return jumpLength;
    }
    
    public static int[] sort(int[] inputArray){
        int[] array = new int[inputArray.length];
        int biggest = 0;
        int indexArray = inputArray.length-1;
        int indexInput = 0;
        for(int i=0; i<inputArray.length; i++){
            for(int j=0; j<inputArray.length; j++){
                if(inputArray[j] > biggest){
                    biggest = inputArray[j];
                    indexInput = j;
                }
            }
            array[indexArray--] = biggest;
            inputArray[indexInput] = 0;
            biggest = 0;
        }
        return array;
    }

    public static void main(String[] args){
        int[][] inputs = {
            {5, 3, 6, 7, 9},
            {2, 3},
            {1, 4, 10, 6, 2},
            {1000, 999},
            {19, 32, 11, 23},
            {5, 8, 9, 13, 14}
        };
        int[] expecteds = {
            4,
            4,
            7,
            6,
            3,
            6
        };
        for(int i=0; i<expecteds.length; i++){
            System.out.println(
                "avoidObstacles("+
                Arrays.toString(inputs[i])+
                "): "+
                avoidObstacles(inputs[i])+
                "\nExpected: "+
                expecteds[i]
            );
        }
    }
}