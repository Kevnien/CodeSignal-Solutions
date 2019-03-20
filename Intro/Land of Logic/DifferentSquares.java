// Given a rectangular matrix containing only digits, calculate the number of different 2 × 2 squares in it.

import java.util.HashMap;;
class DifferentSquares{
    public static int differentSquares(int[][] matrix){
        HashMap<MatrixObject, Integer> map = new HashMap<MatrixObject, Integer>();
        int total = 0;
        for(int i=0; i<matrix.length-1; i++){
            for(int j=0; j<matrix[i].length-1; j++){
                int[][] twoSquare = new int[2][2];
                twoSquare[0][0] = matrix[i][j];
                twoSquare[0][1] = matrix[i][j+1];
                twoSquare[1][0] = matrix[i+1][j];
                twoSquare[1][1] = matrix[i+1][j+1];
                MatrixObject matrixObject = new MatrixObject(twoSquare);
                if(map.containsKey(matrixObject)){
                    continue;
                }
                map.put(matrixObject, 0);
                total++;
            }
        }
        return total;
    }

    public static class MatrixObject{
        int[][] matrix;
        MatrixObject(int[][] matrix){
            this.matrix = matrix;
        }
        public boolean equals(Object matrix2){
            MatrixObject matrixObject = (MatrixObject) matrix2;
            int[][] matrix = matrixObject.matrix;
            if(matrix.length != this.matrix.length){
                System.out.println("column length not eqaul");
                return false;
            }
            for(int i=0; i<matrix.length; i++){
                if(matrix[i].length != this.matrix[i].length){
                    System.out.println("row length not equal");
                    return false;
                }
                for(int j=0; j<matrix[i].length; j++){
                    if(matrix[i][j] != this.matrix[i][j]){
                        System.out.println(matrix[i][j]+" not equal to "+this.matrix[i][j]);
                        return false;
                    }
                }
            }
            return true;
        }
        public int hashCode(){
            String string = "";
            for(int i=0; i<this.matrix.length; i++){
                for(int j=0; j<this.matrix[i].length; j++){
                    string += i;
                    string += j;
                    string += this.matrix[i][j] + ",";
                }
            }
            return string.hashCode();
        }
        public void print(){
            for(int i=0; i<this.matrix.length; i++){
                for(int j=0; j<this.matrix[i].length; j++){
                    System.out.print(this.matrix[i][j]+",");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        int[][][][] inputOutputs = {
            {
                {
                    {1,2,1},
                    {2,2,2},
                    {2,2,2},
                    {1,2,3},
                    {2,2,1}
                },
                {
                    {6}
                }
            },
            {
                {
                    {9,9,9,9,9},
                    {9,9,9,9,9},
                    {9,9,9,9,9},
                    {9,9,9,9,9},
                    {9,9,9,9,9},
                    {9,9,9,9,9}
                },
                {
                    {1}
                }
            },
            {
                {
                    {3}
                },
                {
                    {0}
                }
            },
            {
                {
                    {3,4,5,6,7,8,9}
                },
                {
                    {0}
                }
            },
            {
                {
                    {3},
                    {4},
                    {5},
                    {6},
                    {7}
                },
                {
                    {0}
                }
            },
            {
                {
                    {2,5,3,4,3,1,3,2},
                    {4,5,4,1,2,4,1,3},
                    {1,1,2,1,4,1,1,5},
                    {1,3,4,2,3,4,2,4},
                    {1,5,5,2,1,3,1,1},
                    {1,2,3,3,5,1,2,4},
                    {3,1,4,4,4,1,5,5},
                    {5,1,3,3,1,5,3,5},
                    {5,4,4,3,5,4,4,4}
                },
                {
                    {54}
                }
            },
            {
                {
                    {1,1,1,1,1,1,2,2,2,3,3,3,9,9,9,2,3,9}
                },
                {
                    {0}
                }
            }
        };
        int index = 0;
        for(int[][][] matrixArray:inputOutputs){
            int answer = differentSquares(matrixArray[0]);
            System.out.print(
                "differentSquares("+index+"):\n"+
                answer+"\n"+
                matrixArray[1][0][0]+" <-- expected output"
            );
            index++;
            String end = "";
            if(answer == matrixArray[1][0][0]){
                end = " PASSED";
            }else{
                end = " FAILED";
            }
            System.out.println(end);
        }
    }
}