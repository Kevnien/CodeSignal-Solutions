// Given array of integers, remove each kth element from it.

import java.util.Arrays;
class ExtractEachKth{
    public static int[] extractEachKth(int[] inputArray, int k){
        int[] answer = new int[inputArray.length-(inputArray.length/k)];
        int index = 0;
        for(int i=0; i<inputArray.length; i++){
            if((i+1)%k == 0){
                continue;
            }
            answer[index++] = inputArray[i];
        }
        return answer;
    }

    public static void main(String[] args){
        int[][][] inputs = {
            {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {3}
            },
            {
                {1, 1, 1, 1, 1},
                {1}
            },
            {
                {1, 2, 1, 2, 1, 2, 1, 2},
                {2}
            },
            {
                {1, 2, 1, 2, 1, 2, 1, 2},
                {10}
            },
            {
                {2, 4, 6, 8, 10},
                {2}
            }
        };
        int[][] expectedOutputs = {
            {1, 2, 4, 5, 7, 8, 10},
            {},
            {1,1,1,1},
            {1,2,1,2,1,2,1,2},
            {2, 6, 10}
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "extractEachKth("+
                Arrays.toString(inputs[i][0])+", "+
                inputs[i][1][0]+"): \n"+
                Arrays.toString(extractEachKth(inputs[i][0], inputs[i][1][0]))+"\n"+
                Arrays.toString(expectedOutputs[i])+
                " <-- expected output: "
            );
        }
    }
}