// Given the positions of a white bishop and a black pawn on the standard chess board, determine whether the bishop can capture the pawn in one move.

import java.lang.Math;
class BishopAndPawn{
    public static boolean bishopAndPawn(String bishop, String pawn){
        int columnDifference = Math.abs((int)(bishop.charAt(0)-pawn.charAt(0)));
        int rowDifference = Math.abs((int)(bishop.charAt(1)-pawn.charAt(1)));
        if(columnDifference == rowDifference){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String[][] inputs = {
            {"a1","c3"},
            {"h1","h3"},
            {"a5","c3"},
            {"g1","f3"},
            {"e7","d6"},
            {"e7","a3"},
            {"e3","a7"},
            {"a1","h8"},
            {"a1","h7"},
            {"h1","a8"}
        };
        boolean[] expectedOutputs = {
            true,
            false,
            true,
            false,
            true,
            true,
            true,
            true,
            false,
            true
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "bishopAndPawn("+
                inputs[i][0]+", "+
                inputs[i][1]+"):\n"+
                bishopAndPawn(inputs[i][0], inputs[i][1])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}