// Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.

import java.util.Arrays;
class ArrayReplace{
    public static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem){
        int[] copy = Arrays.copyOf(inputArray, inputArray.length);
        for(int i=0; i<inputArray.length; i++){
            if(inputArray[i] == elemToReplace){
                copy[i] = substitutionElem;
            }
        }
        return copy;
    }

    public static void main(String[] args){
        int[][] inputArrays = {
            {1,2,1},
            {1,2,3,4,5},
            {1,1,1},
            {1,2,1,2,1},
            {1,2,1,2,1},
            {3,1}
        };
        int[] elemsToReplace = {
            1,
            3,
            1,
            2,
            2,
            3
        };
        int[] substitutionElems = {
            3,
            0,
            10,
            1,
            2,
            9
        };
        int[][] expectedOutputs = {
            {3,2,3},
            {1,2,0,4,5},
            {10,10,10},
            {1,1,1,1,1},
            {1,2,1,2,1},
            {9,1}
        };
        for(int i=0; i<expectedOutputs.length; i++){
            System.out.println(
                "arrayReplace("+
                Arrays.toString(inputArrays[i])+
                ", "+elemsToReplace[i]+
                ", "+substitutionElems[i]+
                "):"+Arrays.toString(arrayReplace(inputArrays[i], elemsToReplace[i], substitutionElems[i]))
            );
            System.out.println("expectedOutput: "+Arrays.toString(expectedOutputs[i]));
        }
    }
}