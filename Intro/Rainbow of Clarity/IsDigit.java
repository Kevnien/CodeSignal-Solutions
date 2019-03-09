// Determine if the given character is a digit or not.

class IsDigit{
    public static boolean isDigit(char symbol){
        int digitsIndex = symbol-'0';
        if(digitsIndex<0 || digitsIndex>9){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        char[] inputs = {
            '0',
            '-',
            'O',
            '1',
            '2',
            '!',
            '@',
            '+',
            '6',
            '(',
            ')'
        };
        boolean[] expectedOutputs = {
            true,
            false,
            false,
            true,
            true,
            false,
            false,
            false,
            true,
            false,
            false
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "isDigit("+
                inputs[i]+"):\n"+
                isDigit(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}