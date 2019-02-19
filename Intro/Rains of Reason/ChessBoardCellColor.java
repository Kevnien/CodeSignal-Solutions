// Given two cells on the standard chess board, determine whether they have the same color or not.

class ChessBoardCellColor{
    public static boolean chessBoardCellColor(String cell1, String cell2){
        int columnDifference = (int)(cell1.charAt(0) - cell2.charAt(0));
        int rowDifference = (int)(cell1.charAt(1) - cell2.charAt(1));
        int rowDifferenceModded = rowDifference%2;
        int columnDifferenceModded = columnDifference%2;
        if(rowDifferenceModded<0){
            rowDifferenceModded *= -1;
        }
        if(columnDifferenceModded<0){
            columnDifferenceModded *= -1;
        }
        if(columnDifferenceModded == 1){
            if(rowDifferenceModded == 0){
                return false;
            }
        }else{
            if(rowDifferenceModded == 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[][] inputs = {
            {"A1","C3"},
            {"A1","H3"},
            {"A1","A2"},
            {"A1","B2"},
            {"B3","H8"},
            {"C3","B5"},
            {"G5","E7"},
            {"C8","H8"},
            {"D2","D2"},
            {"A2","A5"}
        };
        boolean[] expectedOutputs = {
            true,
            false,
            false,
            true,
            false,
            false,
            true,
            false,
            true,
            false
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "chessBoardCellColor("+
                inputs[i][0]+", "+
                inputs[i][1]+"): "+
                chessBoardCellColor(inputs[i][0], inputs[i][1])+
                "\nexpected output:"+
                expectedOutputs[i]
            );
        }
    }
}