// Given a character, check if it represents an odd digit, an even digit or not a digit at all.

class CharacterParity{
    public static String characterParity(char symbol){
        if(symbol>='0' && symbol<='9'){
            int value = Integer.valueOf(symbol);
            if(value%2 == 0){
                return "even";
            }else{
                return "odd";
            }
        }
        return "not a digit";
    }

    public static void main(String[] args){
        String[][] inputsOutputs = {
            {
                "5",
                "odd"
            },
            {
                "8",
                "even"
            },
            {
                "q",
                "not a digit"
            }
        };
        for(String[] pair: inputsOutputs){
            String answer = characterParity(pair[0].charAt(0));
            System.out.print(
                "characterParity("+pair[0]+"):\n"+
                answer+"\n"+
                pair[1]+" <-- expected output"
            );
            String expected = pair[1];
            if(expected == answer){
                System.out.println(" PASSED");
            }else{
                System.out.println(" FAILED");
            }
        }
    }
}