// Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral! You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its content.

// The pixels in the input image are represented as integers. The algorithm distorts the input image in the following way: Every pixel x in the output image has a value equal to the average value of the pixel values from the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then removed.

// Return the blurred image as an integer, with the fractions rounded down.

import java.util.Arrays;

class BoxBlur{
    public static int[][] boxBlur(int[][] image){
        int[][] blurred = new int[image.length-2][image[0].length-2];
        for(int y=0; y<image.length-2; y++){
            for(int x=0; x<image[0].length-2; x++){
                int sum = 0;
                for(int nineX=x; nineX<x+3; nineX++){
                    for(int nineY=y; nineY<y+3; nineY++){
                        sum += image[nineY][nineX];
                    }
                }
                blurred[y][x] = sum/9;
            }
        }
        return blurred;
    }

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][][] inputs = {
            {
                {1,1,1},
                {1,7,1},
                {1,1,1}
            },
            {
                {0 ,18, 9},
                {27,9 , 0},
                {81,63,45}
            },
            {
                {36,0 ,18,9},
                {27,54,9 ,0},
                {81,63,72,45}
            },
            {
                {7 ,4 ,0 ,1},
                {5 ,6 ,2 ,2},
                {6 ,10,7, 8},
                {1 ,4 ,2 ,0}
            },
            {
                {36,0 ,18,9 ,9 ,45,27}, 
                {27,0 ,54,9 ,0 ,63,90}, 
                {81,63,72,45,18,27,0}, 
                {0 ,0 ,9 ,81,27,18,45}, 
                {45,45,27,27,90,81,72}, 
                {45,18,9 ,0 ,9 ,18,45}, 
                {27,81,36,63,63,72,81}
            }
        };
        int[][][] expectedOutputs = {
            {
                {1}
            },
            {
                {28}
            },
            {
                {40, 30}
            },
            {
                {5,4},
                {4,4}
            },
            {
                {39,30,26,25,31}, 
                {34,37,35,32,32}, 
                {38,41,44,46,42}, 
                {22,24,31,39,45}, 
                {37,34,36,47,59}
            }
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println("input:");
            printMatrix(inputs[i]);
            System.out.println("output:");
            printMatrix(boxBlur(inputs[i]));
            System.out.println("expected output:");
            printMatrix(expectedOutputs[i]);
            System.out.println();
        }
    }
}