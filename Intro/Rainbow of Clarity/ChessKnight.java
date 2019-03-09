// Given a position of a knight on the standard chessboard, find the number of different moves the knight can perform.

// The knight can move to a square that is two squares horizontally and one square vertically, or two squares vertically and one square horizontally away from it. The complete move therefore looks like the letter L. Check out the image below to see all valid moves for a knight piece that is placed on one of the central squares.

class ChessKnight{
    public static int chessKnight(String cell){
        int[] spaces = {-2 , 2, 1, -1};
        int x = cell.charAt(0)-'a';
        int y = cell.charAt(1)-'1';
        int total = 0;
        for(int i=0; i<4; i++){
            // up/down first
            y += spaces[i];
            if(y<0 || y>7){
                y -= spaces[i];
                continue;
            }else{
                // now turn
                if(i<2){
                    x++;
                    if(x>=0 && x<=7){
                        total++;
                    }
                    x -= 2;
                    if(x>=0 && x<=7){
                        total++;
                    }
                    x++;
                }else{
                    x += 2;
                    if(x>=0 && x<=7){
                        total++;
                    }
                    x -= 4;
                    if(x>=0 && x<=7){
                        total++;
                    }
                    x += 2;
                }
            }
            y -= spaces[i];
        }
        return total;
    }

    public static void main(String[] args){
        String[] inputs = {
            "a1",
            "c2",
            "d4",
            "g6",
            "a3",
            "b7",
            "h8",
            "h6",
            "g8",
            "a5"
        };
        int[] expectedOutputs = {
            2,
            6,
            8,
            6,
            4,
            4,
            2,
            4,
            3,
            4
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "chessKnight("+
                inputs[i]+"):\n"+
                chessKnight(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}