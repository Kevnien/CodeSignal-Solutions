// After they became famous, the CodeBots all decided to move to a new building and live together. The building is represented by a rectangular matrix of rooms. Each cell in the matrix contains an integer that represents the price of the room. Some rooms are free (their cost is 0), but that's probably because they are haunted, so all the bots are afraid of them. That is why any room that is free or is located anywhere below a free room in the same column is not considered suitable for the bots to live in.

// Help the bots calculate the total price of all the rooms that are suitable for them.
class MatricElementsSum{
    int matrixElementsSum(int[][] matrix) {
        int total = 0;
        for(int j=0; j<matrix[0].length; j++){
            total += matrix[0][j];
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                boolean abort = false;
                for(int k=i-1; k>=0; k--){
                    if(matrix[k][j] == 0){
                        abort = true;
                        break;
                    }
                }
                if(abort){
                    continue;
                }
                total += matrix[i][j];
            }
        }
        return total;
    }


}    
