// In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a number in it that indicates the total number of mines in the neighboring cells. Starting off with some arrangement of mines we want to create a Minesweeper game setup.
package islandofknowledge;
import islandofknowledge.BoxBlur;

class Minesweeper{
    public static int[][] minesweeper(boolean[][] matrix){
        int[][] answer = new int[matrix.length][matrix[0].length];
        for(int y=0; y<matrix.length; y++){
            for(int x=0; x<matrix[0].length; x++){
                int sum = 0;
                for(int subX=-1; subX<2; subX++){
                    for(int subY=-1; subY<2; subY++){
                        if(subX==0 && subY==0){
                            continue;
                        }
                        int coordinateX = x+subX;
                        if(coordinateX<0 || coordinateX>=matrix[0].length){
                            continue;
                        }
                        int coordinateY = y+subY;
                        if(coordinateY<0 || coordinateY>=matrix.length){
                            continue;
                        }
                        if(matrix[coordinateY][coordinateX]){
                            sum++;
                        }
                    }
                }
                answer[y][x] = sum;
            }
        }
        return answer;
    }

    public static void printMatrix(boolean[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        boolean[][][] inputs = {
            {
                {true,false,false}, 
                {false,true,false}, 
                {false,false,false}
            },
            {
                {false,false,false}, 
                {false,false,false}
            },
            {
                {true,false,false,true}, 
                {false,false,true,false}, 
                {true,true,false,true}
            },
            {
                {true,true,true}, 
                {true,true,true}, 
                {true,true,true}
            },
            {
                {false,true,true,false}, 
                {true,true,false,true}, 
                {false,false,true,false}
            },
            {
                {true,false}, 
                {true,false}, 
                {false,true}, 
                {false,false}, 
                {false,false}
            }
        };
        int[][][] expectedOutputs= {
            {
                {1,2,1}, 
                {2,1,1}, 
                {1,1,1}
            },
            {
                {0,0,0}, 
                {0,0,0}
            },
            {
                {0,2,2,1}, 
                {3,4,3,3}, 
                {1,2,3,1}
            },
            {
                {3,5,3}, 
                {5,8,5}, 
                {3,5,3}
            },
            {
                {3,3,3,2}, 
                {2,4,5,2}, 
                {2,3,2,2}
            },
            {
                {1,2}, 
                {2,3}, 
                {2,1}, 
                {1,1}, 
                {0,0}
            }
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println("input:");
            printMatrix(inputs[i]);
            System.out.println("output:");
            BoxBlur.printMatrix(minesweeper(inputs[i]));
            System.out.println("expected output:");
            BoxBlur.printMatrix(expectedOutputs[i]);
            System.out.println();
        }
    }
}