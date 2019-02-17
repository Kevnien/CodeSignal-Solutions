

class AlphabeticShift{
    public static String alphabeticShift(String inputString){
        String answer = "";
        for(int i=0; i<inputString.length(); i++){
            char current = (char)(inputString.charAt(i) + 1);
            if(current == 'z'+1){
                answer += "a";
            }else{
                answer += current;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[] inputs = {
            "crazy",
            "z",
            "aaaabbbccd",
            "fuzzy",
            "codesignal"
        };
        String[] expectedOutputs = {
            "dsbaz",
            "a",
            "bbbbcccdde",
            "gvaaz",
            "dpeftjhobm"
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "alphabeticShift("+
                inputs[i]+"): "+
                alphabeticShift(inputs[i])+
                "\nexpected output: "+
                expectedOutputs[i]
            );
        }
    }
}