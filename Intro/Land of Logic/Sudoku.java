// Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with digits so that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid contains all of the digits from 1 to 9.

// This algorithm should check if the given grid of numbers represents a correct solution to Sudoku.

class Sudoku{
    public static boolean sudoku(int[][] grid){
        int[][] numbers = {{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0},{9,0}};
        // check each row for unique numbers
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(numbers[grid[i][j]-1][1] == 0){
                    numbers[grid[i][j]-1][1] = 1;
                    continue;
                }
                return false;
            }
            reset(numbers);
        }
        // check each column for unqiue numbers
        for(int i=0; i<grid[0].length; i++){
            for(int j=0; j<grid.length; j++){
                if(numbers[grid[j][i]-1][1] == 0){
                    numbers[grid[j][i]-1][1] = 1;
                    continue;
                }
                return false;
            }
            reset(numbers);
        }
        // check each 3x3 square for unique numbers
        for(int i=0; i<grid.length; i+=3){
            for(int j=0; j<grid[i].length; j+=3){
                for(int y=i; y<i+3; y++){
                    for(int x=j; x<j+3; x++){
                        if(numbers[grid[y][x]-1][1] == 0){
                            numbers[grid[y][x]-1][1] = 1;
                            continue;
                        }
                        return false;
                    }
                }
                reset(numbers);
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][][][] inputsOutputs = {
            {
                {
                    {1,3,2,5,4,6,9,8,7}, 
                    {4,6,5,8,7,9,3,2,1}, 
                    {7,9,8,2,1,3,6,5,4}, 
                    {9,2,1,4,3,5,8,7,6}, 
                    {3,5,4,7,6,8,2,1,9}, 
                    {6,8,7,1,9,2,5,4,3}, 
                    {5,7,6,9,8,1,4,3,2}, 
                    {2,4,3,6,5,7,1,9,8}, 
                    {8,1,9,3,2,4,7,6,5}
                },
                {
                    {1}
                }
            },
            {
                {
                    {1,3,2,5,4,6,9,2,7}, 
                    {4,6,5,8,7,9,3,8,1}, 
                    {7,9,8,2,1,3,6,5,4}, 
                    {9,2,1,4,3,5,8,7,6}, 
                    {3,5,4,7,6,8,2,1,9}, 
                    {6,8,7,1,9,2,5,4,3}, 
                    {5,7,6,9,8,1,4,3,2}, 
                    {2,4,3,6,5,7,1,9,8}, 
                    {8,1,9,3,2,4,7,6,5}
                },
                {
                    {0}
                }
            },
            {
                {
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {1,2,3,4,5,6,7,8,9}
                },
                {
                    {0}
                }
            },
            {
                {
                    {1,3,4,2,5,6,9,8,7}, 
                    {4,6,8,5,7,9,3,2,1}, 
                    {7,9,2,8,1,3,6,5,4}, 
                    {9,2,3,1,4,5,8,7,6}, 
                    {3,5,7,4,6,8,2,1,9}, 
                    {6,8,1,7,9,2,5,4,3}, 
                    {5,7,6,9,8,1,4,3,2}, 
                    {2,4,5,6,3,7,1,9,8}, 
                    {8,1,9,3,2,4,7,6,5}
                },
                {
                    {0}
                }
            },
            {
                {
                    {1,3,2,5,4,6,9,8,7}, 
                    {4,6,5,8,7,9,3,2,1}, 
                    {7,9,8,2,1,3,6,5,4}, 
                    {9,2,1,4,3,5,8,7,6}, 
                    {3,5,4,7,6,8,2,1,9}, 
                    {6,8,7,1,9,2,5,4,3}, 
                    {5,4,6,9,8,1,4,3,2}, 
                    {2,7,3,6,5,7,1,9,8}, 
                    {8,1,9,3,2,4,7,6,5}
                },
                {
                    {0}
                }
            },
            {
                {
                    {1,2,3,4,5,6,7,8,9}, 
                    {4,6,5,8,7,9,3,2,1}, 
                    {7,9,8,2,1,3,6,5,4}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {4,6,5,8,7,9,3,2,1}, 
                    {7,9,8,2,1,3,6,5,4}, 
                    {1,2,3,4,5,6,7,8,9}, 
                    {4,6,5,8,7,9,3,2,1}, 
                    {7,9,8,2,1,3,6,5,4}
                },
                {
                    {0}
                }
            },
            {
                {
                    {5,3,4,6,7,8,9,1,2}, 
                    {6,7,2,1,9,5,3,4,8}, 
                    {1,9,8,3,4,2,5,6,7}, 
                    {8,5,9,9,6,1,4,2,3}, 
                    {4,2,6,8,5,3,7,9,1}, 
                    {7,1,3,7,2,4,8,5,6}, 
                    {9,6,1,5,3,7,2,8,4}, 
                    {2,8,7,4,1,9,6,3,5}, 
                    {3,4,5,2,8,6,1,7,9}
                },
                {
                    {0}
                }
            },
            {
                {
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}, 
                    {5,5,5,5,5,5,5,5,5}
                },
                {
                    {0}
                }
            },
            {
                {
                    {5,3,4,6,7,8,9,1,2}, 
                    {6,7,2,3,9,5,3,4,8}, 
                    {1,9,8,1,4,2,5,6,7}, 
                    {8,5,9,7,6,1,4,2,3}, 
                    {4,2,6,8,5,3,7,9,1}, 
                    {7,1,3,9,2,4,8,5,6}, 
                    {9,6,1,5,3,7,2,8,4}, 
                    {2,8,7,4,1,9,6,3,5}, 
                    {3,4,5,2,8,6,1,7,9}
                },
                {
                    {0}
                }
            },
            {
                {
                    {5,3,4,6,7,8,9,1,2}, 
                    {6,7,2,1,9,5,3,4,8}, 
                    {1,9,8,3,4,2,5,6,7}, 
                    {8,5,9,7,6,1,4,2,3}, 
                    {4,2,6,8,5,3,7,9,1}, 
                    {7,1,3,9,2,4,8,5,6}, 
                    {9,6,1,5,3,7,2,8,4}, 
                    {2,5,7,4,1,9,6,3,5}, 
                    {3,4,5,2,8,6,1,7,9}
                },
                {
                    {0}
                }
            },
            {
                {
                    {1,2,3,4,5,6,7,8,9}, 
                    {4,5,6,7,8,9,1,2,3}, 
                    {7,8,9,1,2,3,4,5,6}, 
                    {2,3,4,5,6,7,8,9,1}, 
                    {3,4,5,6,7,8,9,1,2}, 
                    {5,6,7,8,9,1,2,3,4}, 
                    {6,7,8,9,1,2,3,4,5}, 
                    {8,9,1,2,3,4,5,6,7}, 
                    {9,1,2,3,4,5,6,7,8}
                },
                {
                    {0}
                }
            }
        };
        for(int[][][] pair: inputsOutputs){
            boolean answer = sudoku(pair[0]);
            boolean bool = true;
            if(pair[1][0][0] == 0){
                bool = false;
            }
            System.out.print(
                "sudoku(\n"+
                matrixToString(pair[0])+"):\n"+
                answer+"\n"+
                bool+" <-- expected output "
            );
            if((answer==true && pair[1][0][0]==0) || (answer==false && pair[1][0][0]==1)){
                System.out.println("FAILED");
            }else{
                System.out.println("PASSED");
            }
        }
    }

    public static String matrixToString(int[][] matrix){
        String answer = "";
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                answer += matrix[i][j];
                if(j == matrix.length-1){
                    answer += "\n";
                    continue;
                }
                answer += ", ";
            }
        }
        return answer;
    }

    public static void reset(int[][] numbers){
        for(int i=0; i<numbers.length; i++){
            numbers[i][1] = 0;
        }
    }
}