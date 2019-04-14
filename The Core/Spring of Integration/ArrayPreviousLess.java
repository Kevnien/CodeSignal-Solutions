// Given array of integers, for each position i, search among the previous positions for the last (from the left) position that contains a smaller value. Store this value at position i in the answer. If no such value can be found, store -1 instead.

import java.util.Arrays;
class ArrayPreviousLess{
    public static int[] arrayPreviousLess(int[] items){
        int minimum = items[0];
        int[] answer = new int[items.length];
        answer[0] = -1;
        for(int i=1; i<items.length; i++){
            if(items[i] <= minimum){
                answer[i] = -1;
                minimum = items[i];
                continue;
            }
            for(int j=i-1; j>=0; j--){
                if(items[j] < items[i]){
                    answer[i] = items[j];
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        int[][][] inputOutput = {
            {
                {3, 5, 2, 4, 5},
                {-1, 3, -1, 2, 4}
            },
            {
                {2, 2, 1, 3, 4, 5, 5, 3},
                {-1, -1, -1, 1, 3, 4, 4, 1}
            },
            {
                {3, 2, 1},
                {-1, -1, -1}
            },
            {
                {100, 101, 102},
                {-1, 100, 101}
            },
            {
                {7, 7, 8, 3, 4, 4, 2, 5, 6, 7, 7},
                {-1, -1, 7, -1, 3, 3, -1, 2, 5, 6, 6}
            },
            {
                {68, 135, 101, 170, 125},
                {-1, 68, 68, 101, 101}
            }
        };
        for(int i=0; i<inputOutput.length; i++){
            System.out.print(i+": ");
            String print;
            print = equals(arrayPreviousLess(inputOutput[i][0]),(inputOutput[i][1])) ? "PASS" : "FAIL";
            System.out.println(print);
        }
    }

    public static boolean equals(int[] a1, int[] a2){
        if(a1.length != a2.length){
            return false;
        }
        for(int i=0; i<a1.length; i++){
            if(a1[i] != a2[i]){
                return false;
            }
        }
        return true;
    }
}