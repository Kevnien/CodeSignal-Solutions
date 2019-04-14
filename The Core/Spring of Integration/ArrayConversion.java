// Given an array of 2k integers (for some integer k), perform the following operations until the array contains only one element:

// On the 1st, 3rd, 5th, etc. iterations (1-based) replace each pair of consecutive elements with their sum;
// On the 2nd, 4th, 6th, etc. iterations replace each pair of consecutive elements with their product.
// After the algorithm has finished, there will be a single element left in the array. Return that element.

class ArrayConversion{
    public static int arrayConversion(int[] inputArray){
        boolean odd = true;
        while(inputArray.length > 1){
            int[] temporary = new int[inputArray.length/2];
            int index = 0;
            if(odd){
                odd = false;
                for(int i=0; i<inputArray.length; i+=2){
                    temporary[index++] = inputArray[i] + inputArray[i+1];
                }
                inputArray = temporary;
            }else{
                odd = true;
                for(int i=0; i<inputArray.length; i+=2){
                    temporary[index++] = inputArray[i] * inputArray[i+1];
                }
                inputArray = temporary;
            }
        }
        return inputArray[0];
    }

    public static void main(String[] args){
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8}; //186
        int[][][] inputOutput = {
            {
                inputArray,
                {186}
            },
            {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {64}
            },
            {
                {3, 3, 5, 5},
                {60}
            },
            {
                {-1, 1, 2, 3, 5, 5, 3, 7},
                {100}
            },
            {
                {99},
                {99}
            },
            {
                {99,1},
                {100}
            },
            {
                {34, 60, -9, -67, -100, -27, 100, 21},
                {-22511}
            }
        };
        for(int i=0; i<inputOutput.length; i++){
            System.out.print(i+": ");
            String print;
            if(arrayConversion(inputOutput[i][0]) == inputOutput[i][1][0]){
                print = "PASS";
            }else{
                print = "FAIL";
            }
            System.out.println(print);
        }
    }
}