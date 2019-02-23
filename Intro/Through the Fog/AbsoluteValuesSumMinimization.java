// Given a sorted array of integers a, find an integer x from a such that the value of

// abs(a[0] - x) + abs(a[1] - x) + ... + abs(a[a.length - 1] - x)
// is the smallest possible (here abs denotes the absolute value).
// If there are several possible answers, output the smallest one.

import java.util.Arrays;
import java.util.Hashtable;
import java.lang.Math;

class AbsoluteValuesSumMinimization{
    public static int absoluteValuesSumMinimization(int[] a){
        class LeastObj{
            public int[] array;
            public int length;
            public LeastObj(int arrayLength, int num){
                this.array = new int[arrayLength];
                this.array[0] = num;
                length = 1;
            }
            public void addNum(int num){
                this.array[this.length++] = num;
            }
        }
        Hashtable<Integer, LeastObj> table = new Hashtable<Integer, LeastObj>();
        int least = 9999999;
        int leastNum = 0;
        for(int i=0; i<a.length; i++){
            int current = absSum(a, i);
            if(least > current){
                least = current;
                leastNum = a[i];
                if(table.get(leastNum) == null){
                    LeastObj newLeastObj = new LeastObj(a.length, leastNum); 
                    table.put(least, newLeastObj);
                }else{
                    table.get(least).addNum(leastNum);
                }
            }
        }
        LeastObj leastObj = table.get(least);
        least = leastObj.array[0];
        for(int i=1; i<leastObj.length; i++){
            if(leastObj.array[i] < least){
                least = leastObj.array[i];
            }
        }
        return least;
    }

    public static int absSum(int[] a, int index){
        int current = 0;
        for(int i=0; i<a.length; i++){
            current += Math.abs(a[i]-a[index]);
        }
        return current;
    }

    public static void main(String[] args){
        int[][] inputs = {
            {2,4,7},
            {1,1,3,4},
            {23},
            {-10, -10, -10, -10, -10, -9, -9, -9, -8, -8, -7, -6, -5, -4, -3, -2, -1, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
            {-4,-1},
            {0,7,9},
            {-1000000, -10000, -10000, -1000, -100, -10, -1, 0, 1, 10, 100, 1000, 10000, 100000, 1000000},
            {-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150},
            {-10, 100, 200, 300, 400, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500}
        };
        int[] expectedOutputs = {
            4,
            1,
            23,
            15,
            -4,
            7,
            0,
            65,
            500
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "absoluteValueSumMinimization("+
                Arrays.toString(inputs[i])+"): "+
                absoluteValuesSumMinimization(inputs[i])+"\n"+
                "expected output: "+
                expectedOutputs[i]
            );
        }
    }
}