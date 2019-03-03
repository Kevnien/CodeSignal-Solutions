

class LongestDigitsPrefix{
    public static String longestDgigitsPrefix(String inputString){
        String digitsPrefix = "";
        int length = inputString.length();
        for(int i=0; i<length; i++){
            char currentChar = inputString.charAt(i);
            if(isNum(currentChar)){
                digitsPrefix += currentChar;
            }else{
                break;
            }
        }
        return digitsPrefix;
    }

    public static boolean isNum(char character){
        if(character>='0' && character<='9'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        String[] inputs = {
            "123aa1",
            "0123456789",
            "  3) always check for whitespaces",
            "12abc34",
            "the output is 42",
            "aaaaaaa"
        };
        String[] expectedOutputs = {
            "123",
            "0123456789",
            "",
            "12",
            "",
            ""
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "longestDigitsPrefix("+
                inputs[i]+"):\n"+
                longestDgigitsPrefix(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}