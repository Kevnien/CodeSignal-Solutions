// You have a long strip of paper with integers written on it in a single line from left to right. You wish to cut the paper into exactly three pieces such that each piece contains at least one integer and the sum of the integers in each piece is the same. You cannot cut through a number, i.e. each initial number will unambiguously belong to one of the pieces after cutting. How many ways can you do it?

// It is guaranteed that the sum of all elements in the array is divisible by 3.

import java.util.Arrays;
class ThreeSplit{
    public static int threeSplit(int[] a){
        int target = getTarget(a);
        int part1Sum = 0;
        int part2Sum = 0;
        int answer = 0;
        for(int i=0; i<a.length-2; i++){
            part1Sum += a[i];
            part2Sum = 0;
            if(part1Sum == target){
                for(int j=i+1; j<a.length-1; j++){
                    part2Sum += a[j];
                    if(part2Sum == target){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static int getTarget(int[] a){
        int total = 0;
        for(int i=0; i<a.length; i++){
            total += a[i];
        }
        return total/3;
    }

    public static void main(String[] args){
        int[][][] inputsOutputs = {
            {
                {0, -1, 0, -1, 0, -1},
                {4}
            },
            {
                {-1, 1, -1, 1, -1, 1, -1, 1},
                {3}
            }
        };
        for(int[][] pair: inputsOutputs){
            int answer = threeSplit(pair[0]);
            System.out.print(
                "threeSplits("+Arrays.toString(pair[0])+"):\n"+
                answer+"\n"+
                pair[1][0]+" <-- expected output"
            );
            if(answer == pair[1][0]){
                System.out.println(" PASSED");
            }else{
                System.out.println(" FAILED");
            }
        }
    }
}