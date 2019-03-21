// Construct a square matrix with a size N × N containing integers from 1 to N * N in a spiral order, starting from top-left and in clockwise direction.

import java.util.Arrays;
class SpiralNumbers{
    public static int[][] spiralNumbers(int n){
        String[] directions = {"right", "down", "left", "up"};
        Integer directionsIndex = 0;
        Integer current = 1;
        int[][] answer = new int[n][n];
        int[] index = {0,-1};
        Integer turns = 1;
        runLine(answer, index, directions, directionsIndex, current, turns);
        return answer;
    }

    public static void runLine(int[][] array, int[] index, String[] directions, Integer directionsIndex, Integer current, Integer turns){
        int times = array.length - (turns++/2);
        String direction = directions[directionsIndex++];
        // System.out.println("direction: "+direction);
        // System.out.println("times: "+times);
        for(int i=0; i<times; i++){
            switch(direction){
                case "right":
                    index[1]++;
                    break;
                case "down":
                    index[0]++;
                    break;
                case "left":
                    index[1]--;
                    break;
                case "up":
                    index[0]--;        
                    break;
                default:
                    System.out.println("ERROR:"+directions[--directionsIndex]);
            }
            array[index[0]][index[1]] = current++;
        }
        if(directionsIndex > 3){
            directionsIndex = 0;
        }
        if(current > array.length*array.length){
            return;
        }
        runLine(array, index, directions, directionsIndex, current, turns);
    }

    public static void main(String[] args){
        int[][][][] inputOutputs = {
            {
                {{3}},
                {
                    {1,2,3},
                    {8,9,4},
                    {7,6,5}
                }
            },
            {
                {{5}},
                {
                    {1, 2, 3, 4, 5},
                    {16,17,18,19,6},
                    {15,24,25,20,7},
                    {14,23,22,21,8},
                    {13,12,11,10,9}
                }
            },
            {
                {{6}},
                {
                    {1, 2, 3, 4, 5, 6}, 
                    {20,21,22,23,24,7}, 
                    {19,32,33,34,25,8}, 
                    {18,31,36,35,26,9}, 
                    {17,30,29,28,27,10}, 
                    {16,15,14,13,12,11}
                }
            },
            {
                {{7}},
                {
                    {1, 2, 3, 4, 5, 6, 7}, 
                    {24,25,26,27,28,29,8}, 
                    {23,40,41,42,43,30,9}, 
                    {22,39,48,49,44,31,10}, 
                    {21,38,47,46,45,32,11}, 
                    {20,37,36,35,34,33,12}, 
                    {19,18,17,16,15,14,13}
                }
            },
            {
                {{10}},
                {
                    {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 
                    {36,37,38,39,40,41,42,43,44,11}, 
                    {35,64,65,66,67,68,69,70,45,12}, 
                    {34,63,84,85,86,87,88,71,46,13}, 
                    {33,62,83,96,97,98,89,72,47,14}, 
                    {32,61,82,95,100,99,90,73,48,15}, 
                    {31,60,81,94,93,92,91,74,49,16}, 
                    {30,59,80,79,78,77,76,75,50,17}, 
                    {29,58,57,56,55,54,53,52,51,18}, 
                    {28,27,26,25,24,23,22,21,20,19}
                }
            }
        };
        for(int[][][] pair: inputOutputs){
            int[][] answer = spiralNumbers(pair[0][0][0]);
            System.out.print(
                "spiralNumbers("+pair[0][0][0]+"):\n"+
                toString(answer)+"\n"+
                toString(pair[1])+"^-- expected output"
            );
            String end = "";
            if(compare(answer, pair[1])){
                end = " PASSED";
            }else{
                end = " FAILED";
            }
            System.out.println(end);
        }
    }

    public static String toString(int[][] twoDArray){
        String string = "";
        for(int i=0; i<twoDArray.length; i++){
            for(int j=0; j<twoDArray[i].length; j++){
                string += twoDArray[i][j];
                if(j == twoDArray.length-1){
                    string += "\n";
                }else{
                    string += ", ";
                }
            }
        }
        return string;
    }

    public static boolean compare(int[][] twoDArray1, int[][] twoDArray2){
        if(twoDArray1.length != twoDArray2.length){
            return false;
        }
        for(int i=0; i<twoDArray1.length; i++){
            if(twoDArray1[i].length != twoDArray2[i].length){
                return false;
            }
            for(int j=0; j<twoDArray1[i].length; j++){
                if(twoDArray1[i][j] != twoDArray2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}