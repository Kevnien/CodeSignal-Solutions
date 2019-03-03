// Find the leftmost digit that occurs in a given string.

class FirstDigit{
    public static char firstDigit(String inputString){
        Character answer = null;
        for(int i=0; i<inputString.length(); i++){
            answer = inputString.charAt(i);
            if(isNotNum(answer)){
                continue;
            }else{
                return answer;
            }
        }
        return answer;
    }

    public static boolean isNotNum(char character){
        if(character>='0' && character<='9'){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args){
        String[] inputs = {
            "var_1__Int",
            "q2q-q",
            "0ss",
            "_Aas_23",
            "a a_933",
            "ok0"
        };
        char[] expectedOutputs = {
            '1',
            '2',
            '0',
            '2',
            '9',
            '0'
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "firstDigit("+
                inputs[i]+"):\n"+
                firstDigit(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}